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
 * getCitiesInCountryByPop()
 * getCitiesByPop()
 * getCitiesInCont()
 * getCitiesInDistrictByPop()
 * getCitiesInRegion()
 * getDistrictByPop()
 * getCapitalCitiesInContinentByPoP()
 * getCapitalCitiesInRegionByPop()
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

    /*  Represents the name of a Country
     */
    public String countryName;

    /*
     * These methods are used to get city data and to display city data.
     */

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
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

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
                    " ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/district/district_by_pop/All Districts By Population" + ".csv";

            //Creates an Empty ArrayList of Cities
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("City");
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
            System.out.println("Failed to get data on the selected district");
            return null;

        }
    }

    /**
     * This method gets a list of cities populations
     * 14
     *
     * @param userCity - User selected city
     * @return an ArrayList of cities populations
     */
    public ArrayList<City> getCitiesPopulation(String userCity) {

        try {
            //Defines the prepared SQL statement
            String sql = " SELECT cty.Name, cty.Population" +
                    " FROM city cty" +
                    " WHERE cty.Name = ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, userCity);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_population/Population of " + userCity + ".csv";

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
            System.out.println("Failed to get population of city");
            return null;
        }
    }

    /**
     * This method gets capital cities in a continent, ordered by population
     * 22
     *
     * @param continent - User selected continent
     * @param limit     - User set limit
     * @return an ArrayList of capital cities in a continent
     */
    public ArrayList<City> getSetNCapitalCitiesInContByPop(String continent, int limit) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT cty.Name, cty.Population" +
                    " FROM city cty " +
                    "JOIN country cnt ON cnt.Capital = cty.ID" +
                    " WHERE cnt.Continent = ? " +
                    "ORDER BY cnt.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, continent);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            String fileName = "csv/cities/get_n_capital_cities_in_cont/Set Number of Cities in " + continent + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<City> cities = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
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
            System.out.println("Failed to get capital cities in selected continent");
            return null;
        }
    }

    /**
     * @param continent
     * @param limit
     * @return
     */
    public ArrayList<City> getSetNCitiesInContByPop(String continent, String limit) {

        try {

            //Defines the prepared SQL statement
            String sql = "SELECT cty.Name, cty.Population" +
                    " FROM city cty " +
                    " JOIN country c ON c.Code = cty.CountryCode" +
                    " WHERE c.Continent = ? " +
                    "ORDER BY c.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);


            //Assign userInput to the first parameterIndex
            ps.setString(1, continent);
            ps.setInt(2, Integer.parseInt(limit));

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            String fileName = "csv/cities/set_cities_in_cont/Set Number of Cities in " + continent + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<City> cities = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
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
            System.out.println("Failed to get cities in selected continent");
            return null;
        }
    }


    /**
     * This method gets a specified list of cities in a district ordered by population
     *
     * @return an ArrayList of Cities
     */
    public ArrayList<City> setNGetCitiesInDistrictByPop(String userDistrict, int limit) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT cty.District, cty.Name" +
                    " FROM city cty" +
                    " WHERE cty.District = ?" +
                    "ORDER BY cty.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, userDistrict);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/set_cities_in_district/" + "Cities in " + userDistrict + ".csv";

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
            System.out.println("Failed to get cities in selected district");
            return null;
        }
    }


    /**
     * This method gets a specified list of cities in a region ordered by population
     *
     * @return an ArrayList of Cities
     */
    public ArrayList<City> setNGetCitiesInRegionByPop(String userRegion, int limit) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT cty.Name" +
                    " FROM city cty" +
                    " INNER JOIN country c ON c.code = cty.CountryCode" +
                    " WHERE c.Region = ?" +
                    " ORDER BY cty.Population DESC" +
                    " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, userRegion);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/set_cities_in_region/" + "Cities in " + userRegion + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
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
            System.out.println("Failed to get cities in selected region");
            return null;

        }

    }

    /**
     * This method gets a set number of cities in a the world
     *
     * @return an ArrayList of cities
     */
    public ArrayList<City> getSetNCityInWorldByPop(String limit) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT  cty.Name, cty.Population" +
                    " FROM city cty " +
                    "ORDER BY cty.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setInt(1, Integer.parseInt(limit));

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Create a filepath
            String fileName = "csv/cities/set_n_cities_in_world/Set Number of Cities in world.csv";

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
            System.out.println("Failed to get cities");
            return null;
        }

    }

    /**
     * This method gets a set number of cities in a the world
     *
     * @return an ArrayList of cities
     */
    public ArrayList<City> getSetNCityInCountryByPop(String limit, String userCountry) {

        try {
            //Defines the prepared SQL statement
            String sql =
                    " SELECT  cty.Name, cty.Population, cnt.Name" +
                            " FROM city cty " +
                            " JOIN country cnt ON cnt.Code = cty.CountryCode" +
                            " WHERE cnt.Name = ? " +
                            " ORDER BY cty.Population DESC " +
                            " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);


            //Assign userInput to the first parameterIndex
            ps.setString(1, userCountry);
            ps.setInt(2, Integer.parseInt(limit));

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Create a filepath
            String fileName = "csv/cities/set_n_cities_in_country_by_pop/Top " + limit + " cities in " + userCountry + ".csv";

            //Creates an ArrayList of cities to store data
            ArrayList<City> cities = new ArrayList<>();

            // Check that a city is returned and add the data to the ArrayList
            while (rset.next()) {
                City cty = new City();
                cty.cityName = rset.getString("Name");
                cty.cityPopulation = rset.getInt("Population");
                cty.countryName = rset.getString("Name");
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
            System.out.println("Failed to get cities");
            return null;
        }

    }

    /**
     * This method gets a specified list of cities in a continent ordered by population
     *
     * @return an ArrayList of Cities
     */
    public ArrayList<City> setNGetCitiesInContinentByPop(String userContinent, int limit) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT cty.Name" +
                    " FROM city cty" +
                    " INNER JOIN country c ON c.code = cty.CountryCode" +
                    " WHERE c.Continent = ?" +
                    " ORDER BY cty.Population DESC" +
                    " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, userContinent);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/set_cities_in_continent/" + "Cities in " + userContinent + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<City> cities = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                City cty = new City();
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
            System.out.println("Failed to get cities in selected continent");
            return null;


        }
    }


}