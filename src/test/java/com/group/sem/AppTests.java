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
        app = new App();
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
     * Tests what happens when displayCountry() is empty
     */
    @Test
    void displayCountryTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountry(countries, "0");
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
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountry(countries,"0");
    }

    /**
     * Tests what happens when displayCity() contains a null
     */
    @Test
    void displayTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountry(countries,"0");
    }


    @Test
    void displayCountries()
    {
        ArrayList<Country> country = new ArrayList<Country>();
        Country cnt = new Country();

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
        cnt.code2 = "302";

        app.displayCountry(country, "1");
    }

    @Test
    void displayCities()
    {
        ArrayList<City> city = new ArrayList<City>();
        City cnt = new City();

        cnt.cityID = "1";
        cnt.cityName = "Scotland";
        cnt.countryCode = "AFG";
        cnt.cityDistrict = "Kabol";
        cnt.cityPopulation = 1780000;

        app.displayCity(city, "1");
    }






}