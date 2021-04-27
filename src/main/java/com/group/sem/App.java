package com.group.sem;

import java.sql.Connection;
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
     * The following code creates a singleton instance of the App Class to be used throughout the program
     */

    //Private Constructor
    private static App INSTANCE;

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

        //Sets database location
        String databaseLocation = "34.105.185.101:3306";

        //Get singleton instance of Database Connection
        DatabaseConnection db = DatabaseConnection.getInstance();

        // Connect to the database
        db.connect(databaseLocation);

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

        if (start.equals("Yes") | start.equals("yes") | start.equals("y")) {

            //Get singleton instance of App
            App a = App.getInstance();

            //Get singleton instance of Database Connection
            DatabaseConnection db = DatabaseConnection.getInstance();

            System.out.println("Please select of the options:\n\n " +
                    "1 - Get all countries by population\n " +
                    "2 - Get all countries in a specific continent\n" +
                    "3 - Get all countries in a specific region\n" +
                    "4 - Get all cities in a specific country\n" +
                    "5 - Get all cities ordered by population\n" +
                    "6 - Get all cities in a specific District\n" +
                    "7 - Get all cities in a specific continent\n" +
                    "8 - Get all cities in a region\n" +
                    "9 - Get the population in a district\n" +
                    "10 - Get the capital cities in a specified continent\n" +
                    "11 - Get the capital cities in a specified region\n" +
                    "12 - Get the population of the world\n" +
                    "13 - Get the population in a country\n" +
                    "14 - Get the population in a city\n" +
                    "15 - Get information on a specified city \n" +
                    "16 - Get a set number countries in a specific region\n" +
                    "17 - Get the population in a region\n" +
                    "18 - Get the population in a continent\n" +
                    "19 - Get the countries in a specific region, ordered by population.\n" +
                    "20 - Get a specified number of capital cities in a specific region\n" +
                    "21 - Get the number and percentage of speakers of a selected language\n" +
                    "22 - Get a specified number capital cities in a continent\n" +
                    "23 - Get a specified number of Populated Cities in a Continent\n" +
                    "24 - Continent Population Report\n" +
                    "25 - Region Population Report\n" +
                    "26 - Country Population Report\n" +
                    "27 - Get a specified number of cities in a specific District\n" +
                    "28 - Get a specified number of cities in a specific region\n" +
                    "29 - Get a specified number of cities in the world\n" +
                    "30 - Get a specified number of populated cities in a specific country\n" +
                    "31 - Get a specified number of capital cities in the world\n" +
                    "32 - Population of People in Cities and rural areas in a country\n" +
                    "33 - Get a specified number of cities in a specified Continent\n" +
                    "34 - Population of People in Cities and rural areas in a Continent\n" +
                    "35 - Population of People in Cities and rural areas in a Region\n" +
                    "36 - Gets a report for all the countries in the world."
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
                appPath("Yes");
            }

            // App Disconnects from database
            db.disconnect();

            //Says goodbye
            System.out.println("\n\n\n Goodbye!");

            //Exits the app
            System.exit(0);
        }
    }


    /**
     * @param userInput - The users query option from appPath()
     */
    public static void options(String userInput) {

        //Get Singleton instance of App
        App a = App.getInstance();

        //Get singleton instance of Country
        Country c = Country.getInstance();

        //Get singleton instance of City
        City cc = City.getInstance();

        //Gets singleton instance of language
        Language l = Language.getInstance();

        //Gets singleton instance of World
        World wld = World.getInstance();

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
                System.out.println("\n\nWhich continent would you like to see the countries of?\n\n");
                System.out.println("\n\nPlease make your selection:");
                String continentOption = in.nextLine();
                System.out.println("Retrieving data on " + continentOption + "...");


                ArrayList<Country> countries = c.getCountryInContinentByPop(continentOption);

                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }
            case "3": {

                //Gets all countries in a selected region ordered by population largest to smallest
                System.out.println("\n\nWhich region would you like to see the countries of?\n\n");
                System.out.println("\n\nPlease make your selection:");
                String regionOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");
                ArrayList<Country> countries = c.getCountryInRegionByPop(regionOption);


                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }
            case "4": {
                //Gets all cities in a selected country ordered by population largest to smallest
                System.out.println("\n\nWhich country would you like to see the cities of?\n\n");


                System.out.println("\n\nPlease make your selection:");
                String countryOption = in.nextLine();
                System.out.println("Retrieving data on " + countryOption + "...");


                ArrayList<World> world = wld.getCitiesInCountryByPop(countryOption);

                //Displays list of selected query
                a.displayWorld(world, userInput);

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
                System.out.println("Which district would you like to see the cities of?\n\n");
                System.out.println("Please make your selection:\n\n");
                String districtOption = in.nextLine();
                System.out.println("Retrieving data on " + districtOption + "...");

                ArrayList<City> cities = cc.getCitiesInDistrictByPop(districtOption);

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }
            case "7": {

                //Gets all cities in a continent, ordered by largest population to smallest
                System.out.println("Which continent would you like to see the cities of?\n\n");
                System.out.println("Please make your selection:");
                String continentOption = in.nextLine();
                System.out.println("Retrieving data on " + continentOption + "...");

                ArrayList<World> world = wld.getCitiesInCont(continentOption);

                a.displayWorld(world, userInput);

                break;
            }
            case "8": {
                //Get all cities in a region ordered by population largest to smallest
                System.out.println("Which region would you like to see the cities of\n\n");
                System.out.println("Please make your selection:\n");
                String regionOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");

                ArrayList<World> world = wld.getCitiesInRegion(regionOption);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }
            case "9": {
                //Gets district by population
                System.out.println("Which district would you like to see the population of?");
                System.out.println("Please make your selection:\n");
                String districtOption = in.nextLine();
                System.out.println("Retrieving data on " + districtOption + "...");

                ArrayList<City> cities = cc.getDistrictByPop();

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }
            case "10": {
                //Get all capital cities in a continent ordered by largest population to smallest
                System.out.println("Which continent would you like to see the capital cities of?\n\n");
                System.out.println("Please make your selection:\n");
                String continentOption = in.nextLine();
                System.out.println("Retrieving data on " + continentOption + "...");


                ArrayList<World> world = wld.getCapitalCitiesInContinentByPoP(continentOption);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }
            case "11": {

                //Get all capital cities in a region ordered by largest population to smallest
                System.out.println("Which region would you like to see the capital cities of?\n\n");
                System.out.println("Please make your selection:");
                String regionOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");

                ArrayList<World> world = wld.getCapitalCitiesInRegionByPoP(regionOption);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "12": {
                //Gets population of the world
                ArrayList<Country> countries = c.getWorldPopulation();
                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }
            case "13": {
                //Gets the population of a selected country
                System.out.println("\n\nWhich country would you like the see the population of?\n\n");
                System.out.println("\n\nPlease make your selection:");
                String userCountry = in.nextLine();
                System.out.println("Retrieving data on " + userCountry + "...");
                ArrayList<Country> countries = c.getCountryPopulation(userCountry);

                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }
            case "14": {
                //Gets district by population
                System.out.println("Which city would you like to see the population of?");
                System.out.println("Please make your selection:\n");
                String userCity = in.nextLine();
                System.out.println("Retrieving data on " + userCity + "...");

                ArrayList<City> cities = cc.getCitiesPopulation(userCity);
                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }

            case "15": {
                //Get information on a specified city
                System.out.println("Which city would you like to know about?\n\n");
                System.out.println("Please make your city selection:");
                String cityOption = in.nextLine();
                System.out.println("Which country is your city in?");
                String countryOption = in.nextLine();
                System.out.println("Retrieving data on " + cityOption + "...");
                ArrayList<World> world = wld.getCityInfo(cityOption, countryOption);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "16": {

                //Get all capital cities in a region ordered by largest population to smallest
                System.out.println("Which region would you like to see the countries cities of?\n\n");
                System.out.println("Please make your selection:");
                String regionOption = in.nextLine();
                System.out.println("How many rows would you like?:");
                String limitOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");

                ArrayList<Country> countries = c.getSetNCountryInRegionByPop(regionOption, limitOption);

                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }

            case "17": {

                //Gets population of a region
                System.out.println("\n\nWhich region would you like to see the population of\n\n");
                System.out.println("\n\nPlease make your selection:");
                String regionOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");
                ArrayList<Country> countries = c.getPopOfRegion(regionOption);


                //Displays list of selected query
                a.displayCountry(countries, userInput);

                break;
            }

            case "18": {

                //Gets population of a continent
                System.out.println("\n\nWhich continent would you like to see the population of\n\n");
                System.out.println("\n\nPlease make your selection:");
                String continentOption = in.nextLine();
                System.out.println("Retrieving data on " + continentOption + "...");
                ArrayList<Country> countries = c.getPopOfContinent(continentOption);

                a.displayCountry(countries, userInput);

                break;
            }

            case "19": {
                //Gets the countries in a specific region, ordered by population.
                System.out.println("\n\nWhich region would you like to see the countries of?");
                System.out.println("\n\nPlease make your selection:");
                String regionOption = in.nextLine();
                System.out.println("Retrieving data on " + regionOption + "...");
                ArrayList<Country> countries = c.getCountriesInRegionByPop(regionOption);

                //Displays this to the user via the displayCountry method
                a.displayCountry(countries, userInput);
                break;
            }

            case "20": {
                //Gets a specific number of capital cities in a specific region
                System.out.println("\n\nWhich region would you like to see the capital cities of?");
                System.out.println("\n\nPlease make your selection:");
                String regionOption = in.nextLine();
                System.out.println("How many would you like to see?");
                String limitOption = in.nextLine();
                int num = Integer.parseInt(limitOption);
                System.out.println("Retrieving " + limitOption + " records on " + regionOption + "...");
                ArrayList<World> world = wld.getSetNCapitalCitiesInRegionByPop(regionOption, num);

                //Displays this to the user via the displayWorld method
                a.displayWorld(world, userInput);
                break;

            }

            case "21": {

                //Gets the number and percentage of speakers of a user specified language
                System.out.println("\n\nWhich language would you like to see the percentage and number of speakers?");
                System.out.println("\n\nPlease make your selection:");
                String languageOption = in.nextLine();
                System.out.println("Retrieving data on" + languageOption + "...");
                ArrayList<World> world = wld.getLanguagePercentage(languageOption);

                //Display this to the user via the displayWorld method
                a.displayWorld(world, userInput);
                break;
            }

            case "22": {
                //Get all capital cities in a region ordered by largest population to smallest
                System.out.println("Which continent would you like to see the capital cities of?\n\n");
                System.out.println("Please make your selection:");
                String continentOption = in.nextLine();
                System.out.println("How many rows would you like?:");
                String limitOption = in.nextLine();
                int num = Integer.parseInt(limitOption);
                System.out.println("Retrieving data on " + continentOption + "...");

                ArrayList<World> world = wld.getSetNCapitalCitiesInContByPop(continentOption, num);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "23": {
                //Get all capital cities in a region ordered by largest population to smallest
                System.out.println("Which continent would you like to see the cities of?\n\n");
                System.out.println("Please make your selection:");
                String continentOption = in.nextLine();
                System.out.println("How many rows would you like?:");
                String limitOption = in.nextLine();
                System.out.println("Retrieving data on " + continentOption + "...");

                ArrayList<World> world = wld.getSetNCitiesInContByPop(continentOption, limitOption);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "24": {
                //Gets the continent population report
                System.out.println("\n\nWhich continent would you like a population report of?\n\n");
                System.out.println("\n\nPlease make your selection:");
                String userContinent = in.nextLine();
                System.out.println("Retrieving data on " + userContinent + "...");
                ArrayList<World> world = wld.getContinentPopReport(userContinent);

                //Displays list of selected query
                a.displayWorld(world, userInput);

                break;
            }

            case "25": {
                //Gets the region population report
                System.out.println("\n\nWhich region would you like a population report of?\n\n");
                System.out.println("\n\nPlease make your selection:");
                String userRegion = in.nextLine();
                System.out.println("Retrieving data on " + userRegion + "...");
                ArrayList<World> world = wld.getRegionPopReport(userRegion);

                //Displays list of selected query
                a.displayWorld(world, userInput);

                break;
            }

            case "26": {
                //Gets the country population report
                System.out.println("\n\nWhich country would you like a population report of?\n\n");
                System.out.println("\n\nPlease make your selection:");
                String userCountry = in.nextLine();
                System.out.println("Retrieving data on " + userCountry + "...");
                ArrayList<World> world = wld.getCountryPopReport(userCountry);

                //Displays list of selected query
                a.displayWorld(world, userInput);

                break;
            }

            case "27": {
                //Gets a specified number cities in a district ordered by population largest to smallest
                System.out.println("Which district would you like to see the cities of?\n\n");
                System.out.println("Please make your selection:\n\n");
                String districtOption = in.nextLine();
                System.out.println("How many rows would you like?:");
                String limitOption = in.nextLine();
                int num = Integer.parseInt(limitOption);
                System.out.println("Retrieving data on " + districtOption + "...");

                ArrayList<City> cities = cc.setNGetCitiesInDistrictByPop(districtOption, num);

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }

            case "28": {
                //Gets a specified number cities in a region ordered by population largest to smallest
                System.out.println("Which region would you like to see the cities of?\n\n");
                System.out.println("Please make your selection:\n\n");
                String regionOption = in.nextLine();
                System.out.println("How many rows would you like?:");
                String limitOption = in.nextLine();
                int num = Integer.parseInt(limitOption);
                System.out.println("Retrieving data on " + regionOption + "...");

                ArrayList<World> world = wld.setNGetCitiesInRegionByPop(regionOption, num);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "29": {
                //Get a specified number of cities in the world ordered by largest population to smallest
                System.out.println("How many cities would you like to see?");
                String limitOption = in.nextLine();
                System.out.println("Retrieving data on " + limitOption + " cities...");

                ArrayList<City> cities = cc.getSetNCityInWorldByPop(limitOption);

                //Displays list of selected query
                a.displayCity(cities, userInput);
                break;
            }

            case "30": {
                //Gets the specified number of cities in a specified country, ordered by largest population to the smallest
                System.out.println("Which country would you like to see the cities of?\n\n");
                System.out.println("Please make your selection\n\n");
                String countryOption = in.nextLine();
                System.out.print("How many cities would you like to see?\n\n");
                String limitOption = in.nextLine();

                ArrayList<World> world = wld.getSetNCityInCountryByPop(countryOption, limitOption);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }


            case "31": {
                //Gets a specific number of capital cities in the world
                System.out.println("How many capital cities would you like to see?");
                String limitOption = in.nextLine();
                int num = Integer.parseInt(limitOption);
                System.out.println("Retrieving " + limitOption + " records on the world...");
                ArrayList<World> world = wld.getSetNCapitalCitiesInWorld(num);

                //Displays this to the user via the displayWorld method
                a.displayWorld(world, userInput);
                break;
            }

            case "32": {
                //Gets the population of people that live in cities and rurally in each country
                ArrayList<World> world = wld.getCitiesAndRuralForCountry();

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "33": {
                //Gets a specified number cities in a continent ordered by population largest to smallest
                System.out.println("Which continent would you like to see the cities of?\n\n");
                System.out.println("Please make your selection:\n\n");
                String continentOption = in.nextLine();
                System.out.println("How many rows would you like?:");
                String limitOption = in.nextLine();
                int num = Integer.parseInt(limitOption);
                System.out.println("Retrieving data on " + continentOption + "...");

                ArrayList<World> world = wld.setNGetCitiesInContinentByPop(continentOption, num);

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "34": {
                //Gets the population of people that live in cities and rurally in each continent
                ArrayList<World> world = wld.getCitiesAndRuralForContinent();

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;
            }

            case "35": {
                //Gets the population of people that live in cities and rurally in each country
                ArrayList<World> world = wld.getCitiesAndRuralForRegion();

                //Displays list of selected query
                a.displayWorld(world, userInput);
                break;

            }

            case "36": {
                //Assigns results from query to the ArrayList
                ArrayList<World> world = wld.getCountryReport();

                //Displays list of selected query
                a.displayWorld(world, userInput);
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
            if (userInput.equals("1") || userInput.equals("13")) {
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

            //Displays countries in region and set number countries in a specified region
            else if (userInput.equals("3")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "Region", "Country\n");

                if (countries != null) {
                    for (Country country : countries) {
                        String output = String.format("%-20s %-15s", country.Region, country.Name);
                        System.out.println(output);

                    }
                }
            }

            //Displays countries in a continent and displays population of a region and displays the countries in a specified region by population
            else if (userInput.equals("12") || userInput.equals("17") || userInput.equals("18")) {

                //Prints Column Header
                System.out.printf("%-20s", "Population\n");

                //Loops over all the countries in the database
                if (countries != null) {
                    for (Country country : countries) {
                        String output = String.format("%-20s", country.Population);
                        System.out.println(output);
                    }
                }

            }

            //Displays countries in region and set number countries in a specified region
            else if (userInput.equals("16") || userInput.equals("19")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %15s", "Region", "Country", "Population\n");

                if (countries != null) {
                    for (Country country : countries) {
                        String output = String.format("%-20s %-15s %15s", country.Region, country.Name, country.Population);
                        System.out.println(output);

                    }
                }
            }

        } catch (Exception e) {
            if (userInput == null && countries == null) {
                System.out.println("No Cities");
            }
        }
    }

    /**
     * @param cities
     * @param userInput
     */
    public void displayCity(ArrayList<City> cities, String userInput) {

        try {
            /*
            Displays all cities by population and gets capital cities in a specified continent and
            gets capital cities in a specified region and gets the population of a specified city and
            displays a specified number of cities in a specified country
             */
            if (userInput.equals("5") || userInput.equals("14") || userInput.equals("29")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "City", "Population\n");

                if (cities != null) {

                    for (City city : cities) {
                        String output = String.format("%-45s %-15s", city.cityName, city.cityPopulation);
                        System.out.println(output);
                    }
                }

            }

            //Displays cities in a district and a displays a specified number of cities in a district
            else if (userInput.equals("6") || userInput.equals("27")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "District", "City\n");

                if (cities != null) {

                    for (City city : cities) {
                        String output = String.format("%-45s %-15s", city.cityDistrict, city.cityName);
                        System.out.println(output);
                    }
                }
            }

            //Gets population in a specified district
            else if (userInput.equals("9")) {

                System.out.printf("%-20s %-15s", "District", "Population\n");

                if (cities != null) {

                    for (City city : cities) {
                        String output = String.format("%-25s %-15s", city.cityDistrict, city.cityPopulation);
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

    /**
     * @param worldData
     * @param userInput
     */
    public void displayWorld(ArrayList<World> worldData, String userInput) {

        try {
            //Gets capital cities in a specified region
            if (userInput.equals("4")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %15s", "Region", "Country", "Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %15s", result.region, result.countryName, result.countryPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Gets a specified number of capital cities in a region
            else if (userInput.equals("7")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "Continent", "Country\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-25s %-15s", result.continent, result.countryName);
                        System.out.println(output);
                    }
                }

            }

            //Gets a specified number of capital cities in a region
            else if (userInput.equals("8") || userInput.equals("28")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "Region", "Country\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-25s %-15s", result.region, result.countryName);
                        System.out.println(output);
                    }
                }

            }

            //Displays continent report
            else if (userInput.equals("10") || userInput.equals("22") || userInput.equals("23")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s", "Continent", "City", "Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s", result.continent, result.cityName, result.cityPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Displays continent report
            else if (userInput.equals("11") || userInput.equals("20")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s", "Region", "City", "Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s", result.region, result.cityName, result.cityPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Displays country report
            else if (userInput.equals("15")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s %-15s", "City", "Country", "District", "Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s %-15s", result.cityName, result.countryName, result.cityDistrict, result.cityPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Displays country report
            else if (userInput.equals("21")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s", "Language", "Population", "Percentage\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s", result.language, result.countryPopulation, result.languagePercentage);
                        System.out.println(output);
                    }
                }
            }

            //Displays country report
            else if (userInput.equals("24")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s %-15s", "Continent", "Population", "City Percentage", "Rural Percentage\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s %-15s", result.continent, result.continentPopulation, result.cityPercentage, result.ruralPercentage);
                        System.out.println(output);
                    }
                }
            }

            //Displays country report
            else if (userInput.equals("25")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s %-15s", "Region", "Population", "City Percentage", "Rural Percentage\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s %-15s", result.region, result.regionPopulation, result.cityPercentage, result.ruralPercentage);
                        System.out.println(output);
                    }
                }
            }

            //Displays country population report
            else if (userInput.equals("26")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s %-15s", "Country", "Population", "City Percentage", "Rural Percentage\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s %-15s", result.countryName, result.countryPopulation, result.cityPercentage, result.ruralPercentage);
                        System.out.println(output);
                    }
                }
            }

            //Displays a set number of cities a specified country and Gets a specified number of capital cities in the world
            else if (userInput.equals("30") || userInput.equals("31")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s %-15s", "Country", "City", "Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-20s %-15s %-15s", result.countryName, result.cityName, result.cityPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Gets a specified number of capital cities in a region
            else if (userInput.equals("33")) {

                //Prints Column Header
                System.out.printf("%-20s %-15s", "Continent", "City\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-25s %-15s", result.continent, result.cityName);
                        System.out.println(output);
                    }
                }

            }

            //Displays population of people living in cities and not in each country
            else if (userInput.equals("32")) {

                System.out.printf("%-20s %-15s %-15s", "Country Name", "City Population", "Rural Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-25s %-15s %-15s", result.countryName, result.cityPopulation, result.ruralPopulation);
                        System.out.println(output);
                    }
                }

            }

            //Displays the population of a continent divided by the population in cities and in rural areas
            else if (userInput.equals("34")) {

                System.out.printf("%-20s %-15s %-15s", "Continent Name", "City Population", "Rural Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-25s %-15s %-15s", result.continent, result.cityPopulation, result.ruralPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Displays the population of People in Cities and not in each Region
            else if (userInput.equals("35")) {

                System.out.printf("%-20s %-15s %-15s", "Region Name", "City Population", "Rural Population\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-25s %-15s %-15s", result.region, result.cityPopulation, result.ruralPopulation);
                        System.out.println(output);
                    }
                }
            }

            //Displays a Country report
            else if (userInput.equals("36")) {

                System.out.printf("%-20s %-15s %-15s %-15s %-15s %-15s", "Country", "Code", "Continent", "Region", "Population", "City Name\n");

                if (worldData != null) {
                    for (World result : worldData) {
                        String output = String.format("%-25s %-15s %-15s %-15s %-15s %-15s", result.countryName, result.countryCode, result.continent, result.region, result.countryPopulation, result.cityName);
                        System.out.println(output);
                    }
                }
            }

        } catch (Exception e) {
            if (userInput == null && worldData == null) {
                System.out.println("No Data");
            }
        }

    }

}