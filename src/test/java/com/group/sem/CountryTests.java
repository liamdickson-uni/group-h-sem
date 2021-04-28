package com.group.sem;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CountryTests {

    static Country country;
    static App app;

    @BeforeAll
    static void init() {
        country = Country.getInstance();
        app = App.getInstance();
        String location = "34.105.185.101:3306";
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect(location);
    }


    /**
     * Tests that getCountryByPopDesc() runs with out errors
     */
    @Test
    void getCountryPopByDescTest() {
        country.getCountryByPopDesc();
    }

    @Test
    void getCountryByPopDescCanConnect() {
        ArrayList<Country> countries = country.getCountryByPopDesc();
    }

    @Test
    void getCountryByPopDescIsNotNull() {
        ArrayList<Country> countries = country.getCountryByPopDesc();
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

    /**
     * Tests that getCountryInContinentByPop() runs with out errors
     */

    @Test
    void getCountryInContinentByPopTest() {
        ArrayList<Country> countries = country.getCountryInContinentByPop("Europe");
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

    @Test
    void getCountryInContinentCanConnect() {
        ArrayList<Country> countries = country.getCountryInContinentByPop("Europe");

    }

    @Test
    void getCountryInContinentByDescTest() {
        country.getCountryInContinentByPop("Europe");
    }


    /**
     * Tests that getCountryInRegionByPop() runs with out errors
     */
    @Test
    void getCountryInRegionByPopTest() {
        country.getCountryInRegionByPop("Middle East");
    }

    @Test
    void getCountryInRegionByPopTestIsNotNull() {
        ArrayList<Country> countries = country.getCountryInRegionByPop("British Islands");
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }


    @Test
    void getCountryInRegionCanConnect() {
        ArrayList<Country> countries = country.getCountryByPopDesc();
    }

    /**
     * Tests that getWorldPopulation() runs with out errors
     */

    @Test
    void getWorldPopulationTest() {
        country.getWorldPopulation();
    }

    @Test
    void getWorldPopulationCanConnect() {
        ArrayList<Country> countries = country.getWorldPopulation();
    }

    @Test
    void getWorldPopulationIsNotNull() {
        ArrayList<Country> countries = country.getWorldPopulation();
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

    /**
     * Tests that getDistrictByPop() runs with out errors
     */
    @Test
    void getDistrictByPopTest() {
        country.getCountryPopulation("American Samoa");
    }

    @Test
    void getDistrictByPopNotNull() {
        ArrayList<Country> countries = country.getCountryPopulation("Belgium");
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

        @Test
        void getCountryPopulationCanConnect() {
            ArrayList<Country> countries = country.getCountryPopulation("Belgium");

        }

    /**
     * Tests that getSetNCountryInRegionByPop() runs with out errors
     */
    @Test
    void getSetNCountryInRegionByPopTest() { country.getSetNCountryInRegionByPop("Caribbean",5);
    }

    @Test
    void getSetNCountryInRegionByPopNotNull() {
        ArrayList<Country> countries = country.getSetNCountryInRegionByPop("Caribbean",5);
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

    @Test
    void getSetNCountryInRegionByPopCanConnect() {
        ArrayList<Country> countries = country.getSetNCountryInRegionByPop("Caribbean", 5);

    }

    /**
     * Tests that getPopOfRegion() runs with out errors
     */
    @Test
    void getPopOfRegionTest() { country.getPopOfRegion("Central Africa");
    }

    @Test
    void getPopOfRegionNotNull() {
        ArrayList<Country> countries = country.getPopOfRegion("Central Africa");
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

    @Test
    void getPopOfRegionCanConnect() {
        ArrayList<Country> countries = country.getPopOfRegion("Central Africa");

    }

    /**
     * Tests that getPopOfContinent() runs with out errors
     */
    @Test
    void getPopOfContinent() { country.getPopOfContinent("North America");
    }

    @Test
    void getPopOfContinentNotNull() {
        ArrayList<Country> countries = country.getPopOfContinent("North America");
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

    @Test
    void getPopOfContinentCanConnect() {
        ArrayList<Country> countries = country.getPopOfContinent("North America");

    }

    /**
     * Tests that getCountriesInRegionByPop() runs with out errors
     */
    @Test
    void getCountriesInRegionByPop() { country.getCountriesInRegionByPop("North America");
    }

    @Test
    void getCountriesInRegionByPopNotNull() {
        ArrayList<Country> countries = country.getCountriesInRegionByPop("North America");
        for (Country country : countries) {
            assertNotNull(countries);
        }
    }

    @Test
    void getCountriesInRegionByPopCanConnect() {
        ArrayList<Country> countries = country.getCountriesInRegionByPop("North America");

    }

}








