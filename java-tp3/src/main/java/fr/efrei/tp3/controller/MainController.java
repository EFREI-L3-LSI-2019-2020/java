package fr.efrei.tp3.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import fr.efrei.tp3.LoggerManager;
import fr.efrei.tp3.model.logic.ProgrammerBean;
import fr.efrei.tp3.model.logic.ProgrammerRepository;
import fr.efrei.tp3.view.ViewManager;

/**
 * The type Main controller.
 */
public class MainController {

    private ProgrammerRepository model;
    private ViewManager view;

    private enum EDIT_MODE {
        /**
         * Modify edit mode.
         */
        MODIFY,
        /**
         * Delete edit mode.
         */
        DELETE,
        /**
         * Add edit mode.
         */
        ADD
    }

    private EDIT_MODE mode;

    /**
     * Instantiates a new Main controller.
     *
     * @param view  the view
     * @param model the model
     */
    public MainController(ViewManager view, ProgrammerRepository model) {
        this.view = view;
        this.model = model;

        // Binding controller's event handlers to buttons
        this.view.getLeaveMenuItem().addActionListener(this::handleClickLeave);
        this.view.getAddMenuItem().addActionListener(this::handleClickProgrammerAdd);
        this.view.getModifyMenuItem().addActionListener(this::handleClickProgrammerModify);
        this.view.getDeleteMenuItem().addActionListener(this::handleClickProgrammerDelete);
        this.view.getProgrammerMenuDisplayAll().addActionListener(this::handleClickProgrammerDisplay);
        this.view.getValidationButton().addActionListener(this::handleValidate);
        this.view.getCancelButton().addActionListener(this::handleCancel);
        this.view.getSearchButton().addActionListener(this::handleSearch);
    }

    /**
     * Handle click on exit button
     */
    private void handleClickLeave(ActionEvent e) {
        if (confirmationAction("Exit Program Message Box", "Are you sure you want to exit the program?")) {
            System.exit(0);
        }

    }

    private void handleClickProgrammerAdd(ActionEvent e) {
        this.resetForm();
        this.view.getSearchButton().setEnabled(false);
        this.view.getValidationButton().setEnabled(true);
        this.view.getResetButton().setEnabled(true);

        for (Component component : this.view.getFormComponents()) {
            component.setEnabled(true);
        }
        this.view.getResetButton().setEnabled(false);
        this.mode = EDIT_MODE.ADD;
        this.showEdit();

    }

    private void handleClickProgrammerModify(ActionEvent e) {
        this.resetForm();
        this.view.getSearchButton().setEnabled(true);
        this.view.getValidationButton().setEnabled(false);
        this.view.getResetButton().setEnabled(false);

        this.mode = EDIT_MODE.MODIFY;
        for (Component component : this.view.getFormComponents()) {
            component.setEnabled(true);
        }
        this.view.getSearchButton().setEnabled(true);
        this.view.getValidationButton().setEnabled(false);
        this.showEdit();
    }

    private void handleClickProgrammerDelete(ActionEvent e) {
        this.resetForm();
        this.view.getSearchButton().setEnabled(true);
        this.view.getValidationButton().setEnabled(true);
        this.view.getResetButton().setEnabled(false);

        for (Component component : this.view.getFormComponents()) {
            component.setEnabled(false);
        }
        this.view.getSearchButton().setEnabled(false);
        this.view.getResetButton().setEnabled(false);
        this.mode = EDIT_MODE.DELETE;
        this.showEdit();
    }

    private void handleClickProgrammerDisplay(ActionEvent e) {
        this.resetForm();
        this.view.remove(this.view.getEditPanel());
        this.view.remove(this.view.getMainPanel());
        this.view.add(this.view.getDisplayPanel());
        this.view.validate();
        this.view.repaint();

        List<ProgrammerBean> programmers = this.model.findAll(); // Recover all programmers
        this.view.storeProgrammersIntoRow(programmers); // Set all programmers to the table
    }

    private void handleValidate(ActionEvent e) {
        switch (this.mode) {
        case ADD:
            try {

                // Getting form
                int personalNumber = Integer.parseInt(this.view.getPersonalNumberField().getText());
                String lastName = this.view.getFormLastNameField().getText();
                String firstName = this.view.getFormFirstNameField().getText();
                String address = this.view.getFormAddressField().getText();
                String username = this.view.getFormUsernameField().getText();
                String manager = this.view.getFormManagerField().getText();
                String hobby = this.view.getFormHobbyField().getText();

                LocalDate birthDate = LocalDate.of(Integer.parseInt(this.view.getFormBirthYearField().getText()),
                        Integer.parseInt(this.view.getFormBirthMonthField().getSelectedItem().toString()),
                        Integer.parseInt(this.view.getFormBirthDayField().getText()));
                LocalDate embDate = LocalDate.of(Integer.parseInt(this.view.getFormHireYearField().getText()),
                        Integer.parseInt(this.view.getFormHireMonthField().getSelectedItem().toString()),
                        Integer.parseInt(this.view.getFormHireDayField().getText()));
                checkDate(birthDate, embDate);
                ProgrammerBean programmer = new ProgrammerBean(personalNumber, lastName, firstName, address, username,
                        manager, hobby, birthDate, embDate);

                // Persist the created programmer
                this.model.insert(programmer);
                JOptionPane.showMessageDialog(this.view, "Programmer Inserted", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (DateTimeException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(this.view, "Form is invalid", "Error", JOptionPane.ERROR_MESSAGE);
                LoggerManager.getInstanceLogger().getLogger().debug(exception.getMessage());
            } catch (IllegalArgumentException exception) {
                JOptionPane.showMessageDialog(this.view, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                LoggerManager.getInstanceLogger().getLogger().debug(exception.getMessage());
            }
            break;
        case DELETE:
            // Confirmation modal
            if (!confirmationAction("Delete programmer ?", "This action will delete the programmer.")) {
                return;
            }
            try {
                // Delete programmer in the repository
                this.model.delete(Integer.parseInt(this.view.getPersonalNumberField().getText()));
                JOptionPane.showMessageDialog(this.view, "Programmer Deleted", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException exception) {
                LoggerManager.getInstanceLogger().getLogger().debug(exception.getMessage());
                JOptionPane.showMessageDialog(this.view, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;
        case MODIFY:
            // Confirmation modal
            if (!confirmationAction("Update programmer ?", "This action will update the programmer.")) {
                return;
            }

            // Getting form
            int personalNumberEdit = Integer.parseInt(this.view.getPersonalNumberField().getText());
            String lastNameEdit = this.view.getFormLastNameField().getText();
            String firstNameEdit = this.view.getFormFirstNameField().getText();
            String addressEdit = this.view.getFormAddressField().getText();
            String usernameEdit = this.view.getFormUsernameField().getText();
            String managerEdit = this.view.getFormManagerField().getText();
            String hobbyEdit = this.view.getFormHobbyField().getText();

            LocalDate birthDateEdit = LocalDate.of(Integer.parseInt(this.view.getFormBirthYearField().getText()),
                    Integer.parseInt(this.view.getFormBirthMonthField().getSelectedItem().toString()),
                    Integer.parseInt(this.view.getFormBirthDayField().getText()));
            LocalDate embDateEdit = LocalDate.of(Integer.parseInt(this.view.getFormHireYearField().getText()),
                    Integer.parseInt(this.view.getFormHireMonthField().getSelectedItem().toString()),
                    Integer.parseInt(this.view.getFormHireDayField().getText()));
            ProgrammerBean programmerEdit = new ProgrammerBean(personalNumberEdit, lastNameEdit, firstNameEdit,
                    addressEdit, usernameEdit, managerEdit, hobbyEdit, birthDateEdit, embDateEdit);
            try {
                // Check that date input is valid
                checkDate(birthDateEdit, embDateEdit);
                // Update programmer in the repository
                this.model.update(programmerEdit);
                JOptionPane.showMessageDialog(this.view, "Programmer Updated", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (DateTimeException | NumberFormatException exception) {
                JOptionPane.showMessageDialog(this.view, "Form is invalid", "Error", JOptionPane.ERROR_MESSAGE);
                LoggerManager.getInstanceLogger().getLogger().debug(exception.getMessage());
            } catch (IllegalArgumentException exception) {
                JOptionPane.showMessageDialog(this.view, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                LoggerManager.getInstanceLogger().getLogger().debug(exception.getMessage());
            }
            break;
        }
    }

    private void handleSearch(ActionEvent e) {

        try {
            int personalNumber = Integer.parseInt(this.view.getPersonalNumberField().getText());
            ProgrammerBean programmer = this.model.findById(personalNumber);

            // Filling form
            this.view.getFormLastNameField().setText(programmer.getLastName());
            this.view.getFormFirstNameField().setText(programmer.getFirstName());
            this.view.getFormAddressField().setText(programmer.getAddress());
            this.view.getFormUsernameField().setText(programmer.getUsername());
            this.view.getFormManagerField().setText(programmer.getManager());
            this.view.getFormHobbyField().setText(programmer.getHobby());
            this.view.getFormBirthDayField().setText(Integer.toString(programmer.getBirthDate().getDayOfMonth()));
            this.view.getFormBirthMonthField()
                    .setSelectedItem(Integer.toString(programmer.getBirthDate().getMonthValue()));
            this.view.getFormBirthYearField().setText(Integer.toString(programmer.getBirthDate().getYear()));
            this.view.getFormHireDayField().setText(Integer.toString(programmer.getHireDate().getDayOfMonth()));
            this.view.getFormHireMonthField()
                    .setSelectedItem(Integer.toString(programmer.getHireDate().getMonthValue()));
            this.view.getFormHireYearField().setText(Integer.toString(programmer.getHireDate().getYear()));

            this.view.getValidationButton().setEnabled(true);

        } catch (IllegalArgumentException exception) {
            LoggerManager.getInstanceLogger().getLogger().debug(exception.getMessage());
            JOptionPane.showMessageDialog(this.view, "No programmer with such id", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleCancel(ActionEvent e) {
        this.showMain();
    }

    private void showEdit() {
        this.view.remove(this.view.getMainPanel());
        this.view.remove(this.view.getDisplayPanel());
        this.view.add(this.view.getEditPanel());
        this.view.validate();
        this.view.repaint();
    }

    private void showMain() {
        this.view.add(this.view.getMainPanel());
        this.view.remove(this.view.getDisplayPanel());
        this.view.remove(this.view.getEditPanel());
        this.view.validate();
        this.view.repaint();
    }

    private void resetForm() {
        this.view.getPersonalNumberField().setText("");
        this.view.getFormLastNameField().setText("");
        this.view.getFormFirstNameField().setText("");
        this.view.getFormAddressField().setText("");
        this.view.getFormUsernameField().setText("");
        this.view.getFormManagerField().setText("");
        this.view.getFormHobbyField().setText("");

        this.view.getFormBirthDayField().setText("");
        this.view.getFormBirthMonthField().setSelectedIndex(0);
        this.view.getFormBirthYearField().setText("");

        this.view.getFormHireDayField().setText("");
        this.view.getFormHireMonthField().setSelectedIndex(0);
        this.view.getFormHireYearField().setText("");
    }

    /**
     Check date if future and check if birth date is before hire date
    */
    private void checkDate(LocalDate d1, LocalDate d2) throws IllegalArgumentException {
        LocalDate today = LocalDate.now();
        if (d1.isAfter(today) || d2.isAfter(today) || !d1.isBefore(d2))
            throw new IllegalArgumentException("Invalid date");
    }

    /**
     * View manager for confirmation action. Return bool depending on answer
     */
    private boolean confirmationAction(String title, String msg) {
        int confirmed = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);

        return confirmed == JOptionPane.YES_OPTION;
    }
}