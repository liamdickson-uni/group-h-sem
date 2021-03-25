package com.group.sem;

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
    public ArrayList<City> getCitiesInCountryByPop() {

        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
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
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Name, c.Population FROM city c ORDER BY c.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
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
    public ArrayList<City> getCitiesInCont() {

        System.out.println("Which continent would you like to see cities in");

        String contInput = "Europe";

        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT cty.Name" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Code = cty.CountryCode) " +
                            "WHERE cnt.Continent IN ('" + contInput + "')" +
                            "ORDER BY cty.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
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
    public ArrayList<City> getCitiesInDistrictByPop() {

        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT cty.District, cty.Name" +
                            " FROM city cty" +
                            " WHERE cty.District = 'Mendoza'" +
                            "ORDER BY cty.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
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
    public ArrayList<City> getCitiesInRegion() {

        System.out.println("Which Region would you like to see cities in");

        String regInput = "Caribbean";

        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT cty.Name" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Code = cty.CountryCode) " +
                            " WHERE cnt.Region IN ('" + regInput + "')" +
                            " ORDER BY cty.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
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

    public ArrayList<City> getDistrictByPop() {

        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT cty.District, sum(cty.Population) as pop" +
                            " FROM city cty" +
                            " WHERE cty.District IN ('Mendoza')" +
                            " ORDER BY cty.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
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
    public ArrayList<City> getCapitalCitiesInContinentByPoP() {

        try {
            //Create a SQL Statement
            Statement stmt = db.connect(true).createStatement();

            //Create String fro SQL Statement

            String strSelect =
                    "SELECT cty.Name, cty.Population" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Capital = cty.ID) " +
                            " WHERE cnt.Continent = 'Europe'" +
                            " ORDER BY cty.Population DESC";

            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

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
            //Create a SQL Statement
            Statement stmt = db.connect(true).createStatement();

            //Create String fro SQL Statement

            String strSelect =
                    "SELECT cty.Name, cty.Population" +
                            " FROM city cty" +
                            " JOIN country cnt ON (cnt.Capital = cty.ID)" +
                            " WHERE cnt.Region =" + Region  +
                            " ORDER BY cty.Population DESC";

            //Execute SQL Statement
            ResultSet rset = stmt.executeQuery(strSelect);

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