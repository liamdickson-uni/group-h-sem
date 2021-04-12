package com.group.sem;




import java.io.IOException;
import java.sql.*;
import java.util.*;



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

            //Defines the prepared SQL Statement
            String sql = "SELECT c.Name, c.Continent, c.Population" +
                            " FROM country c" +
                            " ORDER BY c.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Creates an ArrayList of countries to store data
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
    public ArrayList<Country> getCountryInContinentByPop(String userContinent)  {

        try {
            // Defines the prepared SQL statement
            String sql = " SELECT c.Continent, c.Name" +
                            " FROM country c WHERE c.Continent = ?" +
                            " ORDER BY c.Continent, c.Population DESC";

            //Sets up the prepared statement
           PreparedStatement ps = db.connect(true).prepareStatement(sql);

           //Assigns user input to parameter index
            ps.setString(1,userContinent);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/countries_in_continent/Capital Cities in " + userContinent + ".csv";

            // Creates an ArrayList of countries to pass back to method
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a country is returned
            while (rset.next()) {
                //Adds data from the result set to an ArrayList
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Continent = rset.getString("Continent");
                CSVCreator.createCSV(fileName,rset);
                countries.add(cnt);
            }




            return countries;


        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries in selected continent");
            return null;
        }
    }

    /**
     * This method gets a list of countries in a specified region
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getCountryInRegionByPop(String region) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Region, c.Name, c.Population " +
                    "FROM country c " +
                    "WHERE c.Region = ? " +
                    "ORDER BY c.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, region);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
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
