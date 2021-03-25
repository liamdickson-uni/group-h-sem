package com.group.sem;

import java.sql.*;
import java.util.ArrayList;


/**
 * Wildcat Bikes -- Global Market Information
 * Group H -- SET08103
 * By Tom McEachan (40356376), Liam Dickson (40456372), Greig Dunbar (40430731), Jack Burton (40456783)
 *
 * Country.java
 * Country.java contains all of the variables and methods associated with the country table in the world.sql database.
 * Variables in this class include:
 *
 *     code
 *     name
 *     continent
 *     region
 *     surfaceArea
 *     population
 *     lifeExpectancy
 *     GNP
 *     GNPOld
 *     localName
 *     governmentForm
 *     headOfState
 *     capital
 *     code2
 *
 *
 * Methods in this in this class include:
 *
 *     getCountriesByPopDesc()
 *     getCountryInContinentByPop()
 *     getCountryInRegionByPop()
 *
 */



/*
 * Represents a country
 */
public class Country {


    /**
     *  The following code creates a singleton instance of the Country Class to be used throughout the program
     */

    //Private constructor
    private static Country INSTANCE;

    //Empty Constructor
    private Country(){
    }

    //Static factory method for obtaining the instance
    public static Country getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new Country();
        }
        return INSTANCE;
    }


    /*
     * Represents Country Code
     */
    public String Code;

    /*
     * Represents Country Name
     */
    public String Name;


    /*
     * Represents Country Continent
     */
    public String Continent;

    /*
     * Represents Country Region
     */
    public String Region;

    /*
     * Represents Country Surface Area
     */
    public double SurfaceArea;

    /*
     * Represents Population
     */
    public int Population;

    /*
     * Represents Life Expectancy
     */
    public int LifeExpectancy;

    /*
     * Represents Gross National Product
     */
    public double GNP;

    /*
     * Represents Gross National Product(Old)
     */
    public double GNPOld;

    /*
     * Represents Local Name
     */
    public String LocalName;

    /*
     * Represents Government Form
     */
    public String GovernmentForm;

    /*
     * Represents Head of State
     */
    public String HeadOfState;

    /*
     * Represents Capital
     */
    public String Capital;

    /*
     * Represents Code2
     */
    public String code2;


    //Gets the singleton instance of App
    App app = App.getInstance();

    //Gets the singleton instance of Database Connection
    DatabaseConnection db = DatabaseConnection.getInstance();

    /*
     * These methods are used to get country data and to display country data.
     */


    /**
     * This method gets a list of countries organised by population
     *
     * @return an ArrayList of Countries
     */
    public ArrayList<Country> getCountryByPopDesc() {
        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Name, c.Continent, c.Population" +
                            " FROM country c" +
                            " ORDER BY c.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country while valid.
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Population = rset.getInt("Population");
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries by population");
            return null;
        }
    }

    /**
     * This method gets a list of countries
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getCountryInContinentByPop() {

        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();

            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Continent, c.Name" +
                            " FROM country c" +
                            " ORDER BY c.Continent, c.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Return new country while valid.
            ArrayList<Country> countries = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Continent = rset.getString("Continent");
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries in selected continent");
            return null;
        }
    }

    /**
     * This method gets a list of countries in a specified region
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getCountryInRegionByPop() {

        try {
            // Create an SQL statement
            Statement stmt = db.connect(true).createStatement();
            // Create string for SQL statement
            String strSelect =
                    " SELECT c.Region, c.Name, c.Population" +
                            " FROM country c" +
                            " WHERE c.Region = 'Southern Europe'" +
                            " ORDER BY c.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country while valid.

            ArrayList<Country> countries = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Region = rset.getString("Region");
                cnt.Population = rset.getInt("Population");
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country in selected region");
            return null;
        }
    }

    public enum RegionEnum {
        EASTERN_ASIA    ("Eastern Asia"),
        MIDDLE_EAST     ("Middle East"),
        SOUTHEAST_ASIA  ("Southeast Asia"),
        SOUTHERN_AND_CENTRAL_ASIA   ("Southern and Central Asia"),
        BALTIC_COUNTRIES    ("Baltic Countries"),
        BRITISH_ISLANDS     ("British Islands"),
        EASTERN_EUROPE  ("Eastern_Europe"),
        NORDIC_COUNTRIES    ("Nordic Countries"),
        SOUTHERN_EUROPE     ("Southern Europe"),
        WESTERN_EUROPE  ("Western Europe"),
        CARIBBEAN   ("Caribbean"),
        CENTRAL_AMERICA ("Central America"),
        NORTH_AMERICA   ("North America"),
        CENTRAL_AFRICA  ("Central Africa"),
        EASTERN_AFRICA  ("Eastern Africa"),
        NORTHERN_AFRICA ("Northern Africa"),
        SOUTHERN_AFRICA ("Southern Africa"),
        WESTERN_AFRICA  ("Western Africa"),
        AUSTRALIA_AND_NEW_ZEALAND   ("Australia and New Zealand"),
        MELANESIA   ("Melanesia"),
        MICRONESIA  ("Micronesia"),
        MICRONESIA_CARIBBEAN    ("Micronesia/Caribbean"),
        POLYNESIA   ("Polynesia"),
        ANTARTICA   ("Antartica"),
        SOUTH_AMERICA   ("South America"),
        ;

        public final String label;

        RegionEnum(String label) {
            this.label = label;
        }

        public static RegionEnum valueOfLabel(String label) {

            for (RegionEnum r : values()) {
                if (r.label.equals(label)) {
                    return r;
                }
            } return null;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
