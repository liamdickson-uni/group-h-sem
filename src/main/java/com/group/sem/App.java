package com.group.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        Country c = new Country();
        City cc = new City();

        // Connect to database
        a.connect();

        System.out.println(
                "Please Select an Option:\n " +
                "1 - Get all counties by population\n " +
                "2 - Get all countries in a specific continent\n" +
                "3 - Get all countries in a specific region\n" +
                "4 - Get all cities in a specific country\n" +
                "5 - Get all cities ordered by population\n" +
                "7 - Get all cities in a specific continent\n" +
                "8 - Get all cities in a region"
        );

        String userInput = "3";

        if (userInput.equals("1")) {
            //Gets all countries ordered by population largest to smallest
            ArrayList<Country> countries = c.getCountryByPopDesc();

            //Displays list of selected query
            a.displayCountry(countries, userInput);
        } else if (userInput.equals("2")) {
            //Gets all countries by a selected continent ordered by population largest to smallest
            ArrayList<Country> countries = c.getCountryInContinentByPop();

            //Displays list of selected query
            a.displayCountry(countries, userInput);

        } else if (userInput.equals("3")) {
            //Gets all countries in a selected region ordered by population largest to smallest
            ArrayList<Country> countries = c.getCountryInRegionByPop();

            //Displays list of selected query
            a.displayCountry(countries, userInput);

        } else if (userInput.equals("4")) {
            //Gets all cities in a selected country ordered by population largest to smallest
            ArrayList<City> cities = cc.getCitiesInCountryByPop();

            //Displays list of selected query
            a.displayCity(cities, userInput);

        } else if (userInput.equals("5")) {
            //Gets all cities ordered by population largest to smallest
            ArrayList<City> cities = cc.getCitiesByPop();

            //Displays list of selected query
            a.displayCity(cities, userInput);

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


    public void displayCountry(ArrayList<Country> countries, String userInput) {

        if (userInput.equals("1")) {
            if (countries != null) {

                //Prints Column Header
                System.out.printf("%-45s %-15s", "Country", "Population\n");

                //Loops over all the countries in the database
                for (Country country : countries) {
                    String output = String.format("%-45s %-15s", country.Name, country.Population);
                    System.out.println(output);
                }
            }
        } else if (userInput.equals("2")) {

            //Prints Column Header
            System.out.printf("%-20s %-15s", "Continent", "Country\n");

            if (countries != null) {
                for (Country country : countries) {
                    String output = String.format("%-20s %-15s", country.Continent, country.Name);
                    System.out.println(output);

                }
            }
        } else if (userInput.equals("3")) {

            //Prints Column Header
            System.out.printf("%-20s %-15s %-15s", "Region", "Country", "Population\n");

            if (countries != null) {
                for (Country country : countries) {
                    String output = String.format("%-20s %-15s %-15s", country.Region, country.Name, country.Population);
                    System.out.println(output);

                }
            }
        }

    }


    public void displayCity(ArrayList<City> cities, String userInput) {

        if (userInput.equals("3")) {

            //Prints Column Header
            System.out.printf("%-20s", "City\n");

            if (cities != null) {

                for (City city : cities) {
                    System.out.println(city.cityName);
                }
            }

        } else if (userInput.equals("4")) {

            //Prints Column Header
            System.out.printf("%-20s %-15s", "City", "Population\n");

            if (cities != null) {

                for (City city : cities) {
                    String output = String.format("%-45s %-15s", city.cityName, city.cityPopulation);
                    System.out.println(output);
                }
            }

        }


    }

}



