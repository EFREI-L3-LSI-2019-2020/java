package fr.efrei.tp3.model.logic;

import java.util.List;

/**
 * The interface Programmer repository. Abstraction for the programmer
 * repository, establishes a service contract to persist and retrieve programmer data
 */
public interface ProgrammerRepository {
    /**
     * Find all list.
     *
     * @return the list
     */
    List<ProgrammerBean> findAll();

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<ProgrammerBean> findByName(String name);

    /**
     * Find by id programmer bean.
     *
     * @param personalNumber the personal number
     * @return the programmer bean
     */
    ProgrammerBean findById(int personalNumber);

    /**
     * Insert.
     *
     * @param bean the bean
     */
    void insert(ProgrammerBean bean);

    /**
     * Update.
     *
     * @param bean the bean
     */
    void update(ProgrammerBean bean);

    /**
     * Delete.
     *
     * @param personalNumber the personal number
     */
    void delete(int personalNumber);
}
