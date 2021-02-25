package fr.efrei.tp3.view.widgets.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used in programmer bean to define field to display in the table
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DisplayAs {
    /**
     * Value string.
     * 
     * @return String column name
     */
    String value();

    /**
     * Index int.
     *
     * @return int column index
     */
    int index();
}