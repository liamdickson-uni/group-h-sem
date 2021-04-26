package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        world.getSetNCitiesInContByPop("North America", "1");
    }

    @Test
    void getSetNCitiesInContByPopNotNull() {
        ArrayList<World> wld = world.getSetNCitiesInContByPop("North America", "10");

        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void getSetNCitiesInContByPopCanConnect() {
        ArrayList<World> wld = world.getSetNCitiesInContByPop("North America", "5");
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
     * Tests that setNGetCitiesInContinentByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInContinentByPopTest() {
        world.setNGetCitiesInContinentByPop("Europe", 10);
    }

    @Test
    void setNGetCitiesInContinentByPopNotNull() {
        ArrayList<World> wld = world.setNGetCitiesInContinentByPop("Europe", 10);
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

    @Test
    void setNGetCitiesInContinentByPopCanConnect() {
        ArrayList<World> wld = world.setNGetCitiesInContinentByPop("Europe", 10);
        for (World world : wld) {
            assertNotNull(wld);
        }
    }

}