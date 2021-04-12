package com.group.sem;


import org.junit.jupiter.api.*;
import java.util.ArrayList;


public class AppIntegrationTest {

    static App app;


    /**
     * Connects to the database before running the Integration Tests
     */
    @BeforeAll
    static void init() {
        app = App.getInstance();
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect(false);
    }


    /**
     * Tests that getCountryByPopDesc() method produces a report
     */
  
    @Test
    void getCountryByPopDescInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getCountryByPopDesc();
        app.displayCountry(countries, "1");
        String output = "Test input 1 -- passed\n\n\n";
        System.out.println(output);
    }


    /**
     * Tests that get countryInContinentByPop() method produces a report
     */
    @Test
    void getCountryInContinentByPopInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getCountryInContinentByPop("Europe");
        app.displayCountry(countries, "2");
        String output = "Test input 2 -- passed\n\n\n";
        System.out.println(output);
    }


    /**
     * Tests that getCountryInRegionByPop() method produces a report
     */
    @Test
    void getCountryInRegionByPopInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getCountryInRegionByPop("North America");
        app.displayCountry(countries, "3");
        String output = "Test input 3 -- passed \n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesInCountryByPop() method produces a report
     */
    @Test
    void getCitiesInCountryByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCitiesInCountryByPop("United Kingdom");
        app.displayCity(cities, "4");
        String output = "Test input 4 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesByPop() method produces a report
     */
    @Test
    void getCitiesByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCitiesByPop();
        app.displayCity(cities, "5");
        String output = "Test input 5 -- passed \n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesInDistrictByPop() method produces a report
     */
    @Test
    void getCitiesInDistrictByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCitiesInDistrictByPop("Arizona");
        app.displayCity(cities, "6");
        String output = "Test input 6 -- passed\n\n\n";
        System.out.println(output);
    }


    /**
     * Tests that getCitiesInCont() method produces a report
     */
    @Test
    void getCitiesInContInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCitiesInCont("Europe");
        app.displayCity(cities, "7");
        String output = "Test input 7 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesInRegion() method produces a report
     */
    @Test
    void getCitiesInRegionInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCitiesInRegion("Western Europe");
        app.displayCity(cities, "8");
        String output = "Test input 8 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getDistrictByPop() method produces a report
     */
    @Test
    void getDistrictByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getDistrictByPop();
        app.displayCity(cities, "9");
        String output = "Test input 9 - passed \n\n\n";
        System.out.println(output);
    }


    /**
     * Tests that getCapitalCitiesInContinentByPop() method produces a report
     */
    @Test
    void getCapitalCitiesInContinentByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCapitalCitiesInContinentByPoP("Asia");
        app.displayCity(cities, "10");
        String output = "Test input 10 -- passed\n\n\n";
        System.out.println(output);
    }


    /**
     * Tests that getCapitalCitiesInRegionByPop() method produces a report
     */
    @Test
    void getCapitalCitiesInRegionByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCapitalCitiesInRegionByPoP("Middle East");
        app.displayCity(cities, "11");
        String output = "Test input 11 -- passed\n\n\n";
        System.out.println(output);
    }


    /**
     * Tests that the database can be disconnected from after all other tests have run
     */
    @AfterAll
    public static void disconnectTest() {
        try {
            DatabaseConnection db = DatabaseConnection.getInstance();
            db.disconnect();
        } catch (Exception e) {
            System.out.println("Error closing connection to database");
        }
    }


}
