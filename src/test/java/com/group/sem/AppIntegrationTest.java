package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("db:3306");


    }

    @Test
    void testGetCountry()
    {
        Country c = new Country();
        ArrayList<Country> countries = c.getCountryByPopDesc();
        app.displayCountry(countries, "1");
        assertEquals(c.Code, "1");
    }


}
