package fr.efrei.tp3.view.widgets;

import java.awt.Dimension;

import javax.swing.JButton;

import fr.efrei.tp3.Constants;

/**
 * The type Material button.
 */
public class MaterialButton extends JButton {
    private static final long serialVersionUID = 3208747279703289232L;

    /**
     * Instantiates a new Material button.
     *
     * @param text the text
     */
    public MaterialButton(String text) {
        super(text);
        setFocusPainted(false);
        setMaximumSize(new Dimension(Constants.RESOLUTION_MATERIAL_BUTTON_X, Constants.RESOLUTION_MATERIAL_BUTTON_Y));
    }
}