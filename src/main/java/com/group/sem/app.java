package com.group.sem;

import java.sql.*;

import com.group.sem.country;

public class app {

    public static void main(String[] args) {
        // Create new Application
        app a = new app();

        // Connect to database
        a.connect();

        //Gets country
        country cnt = a.getCountry("ABW");

        //Displays country
        a.displayCountry(cnt);

        // Disconnect from database
        a.disconnect();

    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "password");
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

    /**
     * Disconnects from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public country getCountry(String ID) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM country ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid.
            // Check one is returned
            if (rset.next()) {
                country cnt = new country();
                cnt.Code = rset.getString("Code");
                return cnt;
            } else
                return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country");
            return null;
        }
    }

    public void displayCountry(country cnt) {
        if (cnt != null) {
            System.out.println(
                    cnt.Code + " " + cnt.countryName);
        }
    }
}