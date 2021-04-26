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
     * Tests that getWorldPopulation() method produces a report
     */
    @Test
    void getWorldPopulationTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getWorldPopulation();
        app.displayCountry(countries, "12");
        String output = "Test input 12 -- passed \n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCountryPopulation() method produces a report
     */
    @Test
    void getCountryPopulationInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getCountryPopulation("American Samoa");
        app.displayCountry(countries, "13");
        String output = "Test input 13 -- passed \n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesPopulation() method produces a report
     */
    @Test
    void getCitiesPopulationInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getCitiesPopulation("Texas");
        app.displayCity(cities, "14");
        String output = "Test input 14 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCityInfo() method produces a report
     */
    @Test
    void getCityInfoTest() {
        City cty = City.getInstance();
        ArrayList<World> worlds = cty.getCityInfo("Glasgow","Scotland");
        app.displayWorld(worlds, "15");
        String output = "Test input 15 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getSetNCountryInRegionByPop() method produces a report
     */
    @Test
    void getSetNCountryInRegionByPopTest() {
        Country cnt = Country.getInstance();
        ArrayList<Country> countries = cnt.getSetNCountryInRegionByPop("Eastern Africa","13");
        app.displayCountry(countries, "16");
        String output = "Test input 16 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getPopOfRegion() method produces a report
     */
    @Test
    void getCountryPopulationInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getPopOfRegion("American Samoa");
        app.displayCountry(countries, "17");
        String output = "Test input 17 -- passed \n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getPopOfContinent() method produces a report
     */
    @Test
    void getPopOfContinentInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getPopOfContinent("Europe");
        app.displayCountry(countries, "18");
        String output = "Test input 18 -- passed \n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCountriesInRegionByPop() method produces a report
     */
    @Test
    void getCountriesInRegionByPopInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getCountriesInRegionByPop("American Samoa");
        app.displayCountry(countries, "19");
        String output = "Test input 19 -- passed \n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getNumberOfCapitalCities() method produces a report
     */
    @Test
    void getNumberOfCapitalCitiesInputTest() {
        City cty = City.getInstance();
        ArrayList<World> worlds = cty.getNumberOfCapitalCities(5,"Eastern Europe");
        app.displayWorld(worlds, "20");
        String output = "Test input 20 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getLanguagePercentage() method produces a report
     */
    @Test
    void getLanguagePercentageInputTest() {
        World wld = World.getInstance();
        ArrayList<World> worlds = wld.getLanguagePercentage("Chinese");
        app.displayWorld(worlds, "21");
        String output = "Test input 21 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getSetNCapitalCitiesInContByPop() method produces a report
     */
    @Test
    void getCitiesPopulationInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getSetNCapitalCitiesInContByPop("Europe", 5);
        app.displayCity(cities, "22");
        String output = "Test input 22 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getSetNCapitalCitiesInContByPop() method produces a report
     */
    @Test
    void getSetNCitiesInContByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getSetNCitiesInContByPop("Europe", "5");
        app.displayCity(cities, "23");
        String output = "Test input 23 -- passed\n\n\n";
        System.out.println(output);
    }


    /**
     * Tests that getContinentPopReport() method produces a report
     */
    @Test
    void getContinentPopReportInputTest() {
        World wld = World.getInstance();
        ArrayList<World> worlds = wld.getContinentPopReport("Europe");
        app.displayWorld(worlds, "24");
        String output = "Test input 24 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getRegionPopReport() method produces a report
     */
    @Test
    void getRegionPopReportInputTest() {
        World wld = World.getInstance();
        ArrayList<World> worlds = wld.getRegionPopReport("American Samoa");
        app.displayWorld(worlds, "25");
        String output = "Test input 25 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCountryPopReport() method produces a report
     */
    @Test
    void getRegionPopReportInputTest() {
        World wld = World.getInstance();
        ArrayList<World> worlds = wld.getCountryPopReport("Scotland");
        app.displayWorld(worlds, "26");
        String output = "Test input 26 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that setNGetCitiesInDistrictByPop() method produces a report
     */
    @Test
    void setNGetCitiesInDistrictByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.setNGetCitiesInDistrictByPop("Noord-Holland", 5);
        app.displayCity(cities, "27");
        String output = "Test input 27 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that setNGetCitiesInRegionByPop() method produces a report
     */
    @Test
    void setNGetCitiesInRegionByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.setNGetCitiesInRegionByPop("American Samoa", 5);
        app.displayCity(cities, "28");
        String output = "Test input 28 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getSetNCityInWorldByPop() method produces a report
     */
    @Test
    void setNGetCitiesInRegionByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getSetNCityInWorldByPop( "5");
        app.displayCity(cities, "29");
        String output = "Test input 29 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getSetNCityInCountryByPop() method produces a report
     */
    @Test
    void getSetNCityInCountryByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.getSetNCityInCountryByPop( "5", "Scotland");
        app.displayCity(cities, "30");
        String output = "Test input 30 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getNumberOfCapitalCitiesWorld() method produces a report
     */
    @Test
    void getRegionPopReportInputTest() {
        City cty = City.getInstance();
        ArrayList<World> worlds = cty.getNumberOfCapitalCitiesWorld(5);
        app.displayWorld(worlds, "31");
        String output = "Test input 31 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesAndRuralForCountry() method produces a report
     */
    @Test
    void getCitiesAndRuralForCountry() {
        World wld = World.getInstance();
        ArrayList<World> worlds = wld.getCitiesAndRuralForCountry();
        app.displayWorld(worlds, "32");
        String output = "Test input 32 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that setNGetCitiesInContinentByPop() method produces a report
     */
    @Test
    void setNGetCitiesInContinentByPopInputTest() {
        City cty = City.getInstance();
        ArrayList<City> cities = cty.setNGetCitiesInContinentByPop( "Europe", 5);
        app.displayCity(cities, "33");
        String output = "Test input 33 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesAndRuralForContinent() method produces a report
     */
    @Test
    void getCitiesAndRuralForContinent() {
        World wld = World.getInstance();
        ArrayList<World> worlds = wld.getCitiesAndRuralForContinent();
        app.displayWorld(worlds, "34");
        String output = "Test input 34 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCitiesAndRuralForRegion() method produces a report
     */
    @Test
    void getCitiesAndRuralForRegion() {
        World wld = World.getInstance();
        ArrayList<World> worlds = wld.getCitiesAndRuralForRegion();
        app.displayWorld(worlds, "35");
        String output = "Test input 35 -- passed\n\n\n";
        System.out.println(output);
    }

    /**
     * Tests that getCountryReport() method produces a report
     */
    @Test
    void getCountriesInRegionByPopInputTest() {
        Country c = Country.getInstance();
        ArrayList<Country> countries = c.getCountryReport();
        app.displayCountry(countries, "36");
        String output = "Test input 36 -- passed \n\n\n";
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
