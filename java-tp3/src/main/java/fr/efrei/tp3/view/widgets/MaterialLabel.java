package fr.efrei.tp3.view.widgets;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import fr.efrei.tp3.Constants;

/**
 * The type Material label.
 */
public class MaterialLabel extends JLabel {
    private static final long serialVersionUID = 8124486388791611326L;

    /**
     * Instantiates a new Material label.
     *
     * @param text the text
     */
    public MaterialLabel(String text) {
        super(text, SwingConstants.LEFT);
        this.setPreferredSize(
                new Dimension(Constants.RESOLUTION_MATERIAL_LABEL_X, Constants.RESOLUTION_MATERIAL_LABEL_Y));
    }

}
