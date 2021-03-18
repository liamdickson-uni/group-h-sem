package com.group.sem;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


public class CountryTests {

    static Country country;
    static App app;

    @BeforeAll
    static void init() {
        country = new Country();
        app = new App();
    }

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


    @Test
    void getCountryInContinentByPopThrowsException()
    {
            ArrayList<Country> countries = country.getCountryInContinentByPop();
            countries.clear();
            assertNull(countries);
    }


}
