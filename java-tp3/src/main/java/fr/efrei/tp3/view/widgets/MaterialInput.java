package fr.efrei.tp3.view.widgets;

import java.awt.Dimension;

import javax.swing.JTextField;

import fr.efrei.tp3.Constants;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

/**
 * The type Material input.
 */
public class MaterialInput extends JTextField {
    private static final long serialVersionUID = 4363101337986941221L;

    /**
     * Instantiates a new Material input.
     */
    public MaterialInput() {
        setColumns(Constants.RESOLUTION_MATERIAL_INPUT_COLUMNS);
        setPreferredSize(new Dimension(Constants.RESOLUTION_MATERIAL_INPUT_X, Constants.RESOLUTION_MATERIAL_INPUT_Y));
        MaterialUIMovement.add(this, MaterialColors.GRAY_100);
    }
}