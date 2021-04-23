package com.group.sem;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


/**
 * Wildcat Bikes -- Global Market Information
 * Group H -- SET08103
 * By Tom McEachan (40356376), Liam Dickson (40456372), Greig Dunbar (40430731), Jack Burton (40456783)
 *
 * City.java
 * City.java contains all of the variables and methods associated with the city table in the world.sql database.
 *
 * Variables in this class include:
 *
 *     cityID
 *     cityName
 *     countryCode
 *     cityDistrict
 *     cityPopulation
 *
 * Methods in this in this class include:
 *
 *     getCitiesInCountryByPop()
 *     getCitiesByPop()
 *     getCitiesInCont()
 *     getCitiesInDistrictByPop()
 *     getCitiesInRegion()
 *     getDistrictByPop()
 *     getCapitalCitiesInContinentByPoP()
 *     getCapitalCitiesInRegionByPop()
 *
 */



/*
 * This class represents a city
 */
public class City {

    /**
     *  The following code creates a singleton instance of the City Class to be used throughout the program
     */

    //Private constructor
    private static City INSTANCE;

    //Empty Constructor
    private City(){
    }

    //Static factory method for obtaining the instance
    public static City getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new City();
        }
        return INSTANCE;
    }


    /*
     * Represents a City
     */
    public int cityID;


    /*
     * Represents a City Name
     */
    public String cityName;


    /*
     * Represents a Country Code
     */
    public String countryCode;


    /*
     * Represents a City District
     */
    public String cityDistrict;

    /*
     * Represents a City Population
     */
    public int cityPopulation;


    /*
     * These methods are used to get city data and to display city data.
     */

    //Gets singleton instance of App
    App app = App.getInstance();

    //Gets singleton instance of Database Connection
    DatabaseConnection db = DatabaseConnection.getInstance();

    /**
     * This method gets the cities in a country ordered by population
     *
     * @return - ArrayList of Cities
     * @param country - User Selected Country
     *
     */
    public ArrayList<City> getCitiesInCountryByPop(String country) {

        try {

            //Defines the prepared SQL Statement
            String sql = "SELECT cty.Name" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Code = cty.CountryCode) " +
                            "WHERE cnt.Name =?" +
                            "ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            ps.setString(1, country);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_country/Cities in " + country + ".csv";

            //Creates an ArrayList of countries to pass back to a method
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                //Adds data from the result set to an ArrayList
                City cty = new City();
                cty.cityName = rset.getString("Name");
                CSVCreator.createCSV(fileName,rset);
                cities.add(cty);
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in selected country");
            return null;

        }
    }


    /**
     * This methods get a list of cities ordered by population
     *
     * @return ArrayList of Cities
     */
    public ArrayList<City> getCitiesByPop() {

        try {
            //Defines the prepared SQL statement
            String sql =
                    " SELECT c.Name, c.Population FROM city c ORDER BY c.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_by_pop/All cities by population " + ".csv";

            //Creates an ArrayList
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
                CSVCreator.createCSV(fileName,rset);
                cities.add(cty);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities by population");
            return null;

        }
    }


    /**
     * This method gets a list of cities in a specified continent
     *
     * @return - An ArrayList of Cities
     * @param continent - User selected continent
     */
    public ArrayList<City> getCitiesInCont(String continent) {

        try {

            // Defines the prepared SQL statement
            String sql = " SELECT cty.Name" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Code = cty.CountryCode) " +
                            "WHERE cnt.Continent = ?" +
                            "ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, continent);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_continent/Cities in " + continent + ".csv";

            //Creates an empty ArrayList of Cities for printing
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                CSVCreator.createCSV(fileName,rset);
                cities.add(cty);
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in selected continent");
            return null;

        }
    }

    /**
     * This method gets a list of cities in a district ordered by population
     *
     * @return an ArrayList of Cities
     */
    public ArrayList<City> getCitiesInDistrictByPop(String userDistrict) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT cty.District, cty.Name" +
                            " FROM city cty" +
                            " WHERE cty.District = ?" +
                            "ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, userDistrict);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_district/Cities in " + userDistrict + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityDistrict = rset.getString("District");
                cty.cityName = rset.getString("Name");
                CSVCreator.createCSV(fileName,rset);
                cities.add(cty);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in selected district");
            return null;

        }
    }

    /**
     * This method gets a list of cities in a specified region, ordered by population
     * @return an ArrayList of cities
     */
    public ArrayList<City> getCitiesInRegion(String userRegion) {

        try {

            // Defines the prepared SQL statement
            String sql = " SELECT cty.Name" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Code = cty.CountryCode) " +
                            " WHERE cnt.Region = ?" +
                            " ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns userInput to parameterIndex
            ps.setString(1, userRegion);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_region/Cities in " + userRegion + ".csv";

            //Creates an Empty ArrayList of Cities
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                CSVCreator.createCSV(fileName,rset);
                cities.add(cty);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in selected region");
            return null;

        }
    }

    /**
     * This method gets a list of districts and orders them by population
     *
     * @return an ArrayList of Cities
     */

    public ArrayList<City> getDistrictByPop() {

        try {
            //Defines the prepared SQL statement
            String sql = " SELECT cty.District, sum(cty.Population) as Population" +
                            " FROM city cty" +
                            " ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/district/district_by_population/All Districts By Population" + ".csv";

            //Creates an Empty ArrayList of Cities
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("City");
                cty.cityDistrict = rset.getString("District");
                cty.cityPopulation = rset.getInt("Population");
                CSVCreator.createCSV(fileName,rset);
                cities.add(cty);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data on the selected district");
            return null;

        }
    }

    /**
     * This method gets a list of capital cities in a continent, organised by population
     *
     * @return an ArrayList of cities
     */
    public ArrayList<City> getCapitalCitiesInContinentByPoP(String userContinent) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT cty.Name, cty.Population" +
                    " FROM city cty" +
                    " JOIN country cnt ON (cnt.Capital = cty.ID) " +
                    " WHERE cnt.Continent = ?" +
                    " ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns uer input to parameterIndex
            ps.setString(1, userContinent);

            //Execute SQL Statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/capital_cities_in_continent/Capital Cities in " + userContinent + ".csv";

            //Create a list to store the data
            ArrayList<City> cities = new ArrayList<>();

            //Check a result is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
                CSVCreator.createCSV(fileName, rset);
                cities.add(cty);
            }

            return cities;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities and their populations.");
            return null;
        }

    }
    /**
     * This method gets a list of capital cities in a specified region, ordered by population
     *
     * @return an ArrayList of Cities
     */
    public ArrayList<City> getCapitalCitiesInRegionByPoP(String userRegion) {

            try {
                //Defines the prepared SQL statement
                String sql = "SELECT cty.Name, cty.Population" +
                        " FROM city cty" +
                        " JOIN country cnt ON (cnt.Capital = cty.ID)" +
                        " WHERE cnt.Region = ?" +
                        " ORDER BY cty.Population DESC";

                //Sets up the prepared statement
                PreparedStatement ps = db.connect(true).prepareStatement(sql);

                //Assigns user input to parameterIndex 1
                ps.setString(1, userRegion);

                //Execute SQL Statement
                ResultSet rset = ps.executeQuery();

                //Sets the filename for the CSV file and creates a path to
                String fileName = "csv/cities/capital_cities_in_region/Capital Cities in " + userRegion + ".csv";

                //Create a list to store the data
                ArrayList<City> cities = new ArrayList<>();

                //Check a result is returned
                while (rset.next()) {
                    City cty = new City();
                    cty.cityName = rset.getString("Name");
                    cty.cityPopulation = rset.getInt("Population");
                    CSVCreator.createCSV(fileName, rset);
                    cities.add(cty);
                }
                return cities;
            }
            catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get capital cities and their populations.");
                return null;
            }

        }

        /**
         * This method gets a set number of cities in a specified district
         *
         * @return an ArrayList of cities
         */
        public ArrayList<City> getSetNCityInDistrictByPop(String cityDistrict, String limit) {

            try {
                //Defines the prepared SQL statement
                String sql = "SELECT cty.cityDistrict, cty.cityName, cty.cityPopulation " +
                        "FROM city cty " +
                        "WHERE cty.cityDistrict = ? " +
                        "ORDER BY c.Population DESC " +
                        "LIMIT ?";

                //Sets up the prepared statement
                PreparedStatement ps = db.connect(true).prepareStatement(sql);


                //Assign userInput to the first parameterIndex
                ps.setString(1, cityDistrict);
                ps.setInt(2, Integer.parseInt(limit));

                // Execute SQL statement
                ResultSet rset = ps.executeQuery();

                String fileName = "csv/cities/set_cities_in_district/Set Number of Cities in " + cityDistrict + ".csv";

                //Creates an ArrayList of cities to store data
                ArrayList<City> cities = new ArrayList<>();

                // Check that a city is returned and add the data to the ArrayList
                while (rset.next()) {
                    City cty = new City();
                    cty.cityName = rset.getString("Name");
                    cty.cityDistrict = rset.getString("District");
                    CSVCreator.createCSV(fileName, rset);
                    cities.add(cty);
                }

                return cities;

            } catch (SQLException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Failed to get cities in selected district");
                return null;
            }}

            /**
             * This method gets a set number of cities in a the world
             *
             * @return an ArrayList of cities
             */
            public ArrayList<City> getSetNCityInWorldByPop(String cityName, String limit) {

                try {
                    //Defines the prepared SQL statement
                    String sql = "SELECT  cty.cityName, cty.cityPopulation " +
                            "FROM city cty " +
                            "WHERE cty.cityDistrict = ? " +
                            "ORDER BY c.Population DESC " +
                            "LIMIT ?";

                    //Sets up the prepared statement
                    PreparedStatement ps = db.connect(true).prepareStatement(sql);


                    //Assign userInput to the first parameterIndex
                    ps.setInt(2, Integer.parseInt(limit));

                    // Execute SQL statement
                    ResultSet rset = ps.executeQuery();

                    String fileName = "csv/cities/set_cities_in_district/Set Number of Cities in world.csv";

                    //Creates an ArrayList of cities to store data
                    ArrayList<City> cities = new ArrayList<>();

                    // Check that a city is returned and add the data to the ArrayList
                    while (rset.next()) {
                        City cty = new City();
                        cty.cityName = rset.getString("Name");
                        CSVCreator.createCSV(fileName, rset);
                        cities.add(cty);
                    }

                    return cities;

                } catch (SQLException | IOException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to get cities");
                    return null;
                }

}}