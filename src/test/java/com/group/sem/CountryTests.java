package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CountryTests {

    static Country country;

    @BeforeAll
    static void init() {
        country = new Country();
    }

    /**
     * Tests that getCountryByPopDesc() runs with out errors
     */
    @Test
    void getCountryPopByDescTest() {
        country.getCountryByPopDesc();
    }

    /**
     * Tests that getCountryInContinentByPop() runs with out errors
     */
    @Test
    void getCountryInContinentByPopTest()
    {
        country.getCountryInContinentByPop();
    }

    /**
     * Tests that getCountryInRegionByPop() runs with out errors
     */
    @Test
    void getCountryInRegionByPopTest() {
        country.getCountryInRegionByPop();
    }
}
