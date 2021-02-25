package fr.efrei.tp3.view.panels;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import fr.efrei.tp3.Constants;
import fr.efrei.tp3.model.logic.ProgrammerBean;
import fr.efrei.tp3.view.widgets.table.DisplayableObjectTableModel;
import fr.efrei.tp3.view.widgets.table.ObjectTableModel;

/**
 * The type Display panel.
 */
public class DisplayPanel extends JPanel {
    private static final long serialVersionUID = -9016549926214971430L;

    private ObjectTableModel<ProgrammerBean> tableModel;
    private JTable table;
    private JScrollPane pane;

    /**
     * Instantiates a new Display panel.
     */
    public DisplayPanel() {
        tableModel = new DisplayableObjectTableModel<>(ProgrammerBean.class);
        table = new JTable(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(Constants.RESOLUTION_TABLE_X, Constants.RESOLUTION_TABLE_Y));
        this.add(pane);
    }

    /**
     * Update size of the table upon loading programmers
     */
    public void updateSize() {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = Constants.RESOLUTION_TABLE_MIN_X; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > Constants.RESOLUTION_TABLE_MIN_Y) {
                width = Constants.RESOLUTION_TABLE_MIN_Y;
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    /**
     * Gets table.
     *
     * @return the table
     */
    public JTable getTable() {
        return table;
    }

    /**
     * Gets pane.
     *
     * @return the pane
     */
    public JScrollPane getPane() {
        return pane;
    }

    /**
     * Gets table model.
     *
     * @return the tableModel
     */
    public ObjectTableModel<ProgrammerBean> getTableModel() {
        return tableModel;
    }
}
