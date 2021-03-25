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
    }


    /**
     * Tests that getCountryByPopDesc() runs with out errors
     */
    @Test
    void getCountryPopByDescTest() {
        country.getCountryByPopDesc();
    }

    @Test
    void getCountryByPopDescCanConnect()
    {
        ArrayList<Country> countries = country.getCountryByPopDesc();
    }

    @Test
    void getCountryByPopDescIsNotNull()
    {
        ArrayList<Country> countries = country.getCountryByPopDesc();
        for (Country country: countries) {
            assertNotNull(countries);}
    }

    /**
     * Tests that getCountryInContinentByPop() runs with out errors
     */

    @Test
    void getCountryInContinentByPopTest()
    {
        ArrayList<Country> countries = country.getCountryInContinentByPop();
        for (Country country: countries){
        assertNotNull(countries);}
    }

    @Test
    void getCountryInContinentCanConnect()
    {
        ArrayList<Country> countries = country.getCountryByPopDesc();
    }

    @Test
    void getCountryInContinentByDescTest() {
        country.getCountryInContinentByPop();
    }


    /**
     * Tests that getCountryInRegionByPop() runs with out errors
     */
    @Test
    void getCountryInRegionByPopTest() {
        country.getCountryInRegionByPop();
    }

    @Test
    void getCountryInRegionByPopTestIsNotNull()
    {
        ArrayList<Country> countries = country.getCountryInRegionByPop();
        for (Country country: countries){
            assertNotNull(countries);}
    }

    @Test
    void getCountryInRegionCanConnect()
    {
        ArrayList<Country> countries = country.getCountryByPopDesc();
    }




}








