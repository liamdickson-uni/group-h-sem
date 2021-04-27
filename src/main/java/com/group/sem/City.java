package com.group.sem;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


/**
 * Wildcat Bikes -- Global Market Information
 * Group H -- SET08103
 * By Tom McEachan (40356376), Liam Dickson (40456372), Greig Dunbar (40430731), Jack Burton (40456783)
 * <p>
 * City.java
 * City.java contains all of the variables and methods associated with the city table in the world.sql database.
 * <p>
 * Variables in this class include:
 * <p>
 * cityID
 * cityName
 * countryCode
 * cityDistrict
 * cityPopulation
 * <p>
 * Methods in this in this class include:
 * <p>
 * getCitiesByPop()
 * getCitiesInDistrictByPop()
 * getDistrictByPop()
 * getCitiesPopulation()
 * setNGetCitiesInDistrictByPop()
 * getSetNCityInWorldByPop()
 */



/*
 * This class represents a city
 */
public class City {

    /**
     * The following code creates a singleton instance of the City Class to be used throughout the program
     */

    //Private constructor
    private static City INSTANCE;

    //Empty Constructor
    private City() {
    }

    //Static factory method for obtaining the instance
    public static City getInstance() {
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

    //Gets singleton instance of App
    App app = App.getInstance();

    //Gets singleton instance of Database Connection
    DatabaseConnection db = DatabaseConnection.getInstance();

    //Gets the singleton instance of Country
    Country cnt = Country.getInstance();


    /**
     * This methods get a list of cities ordered by population
     * 5
     *
     * @return ArrayList of Cities
     */
    public ArrayList<City> getCitiesByPop() {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Name, c.Population FROM city c ORDER BY c.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

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
                cities.add(cty);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities by population");
            return null;

        }
    }

    /**
     * This method gets a list of cities in a district ordered by population
     * 6
     *
     * @param district - User selected district
     * @return an ArrayList of Cities
     */
    public ArrayList<City> getCitiesInDistrictByPop(String district) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT cty.District, cty.Name" +
                    " FROM city cty" +
                    " WHERE cty.District = ?" +
                    " ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, district);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_district/Cities in " + district + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityDistrict = rset.getString("District");
                cty.cityName = rset.getString("Name");
                cities.add(cty);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + district + ".");
            return null;

        }
    }

    /**
     * This method gets a list of districts and orders them by population
     * 9
     *
     * @return an ArrayList of Cities
     */
    public ArrayList<City> getDistrictByPop() {

        try {
            //Defines the prepared SQL statement
            String sql = " SELECT cty.District, sum(cty.Population) as Population" +
                    " FROM city cty" +
                    " GROUP BY cty.District" +
                    " ORDER BY sum(cty.Population) DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/district_by_pop/All Districts By Population" + ".csv";

            //Creates an Empty ArrayList of Cities
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityDistrict = rset.getString("District");
                cty.cityPopulation = rset.getInt("Population");
                cities.add(cty);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data on the districts");
            return null;

        }
    }

    /**
     * This method gets a list of cities populations
     * 14
     *
     * @param city - User selected city
     * @return an ArrayList of cities populations
     */
    public ArrayList<City> getCitiesPopulation(String city) {

        try {
            //Defines the prepared SQL statement
            String sql = " SELECT cty.Name, cty.Population" +
                    " FROM city cty" +
                    " WHERE cty.Name = ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, city);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_population/Population of " + city + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
                cities.add(cty);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of " + city + ".");
            return null;
        }
    }

    /**
     * This method gets a specified list of cities in a district ordered by population
     * 27
     *
     * @param district - User selected city
     * @param limit - User set limit
     * @return an ArrayList of Cities
     */
    public ArrayList<City> setNGetCitiesInDistrictByPop(String district, int limit) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT cty.District, cty.Name" +
                    " FROM city cty" +
                    " WHERE cty.District = ?" +
                    "ORDER BY cty.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, district);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/set_cities_in_district/Cities in " + district + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityDistrict = rset.getString("District");
                cty.cityName = rset.getString("Name");
                cities.add(cty);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities  " + district + ".");
            return null;
        }
    }

    /**
     * This method gets a set number of cities in a the world
     * 29
     *
     * @param limit - User set limit
     * @return an ArrayList of cities
     */
    public ArrayList<City> getSetNCityInWorldByPop(int limit) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT cty.Name, cty.Population" +
                    " FROM city cty " +
                    "ORDER BY cty.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setInt(1, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Create a filepath
            String fileName = "csv/cities/set_n_cities_in_world/Get " + limit + " Cities in the world.csv";

            //Creates an ArrayList of cities to store data
            ArrayList<City> cities = new ArrayList<>();

            // Check that a city is returned and add the data to the ArrayList
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
                cities.add(cty);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return cities;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get " + limit + " cities in the world");
            return null;
        }

    }

}