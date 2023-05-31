/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Domat
 */
public class DBConnectionProvider {

    String dbPath = "C:\\Users\\elias\\Documents\\NetBeansProjects\\FinalProject\\src\\database\\";

    String dbName = "database.db";

    String engine = "jdbc:sqlite";

    String connectionString = engine + ":" + dbPath + dbName;

    public Connection getConnection() {

        try {
            Connection dbConnection = DriverManager.getConnection(connectionString);
            return dbConnection;

        } catch (SQLException ex) {
            System.out.println("An Error Happened " + ex.getMessage());

        } 
        return null;
    }
}