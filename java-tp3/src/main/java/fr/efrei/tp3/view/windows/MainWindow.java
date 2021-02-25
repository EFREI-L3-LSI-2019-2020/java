package fr.efrei.tp3.view.windows;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import fr.efrei.tp3.Constants;
import fr.efrei.tp3.model.logic.ProgrammerBean;
import fr.efrei.tp3.view.ViewManager;
import fr.efrei.tp3.view.panels.DisplayPanel;
import fr.efrei.tp3.view.panels.EditPanel;
import fr.efrei.tp3.view.panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * The type Main window.
 */
public class MainWindow extends ViewManager {
    private static final long serialVersionUID = 6638957814245356586L;

    private MainPanel mainPanel;
    private EditPanel editPanel;
    private DisplayPanel displayPanel;

    private JMenuBar barMenu;

    private JMenu programmerMenu;
    private JMenu actionMenu;
    private JMenu programmerMenuDisplay;

    private JMenuItem programmerMenuDisplayAll;
    private JMenuItem modifyMenuItem;
    private JMenuItem deleteMenuItem;
    private JMenuItem addMenuItem;
    private JMenuItem leaveMenuItem;

    /**
     * Gets display panel.
     *
     * @return the display panel
     */
    public DisplayPanel getDisplayPanel() {
        return displayPanel;
    }

    /**
     * Instantiates a new Main window.
     */
    public MainWindow() {
        super("GesProg");
        ClassLoader classLoader = getClass().getClassLoader();
        ImageIcon myAppImage = new ImageIcon(classLoader.getResource(Constants.PATH_ICON));
        setIconImage(myAppImage.getImage());

        this.setPreferredSize(new Dimension(Constants.RESOLUTION_X, Constants.RESOLUTION_Y));
        // this.setResizable(false);

        UIManager.put("OptionPane.enableIcon", true);

        this.mainPanel = new MainPanel();
        this.editPanel = new EditPanel();
        this.displayPanel = new DisplayPanel();

        this.add(this.mainPanel, BorderLayout.NORTH);

        // Menu new
        this.barMenu = new JMenuBar();
        this.programmerMenu = new JMenu("Programmeur");
        this.modifyMenuItem = new JMenuItem("Modifier");
        this.deleteMenuItem = new JMenuItem("Supprimer");
        this.addMenuItem = new JMenuItem("Ajouter");
        this.leaveMenuItem = new JMenuItem("Quitter");
        this.actionMenu = new JMenu("Action");
        this.programmerMenuDisplay = new JMenu("Afficher");
        this.programmerMenuDisplayAll = new JMenuItem("Tous");

        // Menu Add
        this.programmerMenuDisplay.add(programmerMenuDisplayAll);
        this.programmerMenu.add(programmerMenuDisplay);
        this.programmerMenu.add(modifyMenuItem);
        this.programmerMenu.add(deleteMenuItem);
        this.programmerMenu.add(addMenuItem);
        this.actionMenu.add(leaveMenuItem);
        this.barMenu.add(programmerMenu);
        this.barMenu.add(actionMenu);

        // Menu Mnemonic
        this.programmerMenuDisplay.setMnemonic('F');
        this.programmerMenuDisplayAll.setMnemonic('T');
        this.programmerMenu.setMnemonic('P');
        this.addMenuItem.setMnemonic('J');
        this.modifyMenuItem.setMnemonic('M');
        this.deleteMenuItem.setMnemonic('S');
        this.actionMenu.setMnemonic('A');
        this.leaveMenuItem.setMnemonic('Q');

        //
        this.pack();
        this.setJMenuBar(barMenu);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * Gets edit panel.
     *
     * @return the edit panel
     */
    public EditPanel getEditPanel() {
        return editPanel;
    }

    /**
     * Gets main panel.
     *
     * @return the main panel
     */
    public MainPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Gets bar menu.
     *
     * @return the bar menu
     */
    public JMenuBar getBarMenu() {
        return barMenu;
    }

    /**
     * Gets programmer menu.
     *
     * @return the programmer menu
     */
    public JMenu getProgrammerMenu() {
        return programmerMenu;
    }

    /**
     * Gets action menu.
     *
     * @return the action menu
     */
    public JMenu getActionMenu() {
        return actionMenu;
    }

    /**
     * Gets programmer menu display.
     *
     * @return the programmer menu display
     */
    public JMenu getProgrammerMenuDisplay() {
        return programmerMenuDisplay;
    }

    /**
     * Gets programmer menu display all.
     *
     * @return the programmer menu display all
     */
    public JMenuItem getProgrammerMenuDisplayAll() {
        return programmerMenuDisplayAll;
    }

    /**
     * Gets modify menu item.
     *
     * @return the modify menu item
     */
    public JMenuItem getModifyMenuItem() {
        return modifyMenuItem;
    }

    /**
     * Gets delete menu item.
     *
     * @return the delete menu item
     */
    public JMenuItem getDeleteMenuItem() {
        return deleteMenuItem;
    }

    /**
     * Gets add menu item.
     *
     * @return the add menu item
     */
    public JMenuItem getAddMenuItem() {
        return addMenuItem;
    }

    /**
     * Gets leave menu item.
     *
     * @return the leave menu item
     */
    public JMenuItem getLeaveMenuItem() {
        return leaveMenuItem;
    }

    @Override
    public JButton getValidationButton() {
        return this.getEditPanel().getValid();
    }

    @Override
    public JButton getCancelButton() {
        return this.getEditPanel().getCancel();
    }

    @Override
    public JButton getSearchButton() {
        return this.getEditPanel().getSearch();
    }

    @Override
    public JButton getResetButton() {
        return this.getEditPanel().getReset();
    }

    @Override
    public void storeProgrammersIntoRow(List<ProgrammerBean> programmers) {
        this.getDisplayPanel().getTableModel().setObjectRows(programmers);
        this.getDisplayPanel().updateSize();
    }

    @Override
    public Component[] getFormComponents() {
        return this.getEditPanel().getForm().getComponents();
    }

    @Override
    public JTextField getFormLastNameField() {
        return this.getEditPanel().getFormName();
    }

    @Override
    public JTextField getFormFirstNameField() {
        return this.getEditPanel().getFormFirstName();
    }

    @Override
    public JTextField getFormHobbyField() {
        return this.getEditPanel().getFormHobby();
    }

    @Override
    public JTextField getFormManagerField() {
        return this.getEditPanel().getFormResponsible();
    }

    @Override
    public JTextField getFormAddressField() {
        return this.getEditPanel().getFormAddress();
    }

    @Override
    public JTextField getFormBirthDayField() {
        return this.getEditPanel().getFormBirthDay();
    }

    @Override
    public JComboBox<String> getFormBirthMonthField() {
        return this.getEditPanel().getFormBirthMonth();
    }

    @Override
    public JTextField getFormBirthYearField() {
        return this.getEditPanel().getFormBirthYear();
    }

    @Override
    public JTextField getFormHireDayField() {
        return this.getEditPanel().getFormHiringDay();
    }

    @Override
    public JComboBox<String> getFormHireMonthField() {
        return this.getEditPanel().getFormHiringMonth();
    }

    @Override
    public JTextField getFormHireYearField() {
        return this.getEditPanel().getFormHiringYear();
    }

    @Override
    public JTextField getPersonalNumberField() {
        return this.getEditPanel().getMatInput();
    }

    @Override
    public JTextField getFormUsernameField() {
        return this.getEditPanel().getFormPseudo();
    }

}
