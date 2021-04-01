package com.group.sem;

import java.io.FileWriter;
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
     * @return ArrayList of Cities
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
            String filename = "csv/cities/cities_in_country/Cities in " + country + ".csv";

            //Creates a string called record to be used later
            String record = null;

            //Creates a new FileWriter and passes the filename and path to it
            FileWriter fileWriter = new FileWriter(filename);

            //Accesses the metadata from the result set to be used later
            ResultSetMetaData metaData = rset.getMetaData();

            //Gets the columns from the result set metadata and
            int columns = metaData.getColumnCount();

            //Creates an ArrayList of countries to pass back to a method
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                //Adds data from the result set to an ArrayList
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cities.add(cty);

                //Adds data from the result set to a new csv file
                for (int i =1; i <= columns; i++) {
                    record = rset.getString(i);
                    fileWriter.append(rset.getString(i));
                    fileWriter.append(',');
                }
                //Skips to the next line
                fileWriter.append('\n');
            }

            //Closes the file writer
            fileWriter.close();

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
            // Return new country while valid.

            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
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
     * @return an ArrayList of Cities
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
            // Return new country while valid.

            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
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
            // Return new country while valid.

            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityDistrict = rset.getString("District");
                cty.cityName = rset.getString("Name");
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
     *
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
            // Return new country while valid.

            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
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
     * This method gets a list cities in a district ordered by population
     *
     * @return an ArrayList of Cities
     */

    public ArrayList<City> getDistrictByPop(String userDistrict) {

        try {
            //Defines the prepared SQL statement
            String sql = " SELECT cty.District, sum(cty.Population) as pop" +
                            " FROM city cty" +
                            " WHERE cty.District = ?" +
                            " ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, userDistrict);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();
            // Return new country while valid.

            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityDistrict = rset.getString("District");
                cty.cityPopulation = rset.getInt("pop");
                cities.add(cty);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population for in selected district");
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
            ps.setString(1,userContinent);

            //Execute SQL Statement
            ResultSet rset = ps.executeQuery();

            //Create a list to store the data
            ArrayList<City> cities = new ArrayList<>();

            //Check a result is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
                cities.add(cty);
            }
             return cities;
        } catch (SQLException e) {
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
    public ArrayList<City> getCapitalCitiesInRegionByPoP(String Region) {

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
            ps.setString(1, Region);

            //Execute SQL Statement
            ResultSet rset = ps.executeQuery();

            //Create a list to store the data
            ArrayList<City> cities = new ArrayList<>();

            //Check a result is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
                cities.add(cty);
            }
            return cities;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities and their populations.");
            return null;
        }

    }


}