package com.group.sem;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Wildcat Bikes -- Global Market Information
 * Group H -- SET08103
 * By Tom McEachan (40356376), Liam Dickson (40456372), Greig Dunbar (40430731), Jack Burton (40456783)
 * <p>
 * World.java
 * World.java contains all of the variables and methods associated with the multiple tables in the world.sql database.
 * <p>
 * Variables in this class include:
 * <p>
 * countryCode
 * countryName
 * cityName
 * cityDistrict
 * cityPopulation
 * ruralPopulation
 * region
 * countryPopulation
 * regionPopulation
 * continentPopulation
 * languagePercentage
 * language
 * continent
 * cityPercentage
 * ruralPercentage
 * <p>
 * Methods in this in this class include:
 * <p>
 * getCitiesInCountryByPop()
 * getCitiesInCont()
 * getCitiesInRegion()
 * getCapitalCitiesInContinentByPoP()
 * getCapitalCitiesInRegionByPoP()
 * getCityInfo()
 * getSetNCapitalCitiesInRegionByPop()
 * getLanguagePercentage()
 * getSetNCapitalCitiesInContByPop(
 * getSetNCitiesInContByPop()
 * getContinentPopReport()
 * getRegionPopReport()
 * getCountryPopReport()
 * setNGetCitiesInRegionByPop()
 * getSetNCityInCountryByPop()
 * getSetNCapitalCitiesInWorld()
 * getCitiesAndRuralForCountry()
 * setNGetCitiesInContinentByPop()
 * getCitiesAndRuralForContinent()
 * getCitiesAndRuralForRegion()
 * getCountryReport()
 */

public class World {

    /**
     * The following code creates a singleton instance of the World Class to be used throughout the program
     */

    //Private constructor
    private static World INSTANCE;

    //Empty Constructor
    World() {
    }

    //Static factory method for obtaining the instance
    public static World getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new World();
        }
        return INSTANCE;
    }

    /*
     * Represents Country Name
     */
    public String countryCode;

    /*
     * Represents Country Name
     */
    public String countryName;

    /*
     * Represents a City Name
     */
    public String cityName;

    /*
     * Represents a City District
     */
    public String cityDistrict;

    /*
     * Represents a City Population
     */
    public long cityPopulation;
    /*
     * Represents a Rural Population
     */
    public long ruralPopulation;

    /*
     * Represents a countries region
     */
    public String region;

    /*
    Represents country population
     */
    public int countryPopulation;

    /*
     * Represents region population
     */
    public float regionPopulation;

    /*
     * Represents continent population
     */
    public float continentPopulation;

    /*
    Represents the percentage who speak a language
     */

    public float languagePercentage;

    /*
    Represents the Languages spoken in the world
     */
    public String language;

    /*
     * Represents Country Continent
     */
    public String continent;

    /*
     * Represents CityPercentage
     */
    public float cityPercentage;

    /*
     * Represents RuralPercentage
     */
    public float ruralPercentage;

    //Gets the singleton instance of Database Connection
    DatabaseConnection db = DatabaseConnection.getInstance();

    /**
     * This method gets the cities in a country ordered by population
     * 4
     *
     * @param country - User Selected Country
     * @return - ArrayList of Cities
     */
    public ArrayList<World> getCitiesInCountryByPop(String country) {

        try {

            //Defines the prepared SQL Statement
            String sql = "SELECT c.Name AS Country, ci.Name" +
                    " FROM city ci" +
                    " JOIN country c ON c.Code = ci.CountryCode" +
                    " WHERE c.Name = ?" +
                    " ORDER BY ci.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            ps.setString(1, country);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_country/Cities in " + country + ".csv";

            //Creates an ArrayList of countries to pass back to a method
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                //Adds data from the result set to an ArrayList
                World wld = new World();
                wld.countryName = rset.getString("Country");
                wld.cityName = rset.getString("Name");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + country + ".");
            return null;

        }
    }

    /**
     * This method gets a list of cities in a specified continent
     * 7
     *
     * @param continent - User selected continent
     * @return - An ArrayList of Cities
     */
    public ArrayList<World> getCitiesInCont(String continent) {

        try {

            // Defines the prepared SQL statement
            String sql = " SELECT cnt.Continent, cty.Name" +
                    " FROM city cty" +
                    " JOIN country cnt ON (cnt.Code = cty.CountryCode) " +
                    "WHERE cnt.Continent = ?" +
                    "ORDER BY cty.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, continent);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_continent/Cities in " + continent + ".csv";

            //Creates an empty ArrayList of Cities for printing
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                World wld = new World();
                wld.continent = rset.getString("Continent");
                wld.cityName = rset.getString("Name");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + continent + ".");
            return null;

        }
    }

    /**
     * This method gets a list of cities in a specified region, ordered by population
     * 8
     *
     * @param region - User selected region
     * @return an ArrayList of cities
     */
    public ArrayList<World> getCitiesInRegion(String region) {

        try {

            // Defines the prepared SQL statement
            String sql = " SELECT c.Region, ci.Name" +
                    " FROM city ci" +
                    " JOIN country c ON c.Code = ci.CountryCode" +
                    " WHERE c.Region = ?" +
                    " ORDER BY ci.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns userInput to parameterIndex
            ps.setString(1, region);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/cities_in_region/Cities in " + region + ".csv";

            //Creates an Empty ArrayList of World
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                World wld = new World();
                wld.region = rset.getString("Region");
                wld.cityName = rset.getString("Name");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + region + ".");
            return null;

        }
    }

    /**
     * This method gets a list of capital cities in a continent, organised by population
     * 10
     *
     * @param continent - User selected continent
     * @return an ArrayList of capital cities
     */
    public ArrayList<World> getCapitalCitiesInContinentByPoP(String continent) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Continent, ci.Name, ci.Population" +
                    " FROM city ci" +
                    " JOIN country c ON c.Capital = ci.ID" +
                    " WHERE c.Continent = ?" +
                    " ORDER BY ci.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns uer input to parameterIndex
            ps.setString(1, continent);

            //Execute SQL Statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/capitals_in_continent/Capital Cities in " + continent + ".csv";

            //Create a list to store the data
            ArrayList<World> world = new ArrayList<>();

            //Check a result is returned
            while (rset.next()) {
                World wld = new World();
                wld.continent = rset.getString("Continent");
                wld.cityName = rset.getString("Name");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in " + continent + ".");
            return null;
        }

    }

    /**
     * This method gets a list of capital cities in a specified region, ordered by population
     * 11
     *
     * @param region - User selected Region
     * @return an ArrayList of Capital Cities
     */
    public ArrayList<World> getCapitalCitiesInRegionByPoP(String region) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Region, ci.Name, ci.Population" +
                    " FROM city ci" +
                    " JOIN country c ON c.Capital = ci.ID" +
                    " WHERE c.Region = ?" +
                    " ORDER BY ci.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex 1
            ps.setString(1, region);

            //Execute SQL Statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/cities/capital_cities_in_region/Capital Cities in " + region + ".csv";

            //Create a list to store the data
            ArrayList<World> world = new ArrayList<>();

            //Check a result is returned
            while (rset.next()) {
                World wld = new World();
                wld.region = rset.getString("Region");
                wld.cityName = rset.getString("Name");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in " + region + ".");
            return null;
        }
    }

    /**
     * This method gets all the key information about a specified city
     * 15
     *
     * @param city    - User selected city
     * @param country - User selected country
     * @return an ArrayList information on a city
     */
    public ArrayList<World> getCityInfo(String city, String country) {

        try {
            //Defines the prepared SQL Statement
            String sql = "SELECT ci.Name AS City, c.Name AS Country, ci.District, ci.Population" +
                    " FROM city ci" +
                    " JOIN country c ON c.Code = ci.CountryCode" +
                    " WHERE ci.Name = ? AND c.Name = ?" +
                    " ORDER BY ci.Population DESC";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex 1
            ps.setString(1, city);
            ps.setString(2, country);

            //Execute SQL Statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/cities/city_info/Information on " + city + ".csv";

            //Create an ArrayList to store the data
            ArrayList<World> world = new ArrayList<>();

            //Check that a result is returned
            while (rset.next()) {
                World wld = new World();
                wld.cityName = rset.getString("City");
                wld.countryName = rset.getString("Country");
                wld.cityDistrict = rset.getString("District");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get info on " + city + ".");
            return null;
        }
    }

    /**
     * This method gets set capital cities in a region, ordered by population
     * 20
     *
     * @param region - User selected region
     * @param limit  - User set limit
     * @return an ArrayList of capital cities in a continent
     */
    public ArrayList<World> getSetNCapitalCitiesInRegionByPop(String region, int limit) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Region, ci.Name AS City, ci.Population" +
                    " FROM city ci" +
                    " JOIN country c ON c.Capital = ci.ID" +
                    " WHERE c.Region = ? " +
                    " ORDER BY ci.Population DESC" +
                    " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, region);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            String fileName = "csv/cities/get_n_capital_cities_in_region/Set Number of Cities in " + region + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.region = rset.getString("Region");
                wld.cityName = rset.getString("City");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in " + region + ".");
            return null;
        }
    }

    /**
     * This method gets the number and percentage of speakers of a selected language
     * 21
     *
     * @param language - User selected language
     * @return an ArrayList of language percentages
     */
    public ArrayList<World> getLanguagePercentage(String language) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT cl.Language, " +
                    " ROUND(Sum(((cl.Percentage/100) *  c.Population)),0) AS Population, " +
                    " ROUND((ROUND(Sum(((cl.Percentage/100) *  c.Population)),0) / (SELECT sum(c.Population) as Population FROM country c)* 100),2) As Percentage" +
                    " FROM countrylanguage cl" +
                    " INNER JOIN country c on cl.CountryCode = c.Code" +
                    " WHERE cl.Language = ? ";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);


            //Assign userInput to the first parameterIndex
            ps.setString(1, language);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            String fileName = "csv/language/get_language_percentage/People Who Speak " + language + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> languages = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.language = rset.getString("Language");
                wld.countryPopulation = rset.getInt("Population");
                wld.languagePercentage = rset.getFloat("Percentage");
                languages.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return languages;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data on " + language + ".");
            return null;
        }
    }

    /**
     * This method gets set capital cities in a continent, ordered by population
     * 22
     *
     * @param continent - User selected continent
     * @param limit     - User set limit
     * @return an ArrayList of capital cities in a continent
     */
    public ArrayList<World> getSetNCapitalCitiesInContByPop(String continent, int limit) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Continent, ci.Name, ci.Population" +
                    " FROM city ci " +
                    "JOIN country c ON c.Capital = ci.ID" +
                    " WHERE c.Continent = ? " +
                    "ORDER BY ci.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, continent);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            String fileName = "csv/cities/get_n_capital_cities_in_cont/Set Number of Cities in " + continent + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.continent = rset.getString("Continent");
                wld.cityName = rset.getString("Name");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in " + continent + ".");
            return null;
        }
    }

    /**
     * This method gets a specified list of cities populations in a continent
     * 23
     *
     * @param continent - User selected continent
     * @param limit     - User set limit
     * @return an ArrayList of cities populations
     */
    public ArrayList<World> getSetNCitiesInContByPop(String continent, int limit) {

        try {

            //Defines the prepared SQL statement
            String sql = "SELECT c.Continent, ci.Name, ci.Population" +
                    " FROM city ci " +
                    " JOIN country c ON c.Code = ci.CountryCode" +
                    " WHERE c.Continent = ? " +
                    "ORDER BY ci.Population DESC " +
                    "LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);


            //Assign userInput to the first parameterIndex
            ps.setString(1, continent);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            String fileName = "csv/cities/set_cities_in_cont/Set Number of Cities in " + continent + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.continent = rset.getString("Continent");
                wld.cityName = rset.getString("Name");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get " + limit + " cities in " + continent + ".");
            return null;
        }
    }

    /**
     * This method gets a continent population report
     * 24
     *
     * @param continent - User selected continent
     * @return an ArrayList of populations
     */
    public ArrayList<World> getContinentPopReport(String continent) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT continent," +
                    " (SELECT SUM(Population) FROM country c WHERE c.Continent IN (?)) as ContinentPopulation, " +
                    " (SUM(ci.Population) / (SELECT SUM(Population) FROM country c WHERE c.Continent IN (?)) * 100) AS CityPercentage," +
                    " ((((SELECT SUM(Population) FROM country c WHERE c.Continent IN (?)) - SUM(ci.Population)) / (SELECT SUM(Population) FROM country c WHERE c.Continent IN (?))) * 100) AS RuralPercentage" +
                    " FROM city ci " +
                    " INNER JOIN country c on ci.CountryCode = c.Code" +
                    " WHERE c.Continent IN (?)";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, continent);
            ps.setString(2, continent);
            ps.setString(3, continent);
            ps.setString(4, continent);
            ps.setString(5, continent);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/continent_report/" + continent + " Population Report.csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a country is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.continent = rset.getString("Continent");
                wld.continentPopulation = rset.getInt("ContinentPopulation");
                wld.cityPercentage = rset.getFloat("CityPercentage");
                wld.ruralPercentage = rset.getFloat("RuralPercentage");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get continent report");
            return null;
        }
    }

    /**
     * This method gets a region population report
     * 25
     *
     * @param region - User selected region
     * @return an ArrayList of populations
     */
    public ArrayList<World> getRegionPopReport(String region) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT Region," +
                    " (SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) as RegionPopulation, " +
                    " (SUM(ci.Population) / (SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) * 100) AS CityPercentage," +
                    " ((((SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) - SUM(ci.Population)) / (SELECT SUM(Population) FROM country c WHERE c.Region IN (?))) * 100) AS RuralPercentage" +
                    " FROM city ci " +
                    " INNER JOIN country c on ci.CountryCode = c.Code" +
                    " WHERE c.Region IN (?)";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, region);
            ps.setString(2, region);
            ps.setString(3, region);
            ps.setString(4, region);
            ps.setString(5, region);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/region_report/" + region + " Population Report.csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a country is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.region = rset.getString("Region");
                wld.regionPopulation = rset.getInt("RegionPopulation");
                wld.cityPercentage = rset.getFloat("CityPercentage");
                wld.ruralPercentage = rset.getFloat("RuralPercentage");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get region report");
            return null;
        }
    }

    /**
     * This method gets a Country population report
     * 26
     *
     * @param country - User selected country
     * @return an ArrayList of populations
     */
    public ArrayList<World> getCountryPopReport(String country) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT c.Name," +
                    " (SELECT SUM(Population) FROM country c WHERE c.Name IN (?)) as CountryPopulation, " +
                    " (SUM(ci.Population) / (SELECT SUM(Population) FROM country c WHERE c.Name IN (?)) * 100) AS CityPercentage," +
                    " ((((SELECT SUM(Population) FROM country c WHERE c.Name = ?) - SUM(ci.Population)) / (SELECT SUM(Population) FROM country c WHERE c.Name = ?)) * 100) AS RuralPercentage" +
                    " FROM city ci " +
                    " INNER JOIN country c on ci.CountryCode = c.Code" +
                    " WHERE c.Name = ?";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1, country);
            ps.setString(2, country);
            ps.setString(3, country);
            ps.setString(4, country);
            ps.setString(5, country);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/country_report/" + country + " Population Report.csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a country is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.countryName = rset.getString("Name");
                wld.countryPopulation = rset.getInt("CountryPopulation");
                wld.cityPercentage = rset.getFloat("CityPercentage");
                wld.ruralPercentage = rset.getFloat("RuralPercentage");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country report");
            return null;
        }
    }

    /**
     * This method gets a specified list of cities in a region ordered by population
     * 28
     *
     * @param region - User selected region
     * @param limit  - User set limit
     * @return an ArrayList of Cities
     */
    public ArrayList<World> setNGetCitiesInRegionByPop(String region, int limit) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT c.Region, ci.Name" +
                    " FROM city ci" +
                    " INNER JOIN country c ON c.code = ci.CountryCode" +
                    " WHERE c.Region = ?" +
                    " ORDER BY ci.Population DESC" +
                    " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, region);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/set_cities_in_region/Cities in " + region + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                World wld = new World();
                wld.region = rset.getString("Region");
                wld.cityName = rset.getString("Name");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities in " + region + ".");
            return null;

        }

    }

    /**
     * This method gets a set number of cities a specified country
     * 30
     *
     * @param country - User selected country
     * @param limit   - User set limit
     * @return an ArrayList of cities
     */
    public ArrayList<World> getSetNCityInCountryByPop(String country, int limit) {

        try {
            //Defines the prepared SQL statement
            String sql = " SELECT cnt.Name AS Country, cty.Name, cty.Population" +
                    " FROM city cty " +
                    " JOIN country cnt ON cnt.Code = cty.CountryCode" +
                    " WHERE cnt.Name = ? " +
                    " ORDER BY cty.Population DESC " +
                    " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);


            //Assign userInput to the first parameterIndex
            ps.setString(1, country);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Create a filepath
            String fileName = "csv/cities/set_n_cities_in_country_by_pop/Top " + limit + " cities in " + country + ".csv";

            //Creates an ArrayList of cities to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a city is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.countryName = rset.getString("Country");
                wld.cityName = rset.getString("Name");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get " + limit + " cities in " + country + ".");
            return null;
        }

    }

    /**
     * This method gets capital cities in the world, ordered by population
     * 31
     *
     * @param limit - User set limit
     * @return an ArrayList of capital cities in the world
     */
    public ArrayList<World> getSetNCapitalCitiesInWorld(int limit) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT cnt.Name AS Country, cty.Name AS City, ROUND(cty.Population) AS Population" +
                    " FROM country cnt" +
                    " JOIN city cty on cty.ID = cnt.Capital" +
                    " ORDER BY cnt.Population DESC" +
                    " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to the parameter index of
            //Assigns user input to parameterIndex
            ps.setInt(1, limit);

            //Executes SQL Statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/cities/capital_cities_by_pop_limit_world/Capital Cities in world.csv";

            //Create an ArrayList to store the data
            ArrayList<World> world = new ArrayList<>();

            //Check that a result is returned
            while (rset.next()) {
                World wld = new World();
                wld.cityName = rset.getString("City");
                wld.countryName = rset.getString("Country");
                wld.cityPopulation = rset.getInt("Population");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;
        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get info on capital cities.");
            return null;
        }
    }

    /**
     * This method gets the population of a country divided by the population in cities and in rural areas
     * 32
     *
     * @return an ArrayList of populations
     */
    public ArrayList<World> getCitiesAndRuralForCountry() {
        try {

            //Defines the prepared SQL Statement
            String sql = "SELECT cnt.Name, SUM(ci.Population) AS CityPopulation, SUM(cnt.Population) - SUM(ci.Population) as RuralPopulation" +
                    " From country cnt" +
                    " Inner Join city ci on cnt.code = ci.CountryCode" +
                    " Group By cnt.code";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/Cities and Rural Population in Country" + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                World wld = new World();
                wld.countryName = rset.getString("Name");
                wld.cityPopulation = rset.getLong("CityPopulation");
                wld.ruralPopulation = rset.getLong("RuralPopulation");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of Peoples in Cities and Rurally in Countries");
            return null;
        }
    }

    /**
     * This method gets a specified list of cities in a continent ordered by population
     * 33
     *
     * @param continent - User selected continent
     * @param limit     - User set limit
     * @return an ArrayList of Cities
     */
    public ArrayList<World> setNGetCitiesInContinentByPop(String continent, int limit) {

        try {

            //Defines the prepared SQL statement
            String sql = " SELECT c.Continent, cty.Name" +
                    " FROM city cty" +
                    " INNER JOIN country c ON c.code = cty.CountryCode" +
                    " WHERE c.Continent = ?" +
                    " ORDER BY cty.Population DESC" +
                    " LIMIT ?";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            //Assigns user input to parameterIndex
            ps.setString(1, continent);
            ps.setInt(2, limit);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path to
            String fileName = "csv/cities/set_cities_in_continent/" + "Cities in " + continent + ".csv";

            //Creates an empty ArrayList of cities for printing
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                World wld = new World();
                wld.continent = rset.getString("Name");
                wld.cityName = rset.getString("Name");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get" + limit + " cities in " + continent + ".");
            return null;


        }
    }

    /**
     * This method gets the population of a continent divided by the population in cities and in rural areas
     * 34
     *
     * @return an ArrayList of populations
     */
    public ArrayList<World> getCitiesAndRuralForContinent() {
        try {

            //Defines the prepared SQL Statement
            String sql = "SELECT c.Continent, SUM(ci.Population) AS CityPopulation, SUM(c.Population) - SUM(ci.Population) as RuralPopulation" +
                    " From country c" +
                    " Inner Join city ci on c.code = ci.CountryCode" +
                    " Group By c.Continent";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect( null).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/Cities and Rural Population in Country" + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                World wld = new World();
                wld.continent = rset.getString("Continent");
                wld.cityPopulation = rset.getLong("CityPopulation");
                wld.ruralPopulation = rset.getLong("RuralPopulation");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of Peoples in Cities and Rurally in Continent");
            return null;
        }
    }

    /**
     * This method gets a the population of People in Cities and not in each Region
     * 35
     *
     * @return an ArrayList of countries
     */
    public ArrayList<World> getCitiesAndRuralForRegion() {
        try {

            //Defines the prepared SQL Statement
            String sql = "SELECT c.Region, SUM(ci.Population) AS CityPopulation, SUM(c.Population) - SUM(ci.Population) as RuralPopulation" +
                    " From country c" +
                    " Inner Join city ci on c.code = ci.CountryCode" +
                    " Group By c.region";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/Cities and Rural Population in Region" + ".csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check one is returned
            while (rset.next()) {
                World wld = new World();
                wld.region = rset.getString("Region");
                wld.cityPopulation = rset.getLong("CityPopulation");
                wld.ruralPopulation = rset.getLong("RuralPopulation");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of Peoples in Cities and Rurally in Regions");
            return null;
        }
    }

    /**
     * This method gets a Country report
     * 36
     *
     * @return an ArrayList of countries
     */
    public ArrayList<World> getCountryReport() {

        try {
            //Defines the prepared SQL statement to
            String sql = " SELECT c.Name, c.Code, c.Continent, c.Region, c.Population, ci.Name AS 'City Name'" +
                    " FROM country c" +
                    " JOIN city ci ON ci.ID = c.Capital";

            //Sets up the prepared statement
            PreparedStatement ps = db.connect(null).prepareStatement(sql);

            // Execute SQL statement
            ResultSet rset = ps.executeQuery();

            //Sets the filename for the CSV file and creates a path
            String fileName = "csv/countries/country_report/Countries in the World.csv";

            //Creates an ArrayList of countries to store data
            ArrayList<World> world = new ArrayList<>();

            // Check that a county is returned and add the data to the ArrayList
            while (rset.next()) {
                World wld = new World();
                wld.countryName = rset.getString("Name");
                wld.countryCode = rset.getString("Code");
                wld.continent = rset.getString("Continent");
                wld.region = rset.getString("Region");
                wld.countryPopulation = rset.getInt("Population");
                wld.cityName = rset.getString("City Name");
                world.add(wld);
            }

            ResultSet ruset = ps.executeQuery();
            CSVCreator.createCSV(fileName, ruset);
            while (ruset.next()) {
                CSVCreator.createCSV(fileName, ruset);
            }

            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get the reports for countries.");
            return null;
        }


    }

}
