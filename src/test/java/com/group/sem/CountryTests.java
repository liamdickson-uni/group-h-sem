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
        country = new Country();
        app = new App();
    }


    /**
     * Method GetCountryInContinentByPop()
     */
    @Test
    void getCountryInContinentByPopCanConnect()
    {
        ArrayList<Country> countries = country.getCountryInContinentByPop();
    }

    @Test
    void getCountryInContinentByPopIsNotNull()
    {
        ArrayList<Country> countries = country.getCountryInContinentByPop();
        for (Country country: countries){
        assertNotNull(countries);}
    }


    /**
     * Method Get CountryByPopDesc()
     */

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
    }








