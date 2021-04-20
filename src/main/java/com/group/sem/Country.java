package com.group.sem;




import java.io.IOException;
import java.sql.*;
import java.util.*;



/**
 * Wildcat Bikes -- Global Market Information
 * Group H -- SET08103
 * By Tom McEachan (40356376), Liam Dickson (40456372), Greig Dunbar (40430731), Jack Burton (40456783)
 * <p>
 * Country.java
 * Country.java contains all of the variables and methods associated with the country table in the world.sql database.
 * Variables in this class include:
 * <p>
 * code
 * name
 * continent
 * region
 * surfaceArea
 * population
 * lifeExpectancy
 * GNP
 * GNPOld
 * localName
 * governmentForm
 * headOfState
 * capital
 * code2
 * <p>
 * <p>
 * Methods in this in this class include:
 * <p>
 * getCountriesByPopDesc()
 * getCountryInContinentByPop()
 * getCountryInRegionByPop()
 */



/*
 * Represents a country
 */
public class Country {


    /**
     * The following code creates a singleton instance of the Country Class to be used throughout the program
     */

    //Private constructor
    private static Country INSTANCE;

    //Empty Constructor
    Country() {
    }

    //Static factory method for obtaining the instance
    public static Country getInstance() {
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

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/countries_by_population/Countries by population" + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<Country>();

            // Check one is returned
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Population = rset.getInt("Population");
                CSVCreator.createCSV(fileName, rset);
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
     *
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getCountryInContinentByPop(String userContinent) {

        try {
            // Defines the prepared SQL statement
            String sql = " SELECT c.Continent, c.Name" +
                    " FROM country c WHERE c.Continent = ?" +
                    " ORDER BY c.Continent, c.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assigns user input to parameter index
            ps.setString(1, userContinent);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/countries_in_continent/Countries in " + userContinent + ".csv";

            // Creates an ArrayList of countries to pass back to method
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a country is returned
            while (rset.next()) {
                //Adds data from the result set to an ArrayList
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Continent = rset.getString("Continent");
                CSVCreator.createCSV(fileName, rset);
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
     *
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

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/countries_in_region/Countries in " + region + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a country is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Region = rset.getString("Region");
                cnt.Population = rset.getInt("Population");
                CSVCreator.createCSV(fileName, rset);
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country in selected region");
            return null;
        }
    }


    public ArrayList<Country> getWorldPopulation() {
        try {

            //Defines the prepared SQL Statement
            String sql = "SELECT sum(c.Population) as Population" +
                    " FROM country c";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/population/world-population/World Population" + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Population = rset.getInt("Population");
                CSVCreator.createCSV(fileName, rset);
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population");
            return null;
        }
    }


    public ArrayList<Country> getCountryPopulation(String userCountry) {

        try {
            // Defines the prepared SQL statement
            String sql = " SELECT c.Name, c.Population" +
                    " FROM country c WHERE c.Name = ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);


            //Assigns user input to parameter index
            ps.setString(1, userCountry);


            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/country_population/Population of " + userCountry + ".csv";

            // Creates an ArrayList of countries to pass back to method
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a country is returned
            while (rset.next()) {
                //Adds data from the result set to an ArrayList
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Population = rset.getInt("Population");
                CSVCreator.createCSV(fileName, rset);
                countries.add(cnt);
            }


            return countries;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population in selected country");
            return null;
        }
    }


    /**
     * This method gets a set number of countries in a specified region
     *
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getSetNCountryInRegionByPop(String region, String limit) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Region, c.Name, c.Population " +
                    "FROM country c " +
                    "WHERE c.Region = ? " +
                    "ORDER BY c.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);


            //Assign userInput to the first parameterIndex
            ps.setString(1, region);
            ps.setInt(2, Integer.parseInt(limit));

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            String fileName = "csv/countries/set_countries_in_region/Set Number of Countries in " + region + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Region = rset.getString("Region");
                CSVCreator.createCSV(fileName, rset);
                countries.add(cnt);
            }

            return countries;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries in selected region");
            return null;
        }
    }


    /**
     * This method gets the population of a continent
     *
     * @return the number of people in a continent
     */
    public ArrayList<Country> getPopOfContinent(String continent) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT sum(c.population) as 'Population'" +
                    " FROM country c" +
                    " WHERE c.continent = ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, continent);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/population_of_continent/Population of " + continent + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> Countries = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Population = rset.getInt("Population");
                CSVCreator.createCSV(fileName, rset);
                Countries.add(cnt);
            }
            return Countries;
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country in selected region");
            return null;
        }
    }

    /**
     * This method gets the population of a region
     *
     * @return the number of people in a region
     */
    public ArrayList<Country> getPopOfRegion(String region) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT SUM (c.population)" +
                    "FROM country c" +
                    " WHERE c.Region =?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, region);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/population_of_region/Population of " + region + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> Countries = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Population = rset.getInt("Population");
                CSVCreator.createCSV(fileName, rset);
                Countries.add(cnt);
            }
            return Countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of selected continent");
            return null;
        }
    }

}

