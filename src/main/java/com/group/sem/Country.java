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
    public long Population;

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

    /*
     * Represents CityPercentage
     */
    public float CityPercentage;

    /*
     * Represents RuralPercentage
     */
    public float RuralPercentage;

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
                cnt.Population = rset.getLong("Population");
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

    public ArrayList<Country>  getCountriesInRegionByPop(String region) {

        try {
            //Defines the prepared SQL statement to
            String sql = "SELECT cnt.Name, cnt.Region, cnt.Population" +
                    " FROM country cnt" +
                    " WHERE cnt.Region =?" +
                    " ORDER BY cnt.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, region);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/country_in_region_by_pop/Countries in " + region + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> Countries = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Name");
                cnt.Name = rset.getString("Region");
                cnt.Population = rset.getInt("Population");
                Countries.add(cnt);
                CSVCreator.createCSV(fileName, rset);
            }
            return Countries;
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the countries in " + region + ". Please try again.");
            return null;
        }
    }
    /**
     * This method gets a continent population report
     *
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getContinentPopReport(String continent) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT continent" +
                    "(SELECT SUM(Population) FROM country c WHERE c.Continent IN (?)) as ContinentPopulation " +
                    "(SUM(ci.Population) / (SELECT SUM(Population) FROM country c WHERE c.Continent IN (?)) * 100) AS CityPercentage," +
                    "((((SELECT SUM(Population) FROM country c WHERE c.Continent IN (?)) - SUM(ci.Population)) / (SELECT SUM(Population) FROM country c WHERE c.Continent IN (?))) * 100) AS RuralPercentage" +
                    "FROM city ci " +
                    "INNER JOIN country c on ci.CountryCode = c.Code" +
                    "WHERE c.Continent IN (?)";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1,continent);
            ps.setString(2,continent);
            ps.setString(4,continent);
            ps.setString(5,continent);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/continent_report/" + continent + " Population Report.csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a country is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Continent = rset.getString("Continent");
                cnt.Population = rset.getInt("Population");
                cnt.CityPercentage = rset.getFloat("CityPercentage");
                cnt.RuralPercentage = rset.getFloat("RuralPercentage");
                CSVCreator.createCSV(fileName, rset);
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent report");
            return null;
        }
    }
    /**
     * This method gets a region population report
     *
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getRegionPopReport(String region) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT Region" +
                    "(SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) as RegionPopulation " +
                    "(SUM(ci.Population) / (SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) * 100) AS CityPercentage," +
                    "((((SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) - SUM(ci.Population)) / (SELECT SUM(Population) FROM country c WHERE c.Region IN (?))) * 100) AS RuralPercentage" +
                    "FROM city ci " +
                    "INNER JOIN country c on ci.CountryCode = c.Code" +
                    "WHERE c.Region IN (?)";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1,region);
            ps.setString(2,region);
            ps.setString(4,region);
            ps.setString(5,region);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/region_report/" + region + " Population Report.csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a country is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Region = rset.getString("Region");
                cnt.Population = rset.getInt("Population");
                cnt.CityPercentage = rset.getFloat("CityPercentage");
                cnt.RuralPercentage = rset.getFloat("RuralPercentage");
                CSVCreator.createCSV(fileName, rset);
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region report");
            return null;
        }
    }
    /**
     * This method gets a Country population report
     *
     * @return an ArrayList of countries
     */
    public ArrayList<Country> getCountryPopReport(String country) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT Name" +
                    "(SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) as CountryPopulation " +
                    "(SUM(ci.Population) / (SELECT SUM(Population) FROM country c WHERE c.Country IN (?)) * 100) AS CityPercentage," +
                    "((((SELECT SUM(Population) FROM country c WHERE c.Country IN (?)) - SUM(ci.Population)) / (SELECT SUM(Population) FROM country c WHERE c.Country IN (?))) * 100) AS RuralPercentage" +
                    "FROM city ci " +
                    "INNER JOIN country c on ci.CountryCode = c.Code" +
                    "WHERE c.Country IN (?)";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1,country);
            ps.setString(2,country);
            ps.setString(4,country);
            ps.setString(5,country);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/country_report/" + country + " Population Report.csv";

            //Creates an ArrayList of countries to store data
            ArrayList<Country> countries = new ArrayList<>();

            // Check that a country is returned and add the data to the ArrayList
            while (rset.next()) {
                Country cnt = new Country();
                cnt.Name = rset.getString("Country");
                cnt.Population = rset.getInt("Population");
                cnt.CityPercentage = rset.getFloat("CityPercentage");
                cnt.RuralPercentage = rset.getFloat("RuralPercentage");
                CSVCreator.createCSV(fileName, rset);
                countries.add(cnt);
            }
            return countries;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country report");
            return null;
        }
    }
}

