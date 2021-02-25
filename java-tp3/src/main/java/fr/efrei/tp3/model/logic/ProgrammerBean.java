package fr.efrei.tp3.model.logic;

import fr.efrei.tp3.view.widgets.table.DisplayAs;

import java.time.LocalDate;

/**
 * The type Programmer bean.
 * This class represents a programmer and it's data in the application
 */
public class ProgrammerBean {

    private int personalNumber;
    private String lastName;
    private String firstName;
    private String address;
    private String username;
    private String manager;
    private String hobby;
    private LocalDate birthDate;
    private LocalDate hireDate;

    /**
     * Instantiates a new Programmer bean.
     *
     * @param personalNumber the personal number
     * @param lastName       the last name
     * @param firstName      the first name
     * @param address        the address
     * @param username       the username
     * @param manager        the manager
     * @param hobby          the hobby
     * @param birthDate      the birth date
     * @param hireDate       the hire date
     */
    public ProgrammerBean(int personalNumber, String lastName, String firstName, String address, String username,
            String manager, String hobby, LocalDate birthDate, LocalDate hireDate) {
        this.personalNumber = personalNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.username = username;
        this.manager = manager;
        this.hobby = hobby;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    /**
     * Gets personal number.
     *
     * @return the personal number
     */
    @DisplayAs(value = "Number", index = 0)
    public int getpersonalNumber() {
        return personalNumber;
    }

    /**
     * Sets personal number.
     *
     * @param personalNumber the personal number
     */
    public void setpersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    @DisplayAs(value = "Last name", index = 1)
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    @DisplayAs(value = "First name", index = 2)
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    @DisplayAs(value = "Adresse", index = 3)
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    @DisplayAs(value = "Username", index = 4)
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets manager.
     *
     * @return the manager
     */
    @DisplayAs(value = "Manager", index = 5)
    public String getManager() {
        return manager;
    }

    /**
     * Sets manager.
     *
     * @param manager the manager
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Gets hobby.
     *
     * @return the hobby
     */
    @DisplayAs(value = "Hobby", index = 6)
    public String getHobby() {
        return hobby;
    }

    /**
     * Sets hobby.
     *
     * @param hobby the hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    @DisplayAs(value = "Birth date", index = 7)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birth date.
     *
     * @param birthDate the birth date
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets hire date.
     *
     * @return the hire date
     */
    @DisplayAs(value = "Hire Date", index = 8)
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     * Sets hire date.
     *
     * @param hireDate the hire date
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return personalNumber + " " + lastName + " " + firstName + " " + address + " " + username + " " + manager + " "
                + hobby + " " + birthDate + " " + hireDate + "\n";
    }
}
