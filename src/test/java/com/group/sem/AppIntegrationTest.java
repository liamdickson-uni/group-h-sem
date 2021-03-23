package com.group.sem;

import org.junit.jupiter.api.*;


import java.util.ArrayList;


public class AppIntegrationTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect(false);
    }

    @Test
    void testInput1()
    {
        Country c = new Country();
        ArrayList<Country> countries = c.getCountryByPopDesc();
        app.displayCountry(countries, "1");
        String output = "\n\n\n";
        System.out.println(output);
    }



    @Test
    void testInput2() {
        Country c = new Country();
        ArrayList<Country> countries = c.getCountryInContinentByPop();
        app.displayCountry(countries, "2");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput3(){
        Country c = new Country();
        ArrayList<Country> countries = c.getCountryInRegionByPop();
        app.displayCountry(countries, "3");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput4(){
        City cty = new City();
        ArrayList<City> cities = cty.getCitiesInCountryByPop();
        app.displayCity(cities, "4");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput5(){
        City cty = new City();
        ArrayList<City> cities = cty.getCitiesByPop();
        app.displayCity(cities, "5");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput6(){
        City cty = new City();
        ArrayList<City> cities = cty.getCitiesInDistrictByPop();
        app.displayCity(cities, "6");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput7(){
        City cty = new City();
        ArrayList<City> cities = cty.getCitiesInCont();
        app.displayCity(cities, "7");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput8(){
        City cty = new City();
        ArrayList<City> cities = cty.getCitiesInRegion();
        app.displayCity(cities, "8");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput9(){
        City cty = new City();
        ArrayList<City> cities = cty.getDistrictByPop();
        app.displayCity(cities, "9");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput10(){
        City cty = new City();
        ArrayList<City> cities = cty.getCapitalCitiesInContinentByPoP();
        app.displayCity(cities, "10");
        String output = "\n\n\n";
        System.out.println(output);
    }

    @Test
    void testInput11(){
        City cty = new City();
        ArrayList<City> cities = cty.getCapitalCitiesInRegionByPoP();
        app.displayCity(cities, "11");
        String output = "\n\n\n";
        System.out.println(output);
    }

}
