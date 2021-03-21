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
 * Variables in this class include:
 *
 *     cityID
 *     cityName
 *     countryCode
 *     cityDistrict
 *     cityPopulation
 *
 * Methods in this in this class include:
 * <
 *     getCitiesInCountryByPop()
 *     getCitiesByPop()
 *     getCitiesInCont()
 *     getCitiesInDistrictByPop()
 *     getCitiesInRegion()
 *
 */



/*
 * This class represents a city
 */
public class City {
    /*
     * Represents a City
     */
    public String cityID;


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


    App app = new App();

    public ArrayList<City> getCitiesInCountryByPop() {

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
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

    public ArrayList<City> getCitiesByPop() {

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
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


    public ArrayList<City> getCitiesInCont() {

        System.out.println("Which continent would you like to see cities in");

        String contInput = "Europe";

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
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

    public ArrayList<City> getCitiesInDistrictByPop() {

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT cty.District, cty.Name" +
                            " FROM city cty" +
                            "WHERE cty.District = 'Mendoza'" +
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

    public ArrayList<City> getCitiesInRegion() {

        System.out.println("Which Region would you like to see cities in");

        String regInput = "Caribbean";

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
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

    public ArrayList<City> getDistrictByPop() {

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT cty.District, cty.Population" +
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
                cty.cityPopulation = rset.getInt("Population");
                cities.add(cty);
            }
            return cities;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population for in selected district");
            return null;

        }
    }
}