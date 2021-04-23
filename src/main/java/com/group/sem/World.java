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
    Represents the percentage who speak a language
     */

    public float languagePercentage;

    /*
    Represents the Languages spoken in the world
     */

    public String language;


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



}
