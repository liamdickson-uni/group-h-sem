package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect();
    }

    @Test
    void testGetCountry()
    {
        Country c = new Country();
        ArrayList<Country> countries = c.getCountryByPopDesc();
        app.displayCountry(countries, "1");

    }


}
