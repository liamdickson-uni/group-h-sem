package com.group.sem;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class World {

        /**
         *  The following code creates a singleton instance of the World Class to be used throughout the program
         */

        //Private constructor
        private static World INSTANCE;

        //Empty Constructor
        World(){
        }

        //Static factory method for obtaining the instance
        public static World getInstance(){
            if (INSTANCE == null) {
                INSTANCE = new World();
            }
            return INSTANCE;
        }


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
    public int cityPopulation;

    /*
    * Represents a countries region
     */
    public String region;

    /*
    Represents country population
     */
    public int countryPopulation;
    /*
   Represents country population
    */
    public int ruralPopulation;

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
     * This method gets a set number of countries in a specified region
     *
     * @return an ArrayList of countries
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
            PreparedStatement ps = db.connect(true).prepareStatement(sql);


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
                CSVCreator.createCSV(fileName, rset);
                languages.add(wld);
            }

            return languages;

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get data on selected language.");
            return null;
        }
    }

    /**
     * This method gets a continent population report
     *
     * @return an ArrayList of countries
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
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1,continent);
            ps.setString(2,continent);
            ps.setString(3,continent);
            ps.setString(4,continent);
            ps.setString(5,continent);

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
                CSVCreator.createCSV(fileName, rset);
                world.add(wld);
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
     *
     * @return an ArrayList of countries
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
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1,region);
            ps.setString(2,region);
            ps.setString(3,region);
            ps.setString(4,region);
            ps.setString(5,region);

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
                CSVCreator.createCSV(fileName, rset);
                world.add(wld);
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
     *
     * @return an ArrayList of countries
     */
    public ArrayList<World> getCountryPopReport(String country) {

        try {
            //Defines the prepared SQL statement
            String sql = "SELECT Name," +
                    " (SELECT SUM(Population) FROM country c WHERE c.Region IN (?)) as CountryPopulation, " +
                    " (SUM(ci.Population) / (SELECT SUM(Population) FROM country c WHERE c.Country IN (?)) * 100) AS CityPercentage," +
                    " ((((SELECT SUM(Population) FROM country c WHERE c.Country IN (?)) - SUM(ci.Population)) / (SELECT SUM(Population) FROM country c WHERE c.Country IN (?))) * 100) AS RuralPercentage" +
                    " FROM city ci " +
                    " INNER JOIN country c on ci.CountryCode = c.Code" +
                    " WHERE c.Country IN (?)";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

            //Assign userInput to the first parameterIndex
            ps.setString(1,country);
            ps.setString(2,country);
            ps.setString(3,country);
            ps.setString(4,country);
            ps.setString(5,country);

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
                CSVCreator.createCSV(fileName, rset);
                world.add(wld);
            }
            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country report");
            return null;
        }
    }
    public ArrayList<World> getCitiesAndRuralForCountry() {
        try {

            //Defines the prepared SQL Statement
            String sql = "SELECT cnt.Name, SUM(ci.Population) AS CityPopulation, SUM(cnt.Population) - SUM(ci.Population) as RuralPopulation"+
                    "From country cnt"+
                    "Inner Join city ci on cnt.code = ci.CountryCode"+
                    "Group By cnt.code";


            //Sets up the prepared statement
            PreparedStatement ps = db.connect(true).prepareStatement(sql);

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
                wld.cityPopulation = rset.getInt("City Population");
                wld.ruralPopulation = rset.getInt("Rural Population");
                CSVCreator.createCSV(fileName, rset);
                world.add(wld);
            }
            return world;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of Peoples in Cities and Rurally in Countries");
            return null;
        }
    }

}
