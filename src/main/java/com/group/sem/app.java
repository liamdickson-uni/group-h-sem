package com.group.sem;

import java.io.PrintStream;
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
                "1 - Get all Counties by Population\n " +
                "2 - Get all countries in a specific continent\n" +
                "3 - Get all cities in a specific country\n");

        String userInput = "1";

        if (userInput.equals("1")) {
            //Gets country
            ArrayList<country> countries = a.getCountryByPopDesc();

            //Displays country
            a.displayCountry(countries);
        } else if (userInput.equals("2")) {

            //Gets country
            ArrayList<country> countries = a.getCountryInContinentByPop();

            a.displayCountryInContinentByPop(countries);

        } else if (userInput.equals("3")) {

            //Gets city
            ArrayList<city> cities = a.getCitiesInCountryByPop();
            a.displayCity(cities);
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


    /**
     * These methods are used to get country data and to display country data.
     */
    public ArrayList<country> getCountryByPopDesc() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Name, c.Continent, c.Population" +
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
                cnt.Population = rset.getInt("Population");
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

            //Prints Column Header
           System.out.printf("%-45s %-15s", "Country", "Population\n\n");

           //Loops over all the countries in the database
            for (com.group.sem.country country : countries) {
                String output = String.format("%-45s %-15s",
                                    country.Name, country.Population);
                System.out.println(output);
            }
        }
    }




    public ArrayList<country> getCountryInContinentByPop(){

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Continent, c.Name" +
                            " FROM country c" +
                            " ORDER BY c.Continent, c.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country while valid.

            ArrayList<country> countries = new ArrayList<country>();

            // Check one is returned
            while (rset.next()) {
                country cnt = new country();
                cnt.Name = rset.getString("Name");
                cnt.Continent = rset.getString("Continent");
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data");
            return null;
        }
    }


    public void displayCountryInContinentByPop(ArrayList<country> countries) {


        System.out.printf("%-20s %-15s", "Continent", "Country");

        if (countries != null) {

            for (com.group.sem.country country : countries) {
                String cnt_string =
                        String.format("%-20s %-15s",
                                country.Continent, country.Name);
                System.out.println(cnt_string);

            }
        }
    }



    /**
     *
     * These methods are used to get city data and to display city data.
     */

    public void displayCity(ArrayList<city> cities) {
        if (cities != null) {

            for (com.group.sem.city city : cities) {
                System.out.println(city.cityName);
            }
        }
    }


    public ArrayList<city> getCitiesInCountryByPop() {

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT cty.Name" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Code = cty.CountryCode) " +
                            "WHERE cnt.Name IN ('France')" +
                            "ORDER BY cty.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country while valid.

            ArrayList<city> cities = new ArrayList<city>();

            // Check one is returned
            while (rset.next()) {
                city cty = new city();
                cty.cityName = rset.getString("Name");
                cities.add(cty);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities");
            return null;

        }
    }
}



