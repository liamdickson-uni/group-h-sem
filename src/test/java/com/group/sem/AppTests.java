package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class AppTests
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = App.getInstance();
    }

    /**
     * Tests what happens when displayCountry() Is Null
     */
    @Test
    void displayCountryTestNull()
    {
        app.displayCountry(null, null);
    }

    /**
     * Tests what happens when displayCity() Is Null
     */
    @Test
    void displayCityTestNull()
    {
        app.displayCity(null, null);
    }

    /**
     * Tests what happens when displayWorld() Is Null
     */
    @Test
    void displayWorldTestNull()
    {
        app.displayWorld(null, null);
    }

    /**
     * Tests what happens when displayCountry() is empty
     */
    @Test
    void displayCountryTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountry(countries, "0");
    }

    /**
     * Tests what happens when displayWorld() is empty
     */
    @Test
    void displayWorldTestEmpty()
    {
        ArrayList<World> worlds = new ArrayList<World>();
        app.displayWorld(worlds, "0");
    }

    /**
     * Tests what happens when displayCity() is empty
     */
    @Test
    void displayCityTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCity(cities, "0");
    }

    /**
     * Tests what happens when displayCountry() contains a null
     */
    @Test
    void displayCountryTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.displayCountry(countries,"0");
    }

    /**
     * Tests what happens when displayCity() contains a null
     */
    @Test
    void displayCityTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCity(cities,"0");
    }

    /**
     * Tests what happens when displayWorld() contains a null
     */
    @Test
    void displayWorldTestContainsNull()
    {
        ArrayList<World> worlds = new ArrayList<World>();
        worlds.add(null);
        app.displayWorld(worlds,"0");
    }


    @Test
    void displayCountries()
    {
        ArrayList<Country> country = new ArrayList<Country>();
        Country cnt = Country.getInstance();

        cnt.Code = "1";
        cnt.Name = "Scotland";
        cnt.Continent = "Europe";
        cnt.Region = "North";
        cnt.SurfaceArea = 1232;
        cnt.Population = 5500000;
        cnt.LifeExpectancy = 68;
        cnt.GNP = 208;
        cnt.GNPOld = 208;
        cnt.LocalName = "Scotland";
        cnt.GovernmentForm = "Liberal Democracy";
        cnt.HeadOfState = "Queen Elizabeth II";
        cnt.Capital = "Edinburgh";
        cnt.Code2 = "AW";

        app.displayCountry(country, "1");
    }

    @Test
    void displayCities()
    {
        ArrayList<City> city = new ArrayList<City>();
        City cty =  City.getInstance();

        cty.cityID = 1;
        cty.cityName = "Scotland";
        cty.countryCode = "AFG";
        cty.cityDistrict = "Kabol";
        cty.cityPopulation = 1780000;

        app.displayCity(city, "1");
    }

    @Test
    void displayWorld()
    {
        ArrayList<World> worlds = new ArrayList<World>();
        World wld =  World.getInstance();

        wld.countryName = "Scotland";
        wld.cityName = "Edinburgh";
        wld.cityDistrict = "Lothian";
        wld.cityPopulation = 43243223;
        wld.ruralPopulation= 432524354;
        wld.region = "North";
        wld.countryPopulation = 842543432;
        wld.regionPopulation = 553342432;
        wld.continentPopulation = 342432523;
        wld.languagePercentage = 5.99f;
        wld.language = "English";
        wld.continent = "Europe";
        wld.cityPercentage = 79.2f;
        wld.ruralPercentage = 16.2f;

        app.displayWorld(worlds, "1");
    }






}