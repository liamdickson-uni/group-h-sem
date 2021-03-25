package com.group.sem;

import java.sql.*;
import java.util.*;


/**
 * Wildcat Bikes -- Global Market Information
 * Group H -- SET08103
 *
 * @author Tom McEachan (40356376), Liam Dickson (40456372), Greig Dunbar (40430731), Jack Burton (40456783)
 * <p>
 * App.java is the main class of this program and contains the main() method. This also contains all of the methods
 * to display data for the end-user. It does this by querying the world.sql database, puts the data in a specified
 * ArrayList which is printed to the console for the user to see. Methods in this class include:
 * <p>
 * main()
 * connect() -- This connects to the database created by the world.sql file in Docker
 * disconnect() -- Stops the connection to the database
 * displayCountry() -- This is used to display all lists created by the methods in the Country.java class
 * displayCity() -- This is used to display all lists created by the methods in the City.java class
 */

public class App {

    /**
     *  The following code creates a singleton instance of the App Class to be used throughout the program
     */

    //Private Constructor
    private static App INSTANCE;

    //Empty Constructor
    private App() {

    }

    //Static factory method for obtaining the instance
    public static App getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new App();
        }
         return INSTANCE;
    }




    /**
     * @param args
     */
    public static void main(String[] args) {
        //Access instance of App Class
        App a = App.getInstance();

        //Creates new Scanner for user Input
        Scanner in = new Scanner(System.in);

        //Print out welcome message
        System.out.println("\n\n\nWelcome to Wildcat Bikes Global Information App.\n\n");

        //Asks the user if they would like to start the program and passes their answer to the appPath() method
        System.out.println("Would you like to start?   Yes/No\n\n");
        String startInput = in.nextLine();

        //Runs the appPath() method
        a.appPath(startInput);

    }


    /**
     * This method runs the app in a loop until the user wants to exit
     */
    public void appPath(String start) {

        if(start.equals("Yes")) {

            //Get singleton instance of App
            App a = App.getInstance();

            //Get singleton instance of Database Connection
            DatabaseConnection db = DatabaseConnection.getInstance();

            // Connect to the database
            db.connect(false);

            System.out.println("Please select of the options:\n\n " +
                    "1 - Get all counties by population\n " +
                    "2 - Get all countries in a specific continent\n" +
                    "3 - Get all countries in a specific region\n" +
                    "4 - Get all cities in a specific country\n" +
                    "5 - Get all cities ordered by population\n" +
                    "6 - Get all cities in a specific District\n" +
                    "7 - Get all cities in a specific continent\n" +
                    "8 - Get all cities in a region\n" +
                    "9 - Get the population in a district\n" +
                    "10 - Get the capital cities in a specified continent\n" +
                    "11 - Get the capital cities in a specified region\n"
            );

            //Creates new Scanner for user input
            Scanner in = new Scanner(System.in);

            //Asks the user to select an option
            System.out.println("Select your option:");

            //User inputs their option
            String userInput = in.nextLine();

            //Tells the user what they have selected and that their query results are on the way
            System.out.println("You have selected " + userInput + " as your option.\n Your results are:\n");

            //Passes the users option to the options() method which runs the specified query
            options(userInput);


            //Asks the user if they would like to make another query
            System.out.println("Would you like to make another query?    Yes/No");

            //User says 'yes' or 'no'
            String restartOption = in.nextLine();

            //Program will loop until user selects 'no'
            while (restartOption.equals("Yes")) {
                appPath(restartOption);
            }

            // App Disconnects from database
            db.disconnect();

            //Exits the app
            System.exit(0);
        }
    }


    /**
     *
     * @param userInput - The users query option from appPath()
     */
    public static void options(String userInput) {

        //Get Singleton instance of App
        App a = App.getInstance();

        //Get singleton instance of Country
        Country c = Country.getInstance();

        //Get singleton instance of City
        City cc = City.getInstance();

        //Create new Language
        Language l = Language.getInstance();

        //Creates new Scanner for user Input
        Scanner in = new Scanner(System.in);


        /*
         * This switch statement takes the users input and carries out the query they specified
         */
        switch (userInput) {
            case "1": {
                //Gets all countries ordered by population largest to smallest
                ArrayList<Country> countries = c.getCountryByPopDesc();

                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }
            case "2": {
                //Gets all countries by a selected continent ordered by population largest to smallest
                ArrayList<Country> countries = c.getCountryInContinentByPop();

                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }
            case "3": {

                //Get all capital cities in a region ordered by largest population to smallest
                System.out.println("\n\nWhich region would you like to see the capital cities of?\n\n");

                for (Country.RegionEnum region : EnumSet.allOf(Country.RegionEnum.class)) {
                    System.out.println(region);
                }

                System.out.println("\n\nPlease make your selection:");
                String regionOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");

                //Gets all countries in a selected region ordered by population largest to smallest
                ArrayList<Country> countries = c.getCountryInRegionByPop(regionOption);

                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }
            case "4": {
                //Gets all cities in a selected country ordered by population largest to smallest
                ArrayList<City> cities = cc.getCitiesInCountryByPop();

                //Displays list of selected query
                a.displayCity(cities, userInput);

                break;
            }
            case "5": {
                //Gets all cities ordered by population largest to smallest
                ArrayList<City> cities = cc.getCitiesByPop();

                //Displays list of selected query
                a.displayCity(cities, userInput);

                break;
            }
            case "6": {
                //Gets all cities in a district ordered by population largest to smallest
                ArrayList<City> cities = cc.getCitiesInDistrictByPop();

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }
            case "7": {

                ArrayList<City> cities = cc.getCitiesInCont();

                a.displayCity(cities, userInput);

                break;
            }
            case "8": {
                //Get all cities in a region ordered by population largest to smallest
                ArrayList<City> cities = cc.getCitiesInRegion();

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }
            case "9": {
                //Get all cities in a region ordered by population largest to smallest
                ArrayList<City> cities = cc.getDistrictByPop();

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }
            case "10": {
                //Get all capital cities in a continent ordered by largest population to smallest
                ArrayList<City> cities = cc.getCapitalCitiesInContinentByPoP();

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }
            case "11": {

                //Get all capital cities in a region ordered by largest population to smallest
                System.out.println("Which region would you like to see the capital cities of?\n\n");

                for (Country.RegionEnum region : EnumSet.allOf(Country.RegionEnum.class)) {
                    System.out.println(region);
                }

                System.out.println("Please make your selection:");
                String regionOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");

                ArrayList<City> cities = cc.getCapitalCitiesInRegionByPoP(regionOption);

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }
        }

    }


    /**
     * Prints a queried list of countries
     *
     * @param countries The list of countries
     * @param userInput The user input
     */
    public void displayCountry(ArrayList<Country> countries, String userInput) {

        try {
            //Displays countries by population
            if (userInput.equals("1")) {
                if (countries != null) {

                    //Prints Column Header
                    System.out.printf("%-45s %-15s", "Country", "Population\n");

                    //Loops over all the countries in the database
                    for (Country country : countries) {
                        String output = String.format("%-45s %-15s", country.Name, country.Population);
                        System.out.println(output);
                    }
                }
            }
            //Displays countries in a continent
            else if (userInput.equals("2")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "Continent", "Country\n");

                if (countries != null) {
                    for (Country country : countries) {
                        String output = String.format("%-20s %-15s", country.Continent, country.Name);
                        System.out.println(output);

                    }
                }
            }
            //Displays countries in region
            else if (userInput.equals("3")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s", "Region", "Country", "Population\n");

                if (countries != null) {
                    for (Country country : countries) {
                        String output = String.format("%-20s %-15s %-15s", country.Region, country.Name, country.Population);
                        System.out.println(output);

                    }
                }
            }

        } catch (Exception e) {
            if (userInput == null && countries == null) {
                System.out.println("No Countries");
            }
        }
    }


    /**
     * @param cities
     * @param userInput
     */
    public void displayCity(ArrayList<City> cities, String userInput) {
        try {
            //Displays cities in a country by population
            if (userInput.equals("4")) {

                //Prints Column Header
                System.out.println("City\n");

                if (cities != null) {

                    for (City city : cities) {
                        System.out.println(city.cityName);
                    }
                }

            }

            //Displays all cities by population
            else if (userInput.equals("5")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "City", "Population\n");

                if (cities != null) {

                    for (City city : cities) {
                        String output = String.format("%-45s %-15s", city.cityName, city.cityPopulation);
                        System.out.println(output);
                    }
                }

            }

            //Displays cities in a district
            else if (userInput.equals("6")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "District", "City\n");

                if (cities != null) {

                    for (City city : cities) {
                        String output = String.format("%-45s %-15s", city.cityDistrict, city.cityName);
                        System.out.println(output);
                    }
                }
            }

            //Displays cities in a specified continent
            else if (userInput.equals("7")) {

                System.out.println("City\n");

                if (cities != null) {

                    for (City city : cities) {
                        System.out.println(city.cityName);
                    }

                }
            }

            //Gets cities in a specified region
            else if (userInput.equals("8")) {

                System.out.println("City\n");

                if (cities != null) {

                    for (City city : cities) {
                        System.out.println(city.cityName);
                    }
                }
            }

            //Gets popultion in a specified district
            else if (userInput.equals("9")) {

                System.out.printf("%-20s %-15s", "District", "Population\n");

                if (cities != null) {

                    for (City city : cities) {
                        String output = String.format("%-25s %-15s", city.cityDistrict, city.cityPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Gets capital cities in a specified continent
            else if (userInput.equals("10")) {

                System.out.printf("%-20s %-15s", "City Name", "Population\n");

                if (cities != null){

                    for (City city : cities) {
                        String output = String.format("%-25s %-15s", city.cityName, city.cityPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Gets capital cities in a specified region
            else if (userInput.equals("11")) {

                System.out.printf("%-20s %-15s", "City Name", "Population\n");

                if (cities != null) {

                    for (City city : cities) {

                        String output = String.format("%-25s %-15s", city.cityName, city.cityPopulation);
                        System.out.println(output);
                    }
                }
            }

        } catch (Exception e) {
            if (userInput == null && cities == null) {
                System.out.println("No Cities");
            }
        }
    }




}