package fr.efrei.tp3.view;

import fr.efrei.tp3.model.logic.ProgrammerBean;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Abstract class that represents an abstract view of the application
 * This class establishes a service contract for the controller to interact with the view
 */
public abstract class ViewManager extends JFrame {

    public ViewManager(String title){
        super(title);
    }

    // Menu
    public abstract JMenuItem getLeaveMenuItem();
    public abstract JMenuItem getAddMenuItem();
    public abstract JMenuItem getModifyMenuItem();
    public abstract JMenuItem getDeleteMenuItem();
    public abstract JMenuItem getProgrammerMenuDisplayAll();

    // Panels
    public abstract JPanel getEditPanel();
    public abstract JPanel getMainPanel();
    public abstract JPanel getDisplayPanel();

    // Personal number input
    public abstract JTextField getPersonalNumberField();

    // Form Fields
    public abstract JTextField getFormLastNameField();
    public abstract JTextField getFormFirstNameField();
    public abstract JTextField getFormHobbyField();
    public abstract JTextField getFormManagerField();
    public abstract JTextField getFormAddressField();
    public abstract JTextField getFormUsernameField();

    public abstract JTextField getFormBirthDayField();
    public abstract JComboBox<String> getFormBirthMonthField();
    public abstract JTextField getFormBirthYearField();

    public abstract JTextField getFormHireDayField();
    public abstract JComboBox<String> getFormHireMonthField();
    public abstract JTextField getFormHireYearField();


    // Buttons
    public abstract JButton getValidationButton();
    public abstract JButton getCancelButton();
    public abstract JButton getSearchButton();
    public abstract JButton getResetButton();

    // Table
    public abstract void storeProgrammersIntoRow(List<ProgrammerBean> programmers);

    // Form
    public abstract Component[] getFormComponents();



}
