package fr.efrei.tp3.model.database;

/**
 * The type Queries. Stores SQL queries for ProgrammerRepository The queries are
 * wrote in PostreSQL dialect
 */
public class Queries {

    /**
     * The constant FIND_ALL.
     */
    public static String FIND_ALL = "SELECT * FROM \"PROGRAMMEUR\"";
    /**
     * The constant FIND_BY_NAME.
     */
    public static String FIND_BY_NAME = "SELECT * FROM \"PROGRAMMEUR\" WHERE nom=?";
    /**
     * The constant FIND_BY_ID.
     */
    public static String FIND_BY_ID = "SELECT * FROM \"PROGRAMMEUR\" WHERE matricule=?";
    /**
     * The constant COUNT.
     */
    public static String COUNT = "SELECT COUNT(*) AS total FROM \"PROGRAMMEUR\" WHERE MATRICULE = ? ";
    /**
     * The constant INSERT.
     */
    public static String INSERT = "INSERT INTO \"PROGRAMMEUR\" (MATRICULE, NOM, PRENOM, ADRESSE, PSEUDO, RESPONSABLE, HOBBY, DATE_NAISS, DATE_EMB) VALUES (?,?, ?, ?, ?, ?, ?,?, ?)";
    /**
     * The constant UPDATE.
     */
    public static String UPDATE = "UPDATE \"PROGRAMMEUR\" "
            + "SET MATRICULE = ?, NOM = ?, PRENOM = ?, ADRESSE = ?, PSEUDO = ? , RESPONSABLE = ?, HOBBY = ?, DATE_NAISS = ?, DATE_EMB = ? "
            + "WHERE MATRICULE = ?";
    /**
     * The constant DELETE.
     */
    public static String DELETE = "DELETE FROM \"PROGRAMMEUR\"  WHERE MATRICULE = ?";
}
