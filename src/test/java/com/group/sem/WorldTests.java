package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class WorldTests {

    static World world;

    @BeforeAll
    static void init() {
        world = World.getInstance();
    }

    /**
     * Tests that getCitiesInCountryByPop() runs with out errors
     */
    @Test
    void getCitiesInCountryByPopTest() {
        world.getCitiesInCountryByPop("United States of America");
    }

    @Test
    void getCitiesInCountryByPopIsNotNull() {
        ArrayList<World> wld = world.getCitiesInCountryByPop("Italy");
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void getCitiesInCountryByPopCanConnect() {
        ArrayList<World> wld = world.getCitiesInCountryByPop("France");
    }

    /**
     * Tests that getCapitalCitiesInContinentByPop() runs without errors
     */
    @Test
    void getCapitalCitiesInContinentByPopTest() {
        world.getCapitalCitiesInContinentByPoP("North America");
    }

    @Test
    void getCapitalCityInContinentByPopNotNullTest() {
        ArrayList<World> wld = world.getCapitalCitiesInContinentByPoP("Europe");
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void getCapitalCitiesIContinentByPopCanConnect() {
        ArrayList<World> wld = world.getCapitalCitiesInContinentByPoP("Oceania");
    }

    /*
     * Tests that getCitiesInCont() runs without errors
     */
    @Test
    void getCitiesInContinentTest() {
        world.getCitiesInCont("North America");
    }

    @Test
    void getCitiesInContNotNullTest() {
        ArrayList<World> wld = world.getCitiesInCont("North America");
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void getCitiesInContCanConnect() {
        ArrayList<World> wld = world.getCapitalCitiesInContinentByPoP("Europe");
    }

    /*
     * Tests that getCitiesInRegion() runs without errors
     */
    @Test
    void getCitiesInRegionTest() {
        world.getCitiesInRegion("Western Europe");
    }

    @Test
    void getCitiesInRegionNotNullTest() {
        ArrayList<World> wld = world.getCitiesInRegion("Western Europe");
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void getCitiesInRegionCanConnect() {
        ArrayList<World> wld = world.getCitiesInRegion("Western Europe");
    }

    /**
     * Tests that getCitiesInRegion() runs without errors
     */
    @Test
    void getCapitalCitiesInRegionTest() {
        world.getCapitalCitiesInRegionByPoP("Middle East");
    }

    @Test
    void getCapitalCitiesInRegionNotNullTest() {
        ArrayList<World> wld = world.getCapitalCitiesInRegionByPoP("Middle East");
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void getCapitalCitiesInRegionCanConnect() {
        ArrayList<World> wld = world.getCapitalCitiesInRegionByPoP("Middle East");
    }

    /**
     * Tests that getS() runs with out errors
     */
    @Test
    void getSetNCitiesInContByPopTest() {
        world.getSetNCitiesInContByPop("North America", 1);
    }

    @Test
    void getSetNCitiesInContByPopNotNull() {
        ArrayList<World> wld = world.getSetNCitiesInContByPop("North America", 10);

        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void getSetNCitiesInContByPopCanConnect() {
        ArrayList<World> wld = world.getSetNCitiesInContByPop("North America", 5);
    }

    /**
     * Tests that setNGetCitiesInRegionByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInRegionByPopTest() {
        world.setNGetCitiesInRegionByPop("Middle East", 10);
    }

    @Test
    void setNGetCitiesInRegionByPopNotNull() {
        ArrayList<World> wld = world.setNGetCitiesInRegionByPop("Middle East", 10);
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void setNGetCitiesInRegionByPopCanConnect() {
        ArrayList<World> wld = world.setNGetCitiesInRegionByPop("Middle East", 10);
        for (World world : wld) {
            assertNotNull(wld);

        }
    }

    /**
     * Tests that getCountryByPopDesc() runs with out errors
     */
    @Test
    void getLanguagePercentageTest() {
        world.getLanguagePercentage("Chinese");
    }

    @Test
    void getLanguagePercentageCanConnect() {
        ArrayList<World> worlds = world.getLanguagePercentage("Chinese");
    }

    @Test
    void getLanguagePercentageIsNotNull() {
        ArrayList<World> worlds = world.getLanguagePercentage("Chinese");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getRegionPopReport() runs with out errors
     */
    @Test
    void getRegionPopReportTest() {
        world.getRegionPopReport("Caribbean");
    }

    @Test
    void getRegionPopReportCanConnect() {
        ArrayList<World> worlds = world.getRegionPopReport("Caribbean");
    }

    @Test
    void getRegionPopReportIsNotNull() {
        ArrayList<World> worlds = world.getRegionPopReport("Caribbean");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }


    /**
     * Tests that getContinentPopReport() runs with out errors
     */
    @Test
    void getContinentPopReportTest() {
        world.getContinentPopReport("Europe");
    }

    @Test
    void getContinentPopReportCanConnect() {
        ArrayList<World> worlds = world.getContinentPopReport("Europe");
    }

    @Test
    void getContinentPopReportIsNotNull() {
        ArrayList<World> worlds = world.getContinentPopReport("Europe");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getCountryPopReport() runs with out errors
     */
    @Test
    void getCountryPopReportTest() {
        world.getCountryPopReport("Scotland");
    }

    @Test
    void getCountryPopReportCanConnect() {
        ArrayList<World> worlds = world.getCountryPopReport("Scotland");
    }

    @Test
    void getCountryPopReportIsNotNull() {
        ArrayList<World> worlds = world.getCountryPopReport("Scotland");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getCitiesAndRuralForRegion() runs with out errors
     */
    @Test
    void getCitiesAndRuralForRegionTest() {
        world.getCitiesAndRuralForRegion();
    }

    @Test
    void getCitiesAndRuralForRegionCanConnect() {
        ArrayList<World> worlds = world.getCitiesAndRuralForRegion();
    }

    @Test
    void getCitiesAndRuralForRegionIsNotNull() {
        ArrayList<World> worlds = world.getCitiesAndRuralForRegion();
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getCitiesAndRuralForCountry() runs with out errors
     */
    @Test
    void getCitiesAndRuralForCountryTest() {
        world.getCitiesAndRuralForCountry();
    }

    @Test
    void getCitiesAndRuralForCountryCanConnect() {
        ArrayList<World> worlds = world.getCitiesAndRuralForCountry();
    }

    @Test
    void getCitiesAndRuralForCountryIsNotNull() {
        ArrayList<World> worlds = world.getCitiesAndRuralForCountry();
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getCitiesAndRuralForContinent() runs with out errors
     */
    @Test
    void ggetCitiesAndRuralForContinentTest() {
        world.getCitiesAndRuralForContinent();
    }

    @Test
    void getCitiesAndRuralForContinentCanConnect() {
        ArrayList<World> worlds = world.getCitiesAndRuralForContinent();
    }

    @Test
    void getCitiesAndRuralForContinentIsNotNull() {
        ArrayList<World> worlds = world.getCitiesAndRuralForContinent();
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getCityInfo() runs with out errors
     */
    @Test
    void getByPopTest() {
        world.getCityInfo("Europe", "Scotland");
    }

    @Test
    void getCityInfoNotNull() {
        ArrayList<World> worlds = world.getCityInfo("Europe", "Scotland");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getCityInfoCanConnect() {
        ArrayList<World> worlds = world.getCityInfo("Europe", "Scotland");
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getSetNCapitalCitiesInContByPop() runs with out errors
     */
    @Test
    void getSetNCapitalCitiesInContByPopCanConnect() {
        ArrayList<World> worlds  = world.getSetNCapitalCitiesInContByPop("Europe", 5);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getSetNCapitalCitiesInRegion() runs with out errors
     */
    @Test
    void getSetNCapitalCitiesInRegionTest() {
        world.getSetNCapitalCitiesInRegionByPop( "Caribbean", 5);
    }

    @Test
    void getSetNCapitalCitiesInRegionNotNull() {
        ArrayList<World> worlds = world.getSetNCapitalCitiesInRegionByPop("Caribbean", 5);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getSetNCapitalCitiesInRegionCanConnect() {
        ArrayList<World> worlds = world.getSetNCapitalCitiesInRegionByPop("Caribbean", 5);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that setNGetCitiesInContinentByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInContinentByPopTest() {
        world.setNGetCitiesInContinentByPop("Europe", 10);
    }

    @Test
    void setNGetCitiesInContinentByPopNotNull() {
        ArrayList<World> worlds = world.setNGetCitiesInContinentByPop("Europe", 10);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void setNGetCitiesInContinentByPopCanConnect() {
        ArrayList<World> cities = world.setNGetCitiesInContinentByPop("Europe", 10);
        for (World world : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that getSetNCityInCountryByPop() runs with out errors
     */
    @Test
    void getSetNCityInCountryByPopTest() {
        world.getSetNCityInCountryByPop("Scotland",10 );
    }

    @Test
    void getSetNCityInCountryByPopNotNull() {
        ArrayList<World> worlds = world.getSetNCityInCountryByPop( "Scotland", 10);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getSetNCityInCountryByPopCanConnect() {
        ArrayList<World> worlds = world.getSetNCityInCountryByPop("Scotland",10);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getNumberOfCapitalCitiesWorld() runs with out errors
     */
    @Test
    void getSetNCapitalCitiesInWorldTest() {
        world.getSetNCapitalCitiesInWorld(5);
    }

    @Test
    void getSetNCapitalCitiesInWorldNotNull() {
        ArrayList<World> worlds = world.getSetNCapitalCitiesInWorld(5);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getSetNCapitalCitiesInWorldCanConnect() {
        ArrayList<World> worlds = world.getSetNCapitalCitiesInWorld(5);
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    /**
     * Tests that getCountryReport() runs with out errors
     */
    @Test
    void getCountryReportByPop() { world.getCountryReport();
    }

    @Test
    void getCountryReportpNotNull() {
        ArrayList<World> worlds = world.getCountryReport();
        for (World world : worlds) {
            assertNotNull(worlds);
        }
    }

    @Test
    void getCountryReportCanConnect() {
        ArrayList<World> countries = world.getCountryReport();

    }

}
