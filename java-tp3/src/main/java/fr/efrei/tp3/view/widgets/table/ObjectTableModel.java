package fr.efrei.tp3.view.widgets.table;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Object table model.
 *
 * @param <T> the type parameter
 */
public abstract class ObjectTableModel<T> extends AbstractTableModel {
    private static final long serialVersionUID = -4070761596323775351L;
    private List<T> objectRows = new ArrayList<>();

    /**
     * Gets object rows.
     *
     * @return the object rows
     */
    public List<T> getObjectRows() {
        return objectRows;
    }

    /**
     * Sets object rows.
     *
     * @param objectRows the object rows
     */
    public void setObjectRows(List<T> objectRows) {
        this.objectRows = objectRows;
    }

    @Override
    public int getRowCount() {
        return objectRows.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T t = objectRows.get(rowIndex);
        return getValueAt(t, columnIndex);
    }

    /**
     * Gets value at.
     *
     * @param t           the object
     * @param columnIndex the column index
     * @return the value at
     */
    public abstract Object getValueAt(T t, int columnIndex);

    @Override
    public abstract String getColumnName(int column);

    /**
     * Gets field name.
     *
     * @param column the column
     * @return the field name
     */
    public abstract String getFieldName(int column);
}