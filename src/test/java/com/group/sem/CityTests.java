package com.group.sem;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CityTests {

    static City city;

    @BeforeAll
    static void init()
    {
        city = new City();
    }

    void getCitiesInCountry(){
        city.getCitiesInCountryByPop();
    }}