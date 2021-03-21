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




    App app = new App();

    /*
     * These methods are used to get country data and to display country data.
     */


    public ArrayList<Country> getCountryByPopDesc() {
        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
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

    public ArrayList<Country> getCountryInContinentByPop() {

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();

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

    public ArrayList<Country> getCountryInRegionByPop() {

        try {
            // Create an SQL statement
            Statement stmt = app.connect(true).createStatement();
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

}
