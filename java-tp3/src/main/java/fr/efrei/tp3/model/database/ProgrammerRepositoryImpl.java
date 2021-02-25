
package fr.efrei.tp3.model.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.efrei.tp3.LoggerManager;
import fr.efrei.tp3.model.logic.ProgrammerBean;
import fr.efrei.tp3.model.logic.ProgrammerRepository;

/**
 * The type Programmer repository. Implementation of programmer repository that
 * stores programmers in the Postgres Database
 */
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

    private Connection connection;

    /**
     * Instantiates a new Programmer repository. Use the Postgres singleton the get
     * the connection to our PostgreSQL instance
     */
    public ProgrammerRepositoryImpl() {
        this.connection = Postgres.getINSTANCE().getConnection();
    }

    @Override
    public List<ProgrammerBean> findAll() {
        LinkedList<ProgrammerBean> programmers = new LinkedList<>();

        try (Statement statement = this.connection.createStatement();
                ResultSet result = statement.executeQuery(Queries.FIND_ALL);) {
            while (result.next()) {
                programmers.add(this.createProgrammerBeanFromResult(result));
            }
        } catch (SQLException e) {
            LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
        }

        return programmers;
    }

    @Override
    public List<ProgrammerBean> findByName(String name) {

        List<ProgrammerBean> list = new ArrayList<>();

        try (PreparedStatement statement = this.connection.prepareStatement(Queries.FIND_BY_NAME)) {
            statement.setString(1, name);
            try (ResultSet result = statement.executeQuery();) {
                while (result.next()) {
                    list.add(this.createProgrammerBeanFromResult(result));
                }
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("No programmer with such name");
                }
            }
        } catch (SQLException e) {
            LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
        }

        return list;
    }

    @Override
    public ProgrammerBean findById(int personalNumber) {
        try (PreparedStatement statement = this.connection.prepareStatement(Queries.FIND_BY_ID)) {
            statement.setString(1, Integer.toString(personalNumber));
            try (ResultSet result = statement.executeQuery();) {
                if (result.next()) {
                    return this.createProgrammerBeanFromResult(result);
                } else {
                    throw new IllegalArgumentException("No programmer with such id");
                }
            }
        } catch (SQLException e) {
            LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
            return null;
        }

    }

    @Override
    public void insert(ProgrammerBean bean) {
        // Checks if a programmer with this personal number exists
        boolean exists = false;
        try (PreparedStatement count = this.connection.prepareStatement(Queries.COUNT);) {
            count.setString(1, String.valueOf(bean.getpersonalNumber()));
            ResultSet countResult = count.executeQuery();
            countResult.next();
            exists = countResult.getInt("total") != 0;
        } catch (SQLException e) {
            LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
        }

        // If no such programmer exists the new programmer is inserted
        if (!exists) {
            try (PreparedStatement statement = this.connection.prepareStatement(Queries.INSERT)) {

                statement.setInt(1, bean.getpersonalNumber());
                statement.setString(2, bean.getLastName());
                statement.setString(3, bean.getFirstName());
                statement.setString(4, bean.getAddress());
                statement.setString(5, bean.getUsername());
                statement.setString(6, bean.getManager());
                statement.setString(7, bean.getHobby());
                statement.setDate(8, Date.valueOf(bean.getBirthDate()));
                statement.setDate(9, Date.valueOf(bean.getHireDate()));
                statement.execute();
            } catch (SQLException e) {
                LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
            }
        } else { // If the personal number is already used, throws an exception
            throw new IllegalArgumentException("This personal number is already used");
        }
    }

    @Override
    public void update(ProgrammerBean bean) {
        try (PreparedStatement statement = this.connection.prepareStatement(Queries.UPDATE);) {

            statement.setString(1, Integer.toString(bean.getpersonalNumber()));
            statement.setString(2, bean.getLastName());
            statement.setString(3, bean.getFirstName());
            statement.setString(4, bean.getAddress());
            statement.setString(5, bean.getUsername());
            statement.setString(6, bean.getManager());
            statement.setString(7, bean.getHobby());
            statement.setDate(8, Date.valueOf(bean.getBirthDate()));
            statement.setDate(9, Date.valueOf(bean.getBirthDate()));
            statement.setString(10, Integer.toString(bean.getpersonalNumber()));

            statement.execute();
        } catch (SQLException e) {
            LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
        }
    }

    @Override
    public void delete(int personalNumber) {
        // Checking if the programmer exists
        boolean exists = false;
        try (PreparedStatement count = this.connection.prepareStatement(Queries.COUNT);) {

            count.setString(1, String.valueOf(personalNumber));
            try (ResultSet countResult = count.executeQuery();) {
                countResult.next();
                exists = countResult.getInt("total") > 0;
            }

        } catch (SQLException e) {
            LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
        }

        // If it exists, deletes it
        if (exists) {
            try (PreparedStatement statement = this.connection.prepareStatement(Queries.DELETE)) {

                statement.setString(1, String.valueOf(personalNumber));

                statement.execute();
            } catch (SQLException e) {
                LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
            }
        } else { // If the programmer doesn't exists throws an exception
            throw new IllegalArgumentException("No programmer with such personal number");
        }
    }

    /**
     * Extract a programmer from a query result
     *
     * @param result JDBC result set of a query which fetches a programmer
     * @return A programmer bean object corresponding to the results
     * @throws SQLException If the result set does not contains the infos of a
     *                      programmer
     */
    private ProgrammerBean createProgrammerBeanFromResult(ResultSet result) throws SQLException {
        int personalNumber = result.getInt("matricule");
        String lastName = result.getString("nom");
        String firstName = result.getString("prenom");
        String address = result.getString("adresse");
        String username = result.getString("pseudo");
        String manager = result.getString("responsable");
        String hobby = result.getString("hobby");
        LocalDate birthDate = result.getDate("date_naiss").toLocalDate();
        LocalDate embDate = result.getDate("date_emb").toLocalDate();

        return new ProgrammerBean(personalNumber, lastName, firstName, address, username, manager, hobby, birthDate,
                embDate);
    }
}
