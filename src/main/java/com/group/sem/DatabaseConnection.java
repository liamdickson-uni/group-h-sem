package com.group.sem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    /*
     *  The following code creates a singleton instance of the DatabaseConnection Class to be used throughout the program.
     *
     *  This ensures that there is only ever one connection to the database at any one time.
     */
    //Private Constructor
    private static DatabaseConnection INSTANCE;

    //Empty Constructor
    private DatabaseConnection() {

    }

    //Static factory method for obtaining the instance
    public static DatabaseConnection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseConnection();
        }
        return INSTANCE;
    }




    /**
     * Connection to MySQL database.
     */
    private static Connection con = null;

    public static Connection getConnection() {
        return con;
    }

    /**
     * Connects to the MySQL database.
     *
     * @param location The location name
     */
    public Connection connect(String location) {

        if (con == null) {
            try {
                // Load Database driver
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Could not load SQL driver");
                System.exit(-1);
            }

            int retries = 60;

            for (int i = 0; i < retries; ++i) {
                System.out.println("Connecting to database...");

                try {

                    System.out.println("Loading...");
                    // Wait a bit for db to start
                    Thread.sleep(5000);
                    // Connect to database
                    con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");

                    System.out.println("Successfully connected");
                    break;

                } catch (SQLException sqle) {
                    System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                    System.out.println(sqle.getMessage());
                } catch (InterruptedException ie) {
                    System.out.println("Thread interrupted? Should not happen.");
                }
            }
        }
        return con;
    }


    /**
     * Disconnects from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
                System.out.println("Database Disconnected");
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }




}
