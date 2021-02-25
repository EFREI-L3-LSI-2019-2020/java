package fr.efrei.tp3;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import fr.efrei.tp3.controller.MainController;
import fr.efrei.tp3.model.database.ProgrammerRepositoryImpl;
import fr.efrei.tp3.view.windows.MainWindow;
import mdlaf.MaterialLookAndFeel;

/**
 * The type App.
 *
 * @author JAA
 */
public class App {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            LoggerManager.getInstanceLogger().getLogger().error(e.getMessage());
        }

        new MainController(new MainWindow(), new ProgrammerRepositoryImpl());
    }
}
