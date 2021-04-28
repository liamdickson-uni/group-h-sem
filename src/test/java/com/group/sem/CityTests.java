package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityTests {

    static City city;

    @BeforeAll
    static void init() {
        city = City.getInstance();
    }

    /**
     * Tests that getCitiesByPop() runs with out errors
     */
    @Test
    void getCitiesByPopTest() {
        city.getCitiesByPop();
    }

    @Test
    void getCitiesByPopIsNotNull() {
        ArrayList<City> cities = city.getCitiesByPop();
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCitiesByPopCanConnect() {
        ArrayList<City> cities = city.getCitiesByPop();
    }

    /**
     * Tests that getCitiesInDistrictByPop() runs with out errors
     */
    @Test
    void getCitiesInDistrictByPopTest() {
        city.getCitiesInDistrictByPop("Texas");
    }

    @Test
    void getCitiesInDistrictByPopIsNotNull() {
        ArrayList<City> cities = city.getCitiesInDistrictByPop("Texas");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCitiesInDistrictByPopCanConnect() {
        ArrayList<City> cities = city.getCitiesInDistrictByPop("Arizona");
    }


    /**
     * Tests that getDistrictByPop() runs with out errors
     */
    @Test
    void getDistrictByPopTest() {
        city.getDistrictByPop();
    }

    @Test
    void getDistrictByPopNotNull() {
        ArrayList<City> cities = city.getDistrictByPop();
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getDistrictByPopCanConnect() {
        ArrayList<City> cities = city.getDistrictByPop();
    }


    /**
     * Tests that getCapitalCitiesInContinentByPop() runs without errors
     */
    @Test
    void getCapitalCitiesInContinentByPopTest() {
        city.getCapitalCitiesInContinentByPoP("North America");
    }

    @Test
    void getCapitalCityInContinentByPopNotNullTest() {
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP("Europe");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCapitalCitiesIContinentByPopCanConnect() {
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP("Oceania");
    }


    /**
     * Tests that getCitiesInCont() runs without errors
     */
    @Test
    void getCitiesInContinentTest() {
        city.getCitiesInCont("North America");
    }

    @Test
    void getCitiesInContNotNullTest() {
        ArrayList<City> cities = city.getCitiesInCont("North America");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCitiesInContCanConnect() {
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP("Europe");
    }


    /**
     * Tests that getCitiesInRegion() runs without errors
     */
    @Test
    void getCitiesInRegionTest() {
        city.getCitiesInRegion("Western Europe");
    }

    @Test
    void getCitiesInRegionNotNullTest() {
        ArrayList<City> cities = city.getCitiesInRegion("Western Europe");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCitiesInRegionCanConnect() {
        ArrayList<City> cities = city.getCitiesInRegion("Western Europe");
    }


    /**
     * Tests that getCitiesInRegionByPop() runs without errors
     */
    @Test
    void getCapitalCitiesInRegionTest() {
        city.getCapitalCitiesInRegionByPoP("Middle East");
    }

    @Test
    void getCapitalCitiesInRegionNotNullTest() {
        ArrayList<City> cities = city.getCapitalCitiesInRegionByPoP("Middle East");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCapitalCitiesInRegionCanConnect() {
        ArrayList<City> cities = city.getCapitalCitiesInRegionByPoP("Middle East");
    }

    /**
     * Tests that getCitiesPopulatio() runs with out errors
     */
    @Test
    void getCitiesPopulationTest() {
        city.getCitiesPopulation("Texas");
    }

    @Test
    void getCitiesPopulationNotNull() {
        ArrayList<City> cities = city.getCitiesPopulation("Texas");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCitiesPopulationCanConnect() {
        ArrayList<City> cities = city.getCitiesPopulation("Texas");
    }

    /**
     * Tests that getSetNCitiesInContByPop() runs with out errors
     */
    @Test
    void getSetNCitiesInContByPopTest() {
        city.getSetNCitiesInContByPop("North America", "1");
    }

    @Test
    void getSetNCitiesInContByPopNotNull() {
        ArrayList<City> cities = city.getSetNCitiesInContByPop("North America", "10");

        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getSetNCitiesInContByPopCanConnect() {
        ArrayList<City> cities = city.getSetNCitiesInContByPop("North America", "5");
    }

    /**
     * Tests that setNGetCitiesInDistrictByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInDistrictByPopTest() {
        city.setNGetCitiesInDistrictByPop("Texas", 10);
    }

    @Test
    void setNGetCitiesInDistrictByPopNotNull() {
        ArrayList<City> cities = city.setNGetCitiesInDistrictByPop("Texas", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void setNGetCitiesInDistrictByPopCanConnect() {
        ArrayList<City> cities = city.setNGetCitiesInDistrictByPop("Texas", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that setNGetCitiesInRegionByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInRegionByPopTest() {
        city.setNGetCitiesInRegionByPop("Middle East", 10);
    }

    @Test
    void setNGetCitiesInRegionByPopNotNull() {
        ArrayList<City> cities = city.setNGetCitiesInRegionByPop("Middle East", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void setNGetCitiesInRegionByPopCanConnect() {
        ArrayList<City> cities = city.setNGetCitiesInRegionByPop("Middle East", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that setNGetCitiesInContinentByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInContinentByPopTest() {
        city.setNGetCitiesInContinentByPop("Europe", 10);
    }

    @Test
    void setNGetCitiesInContinentByPopNotNull() {
        ArrayList<City> cities = city.setNGetCitiesInContinentByPop("Europe", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void setNGetCitiesInContinentByPopCanConnect() {
        ArrayList<City> cities = city.setNGetCitiesInContinentByPop("Europe", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that getCityInfo() runs with out errors
     */
    @Test
    void getByPopTest() {
        city.getCityInfo("Europe", "Scotland");
    }

    @Test
    void getCityInfoNotNull() {
        ArrayList<World> worlds = city.getCityInfo("Europe", "Scotland");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getCityInfoCanConnect() {
        ArrayList<World> worlds = city.getCityInfo("Europe", "Scotland");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getSetNCapitalCitiesInContByPop() runs with out errors
     */
    @Test
    void getSetNCapitalCitiesInContByPop() {
        city.getSetNCapitalCitiesInContByPop("Europe", 5);
    }

    @Test
    void getSetNCapitalCitiesInContByPop() {
        ArrayList<City> cities = city.getSetNCapitalCitiesInContByPop("Europe", 5);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getSetNCapitalCitiesInContByPopCanConnect() {
        ArrayList<City> cities  = city.getSetNCapitalCitiesInContByPop("Europe", 5);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that getNumberOfCapitalCities() runs with out errors
     */
    @Test
    void getNumberOfCapitalCitiesTest() {
        city.getNumberOfCapitalCities(5, "Caribbean");
    }

    @Test
    void getNumberOfCapitalCitiesNotNull() {
        ArrayList<World> worlds = city.getNumberOfCapitalCities(5, "Caribbean");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getNumberOfCapitalCitiesCanConnect() {
        ArrayList<World> worlds = city.getNumberOfCapitalCities(5, "Caribbean");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that setNGetCitiesInContinentByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInContinentByPopTest() {
        city.setNGetCitiesInContinentByPop("Europe", 10);
    }

    @Test
    void setNGetCitiesInContinentByPopNotNull() {
        ArrayList<City> cities = city.setNGetCitiesInContinentByPop("Europe", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void setNGetCitiesInContinentByPopCanConnect() {
        ArrayList<City> cities = city.setNGetCitiesInContinentByPop("Europe", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that getSetNCityInWorldByPop() runs with out errors
     */
    @Test
    void getSetNCityInWorldByPopTest() {
        city.getSetNCityInWorldByPop("10" );
    }

    @Test
    void getSetNCityInWorldByPopNotNull() {
        ArrayList<City> cities = city.getSetNCityInWorldByPop( "10");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getSetNCityInWorldByPopCanConnect() {
        ArrayList<City> cities = city.getSetNCityInWorldByPop( "10");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that getSetNCityInCountryByPop() runs with out errors
     */
    @Test
    void getSetNCityInCountryByPopTest() {
        city.getSetNCityInCountryByPop("10","Scotland" );
    }

    @Test
    void getSetNCityInCountryByPopNotNull() {
        ArrayList<City> cities = city.getSetNCityInCountryByPop( "10", "Scotland");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getSetNCityInCountryByPopCanConnect() {
        ArrayList<City> cities = city.getSetNCityInCountryByPop( "10","Scotland");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }
    /**
     * Tests that getSetNCityInCountryByPop() runs with out errors
     */
    @Test
    void getSetNCityInCountryByPopTest() {
        city.getSetNCityInCountryByPop("10","Scotland" );
    }

    @Test
    void getSetNCityInCountryByPopNotNull() {
        ArrayList<City> cities = city.getSetNCityInCountryByPop( "10", "Scotland");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getSetNCityInCountryByPopCanConnect() {
        ArrayList<City> cities = city.getSetNCityInCountryByPop( "10","Scotland");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that getNumberOfCapitalCitiesWorld() runs with out errors
     */
    @Test
    void getNumberOfCapitalCitiesWorldTest() {
        city.getNumberOfCapitalCitiesWorld(5);
    }

    @Test
    void getNumberOfCapitalCitiesWorldNotNull() {
        ArrayList<World> worlds = city.getNumberOfCapitalCitiesWorld(5);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getNumberOfCapitalCitiesWorldCanConnect() {
        ArrayList<World> worlds = city.getNumberOfCapitalCitiesWorld(5);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

}


