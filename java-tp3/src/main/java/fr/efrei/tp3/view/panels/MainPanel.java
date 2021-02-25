package fr.efrei.tp3.view.panels;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.efrei.tp3.Constants;

/**
 * The type Main panel.
 */
public class MainPanel extends JPanel {
    private static final long serialVersionUID = 1458836465255503712L;
    private Image logo;
    private ImageIcon icon;
    private JLabel img;

    /**
     * Instantiates a new Main panel.
     */
    public MainPanel() {
        // Fetch image from resources
        ClassLoader classLoader = getClass().getClassLoader();
        this.logo = new ImageIcon(classLoader.getResource(Constants.PATH_LOGO)).getImage().getScaledInstance(Constants.RESOLUTION_IMG_X,
                Constants.RESOLUTION_IMG_Y, Image.SCALE_SMOOTH);
        this.icon = new ImageIcon(logo);
        this.img = new JLabel();
        this.img.setHorizontalAlignment(SwingConstants.CENTER);
        this.img.setVerticalAlignment(SwingConstants.CENTER);
        this.img.setIcon(icon);
        this.add(img, BorderLayout.CENTER);
    }
}