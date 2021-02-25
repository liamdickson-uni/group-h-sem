package com.group.sem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.group.sem.country;

public class app {

    public static void main(String[] args) {
        // Create new Application
        app a = new app();

        // Connect to database
        a.connect();

        Scanner mainObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please Select an Option:\n " +
                "1 - Get all Counties by Population \n " +
                "2 - Get all countries in a specific continent \n" +
                "3 - Get all cities in a specific country \n");

        String userInput = "3";

        if (userInput.equals("1")) {
            //Gets country
            ArrayList<country> countries = a.getCountryByPopDesc();

            //Displays country
            a.displayCountry(countries);
        } else if (userInput.equals("3")) {

            //Gets country
            ArrayList<country> countries = a.getCountryInContinentByPop();

            a.displayCountry(countries);
        }


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
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
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

    public ArrayList<country> getCountryByPopDesc() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Name" +
                            " FROM country c" +
                            " ORDER BY c.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Return new country while valid.
            ArrayList<country> countries = new ArrayList<country>();

            // Check one is returned
            while (rset.next()) {
                country cnt = new country();
                cnt.Name = rset.getString("Name");
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country");
            return null;
        }
    }

    public void displayCountry(ArrayList<country> countries) {
        if (countries != null) {

            for (com.group.sem.country country : countries) {
                System.out.println(country.Name);
            }
        }
    }


    public ArrayList<country> getCountryInContinentByPop(){

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Name" +
                            " FROM country c" +
                            " WHERE c.Continent IN ('Africa')" +
                            " ORDER BY c.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country while valid.

            ArrayList<country> countries = new ArrayList<country>();

            // Check one is returned
            while (rset.next()) {
                country cnt = new country();
                cnt.Name = rset.getString("Name");
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country");
            return null;
        }
    }

}


