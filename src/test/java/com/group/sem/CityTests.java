package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CityTests {

    static City city;

    @BeforeAll
    static void init() {
        city = new City();
    }

    /**
     * Tests that getCitiesByPop() runs with out errors
     */
    @Test
    void getCitiesByPopTest() {
        city.getCitiesByPop();
    }

    /**
     * Tests that getCitiesInCountryByPop() runs with out errors
     */
    @Test
    void getCitiesInCountryByPopTest() {
        city.getCitiesInCountryByPop();
    }

    /**
     * Tests that getCitiesInDistrictByPop() runs with out errors
     */
    @Test
    void getCitiesInDistrictByPopTest() {
        city.getCitiesInDistrictByPop();
    }
}

