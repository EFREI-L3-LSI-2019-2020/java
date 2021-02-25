package fr.efrei.tp3.view.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.efrei.tp3.Constants;
import fr.efrei.tp3.view.widgets.MaterialButton;
import fr.efrei.tp3.view.widgets.MaterialInput;
import fr.efrei.tp3.view.widgets.MaterialLabel;

/**
 * The type Edit panel.
 * This class represents the JPanel holding the form to ADD / EDIT a programmer
 * It holds its controls
 */
public class EditPanel extends JPanel {
    private static final long serialVersionUID = 6460872401974923586L;

    // Child panels
    private JPanel actions;
    private JPanel mat;
    private JPanel form;

    private JTextField matInput;

    // Form inputs
    private JTextField formName;
    private JTextField formFirstName;
    private JTextField formAddress;
    private JTextField formPseudo;
    private JTextField formResponsible;
    private JTextField formBirthDay;
    private JComboBox<String> formBirthMonth;
    private JTextField formBirthYear;
    private JTextField formHiringDay;
    private JComboBox<String> formHiringMonth;
    private JTextField formHiringYear;
    private JTextField formHobby;

    // Action buttons
    private JButton search;
    private JButton reset;
    private JButton valid;
    private JButton cancel;

    /**
     * Instantiates a new Edit panel.
     */
    public EditPanel() {
        this.setLayout(new BorderLayout());

        // Month numbers for month combo box
        String[] months = IntStream.rangeClosed(1, 12).mapToObj(String::valueOf).collect(Collectors.toList())
                .toArray(new String[12]);

        // Personal number
        mat = new JPanel();
        matInput = new MaterialInput();
        JLabel matriculeLabel = new JLabel("Matricule");
        matriculeLabel.setForeground(Color.white);
        mat.add(matriculeLabel);

        mat.setBackground(Color.decode(Constants.COLOR_BACKGROUND));
        matriculeLabel.setBackground(Color.decode(Constants.COLOR_BACKGROUND));
        mat.setLayout(new FlowLayout(FlowLayout.LEFT));
        mat.add(matInput);

        // Form inputs
        form = new JPanel();
        formName = new MaterialInput();
        formFirstName = new MaterialInput();
        formAddress = new MaterialInput();
        formPseudo = new MaterialInput();
        formResponsible = new MaterialInput();
        formBirthDay = new MaterialInput();
        formBirthMonth = new JComboBox<>(months);
        formBirthYear = new MaterialInput();
        formHiringDay = new MaterialInput();
        formHiringMonth = new JComboBox<>(months);
        formHiringYear = new MaterialInput();
        formHobby = new MaterialInput();

        // Layout
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10, 5, 10, 5);
        form.setLayout(layout);
        gc.gridx = 0;
        gc.gridy = 0;
        form.add(new MaterialLabel("Nom"), gc);
        gc.gridx = 1;
        gc.gridy = 0;
        form.add(formName, gc);
        gc.gridx = 2;
        gc.gridy = 0;
        form.add(new MaterialLabel("Prénom"), gc);
        gc.gridx = 3;
        gc.gridy = 0;
        form.add(formFirstName, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        form.add(new MaterialLabel("Adresse"), gc);
        gc.gridx = 1;
        gc.gridy = 1;
        form.add(formAddress, gc);
        gc.gridx = 2;
        gc.gridy = 1;
        form.add(new MaterialLabel("Pseudo"), gc);
        gc.gridx = 3;
        gc.gridy = 1;
        form.add(formPseudo, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        form.add(new MaterialLabel("Responsable"), gc);
        gc.gridx = 1;
        gc.gridy = 2;
        form.add(formResponsible, gc);
        gc.gridx = 2;
        gc.gridy = 2;
        form.add(new MaterialLabel("Date de naissance"), gc);
        gc.gridx = 3;
        gc.gridy = 2;
        form.add(formBirthDay, gc);
        gc.gridx = 4;
        gc.gridy = 2;
        form.add(formBirthMonth, gc);
        gc.gridx = 5;
        gc.gridy = 2;
        form.add(formBirthYear, gc);
        gc.gridx = 0;
        gc.gridy = 3;
        form.add(new MaterialLabel("Hobby"), gc);
        gc.gridx = 1;
        gc.gridy = 3;
        form.add(formHobby, gc);
        gc.gridx = 2;
        gc.gridy = 3;
        form.add(new MaterialLabel("Date embauche"), gc);
        gc.gridx = 3;
        gc.gridy = 3;
        form.add(formHiringDay, gc);
        gc.gridx = 4;
        gc.gridy = 3;
        form.add(formHiringMonth, gc);
        gc.gridx = 5;
        gc.gridy = 3;
        form.add(formHiringYear, gc);

        // Actions buttons
        actions = new JPanel();
        search = new MaterialButton("Rechercher");
        reset = new MaterialButton("Réinitialiser");
        valid = new MaterialButton("Valider");
        cancel = new MaterialButton("Annuler");

        actions.add(search);
        actions.add(reset);
        actions.add(valid);
        actions.add(cancel);

        this.add(mat, BorderLayout.NORTH);
        this.add(form, BorderLayout.CENTER);
        this.add(actions, BorderLayout.SOUTH);
    }

    @Override
    public void setEnabled(boolean disabled) {
        formName.setEditable(disabled);
        formFirstName.setEditable(disabled);
        formAddress.setEditable(disabled);
        formPseudo.setEditable(disabled);
        formResponsible.setEditable(disabled);
        formBirthDay.setEditable(disabled);
        formBirthMonth.setEditable(disabled);
        formBirthYear.setEditable(disabled);
        formHiringDay.setEditable(disabled);
        formHiringMonth.setEditable(disabled);
        formHiringYear.setEditable(disabled);
        formHobby.setEditable(disabled);

        formName.setEnabled(disabled);
        formFirstName.setEnabled(disabled);
        formAddress.setEnabled(disabled);
        formPseudo.setEnabled(disabled);
        formResponsible.setEnabled(disabled);
        formBirthDay.setEnabled(disabled);
        formBirthMonth.setEnabled(disabled);
        formBirthYear.setEnabled(disabled);
        formHiringDay.setEnabled(disabled);
        formHiringMonth.setEnabled(disabled);
        formHiringYear.setEnabled(disabled);
        formHobby.setEnabled(disabled);
    }

    /**
     * Gets mat input.
     *
     * @return the mat input
     */
    public JTextField getMatInput() {
        return this.matInput;
    }

    /**
     * Gets form name.
     *
     * @return the form name
     */
    public JTextField getFormName() {
        return this.formName;
    }

    /**
     * Gets form first name.
     *
     * @return the form first name
     */
    public JTextField getFormFirstName() {
        return this.formFirstName;
    }

    /**
     * Gets form address.
     *
     * @return the form address
     */
    public JTextField getFormAddress() {
        return this.formAddress;
    }

    /**
     * Gets form pseudo.
     *
     * @return the form pseudo
     */
    public JTextField getFormPseudo() {
        return this.formPseudo;
    }

    /**
     * Gets form responsible.
     *
     * @return the form responsible
     */
    public JTextField getFormResponsible() {
        return this.formResponsible;
    }

    /**
     * Gets form birth day.
     *
     * @return the form birth day
     */
    public JTextField getFormBirthDay() {
        return this.formBirthDay;
    }

    /**
     * Gets form birth month.
     *
     * @return the form birth month
     */
    public JComboBox<String> getFormBirthMonth() {
        return this.formBirthMonth;
    }

    /**
     * Gets form birth year.
     *
     * @return the form birth year
     */
    public JTextField getFormBirthYear() {
        return this.formBirthYear;
    }

    /**
     * Gets form hiring day.
     *
     * @return the form hiring day
     */
    public JTextField getFormHiringDay() {
        return this.formHiringDay;
    }

    /**
     * Gets form hiring month.
     *
     * @return the form hiring month
     */
    public JComboBox<String> getFormHiringMonth() {
        return this.formHiringMonth;
    }

    /**
     * Gets form hiring year.
     *
     * @return the form hiring year
     */
    public JTextField getFormHiringYear() {
        return this.formHiringYear;
    }

    /**
     * Gets form hobby.
     *
     * @return the form hobby
     */
    public JTextField getFormHobby() {
        return this.formHobby;
    }

    /**
     * Gets search.
     *
     * @return the search
     */
    public JButton getSearch() {
        return this.search;
    }

    /**
     * Gets reset.
     *
     * @return the reset
     */
    public JButton getReset() {
        return this.reset;
    }

    /**
     * Gets valid.
     *
     * @return the valid
     */
    public JButton getValid() {
        return this.valid;
    }

    /**
     * Gets cancel.
     *
     * @return the cancel
     */
    public JButton getCancel() {
        return this.cancel;
    }

    /**
     * Gets form.
     *
     * @return the form
     */
    public JPanel getForm() {
        return form;
    }
}