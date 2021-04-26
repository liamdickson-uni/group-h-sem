package com.group.sem;

import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WorldTests {

    static World world;

    @BeforeAll
    static void init() {
        world = World.getInstance();
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

}
