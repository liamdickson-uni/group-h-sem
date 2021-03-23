package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityTests {

    static City city;

    @BeforeAll
    static void init() {
        city = new City();
    }

    /**
     * Tests that getCitiesByPop() runs with out errors
     */
    @Test
    void getCitiesByPopTest() {
        city.getCitiesByPop();
    }

    @Test
    void getCitiesByPopIsNotNull(){
        ArrayList<City> cities = city.getCitiesByPop();
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesByPopCanConnect(){
        ArrayList<City> cities = city.getCitiesByPop();
    }


    /**
     * Tests that getCitiesInCountryByPop() runs with out errors
     */
    @Test
    void getCitiesInCountryByPopTest() {
        city.getCitiesInCountryByPop();
    }

    @Test
    void getCitiesInCountryByPopIsNotNull(){
        ArrayList<City> cities = city.getCitiesInCountryByPop();
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInCountryByPopCanConnect(){
        ArrayList<City> cities = city.getCitiesInCountryByPop();
    }


    /**
     * Tests that getCitiesInDistrictByPop() runs with out errors
     */
    @Test
    void getCitiesInDistrictByPopTest() {
        city.getCitiesInDistrictByPop();
    }

    @Test
    void getCitiesInDistrictByPopIsNotNull(){
        ArrayList<City> cities = city.getCitiesInDistrictByPop();
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInDistrictByPopCanConnect(){
        ArrayList<City> cities = city.getCitiesInDistrictByPop();
    }


    /**
     * Tests that getDistrictByPop() runs with out errors
     */
    @Test
    void getDistrictByPopTest() {
        city.getDistrictByPop();
    }

    @Test
    void getDistrictByPopNotNull(){
        ArrayList<City> cities = city.getDistrictByPop();
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getDistrictByPopCanConnect(){
        ArrayList<City> cities = city.getDistrictByPop();
    }



    /**
     * Tests that getCapitalCitiesInContinentByPop() runs without errors
     */
    @Test
    void getCapitalCitiesInContinentByPopTest(){
        city.getCapitalCitiesInContinentByPoP();
    }

    @Test
    void getCapitalCityInContinentByPopNotNullTest(){
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP();
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCapitalCitiesIContinentByPopCanConnect(){
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP();
    }


    /*
     * Tests that getCitiesInCont() runs without errors
     */
    @Test
    void getCitiesInContinentTest(){
        city.getCitiesInCont();
    }

    @Test
    void getCitiesInContNotNullTest(){
        ArrayList<City> cities = city.getCitiesInCont();
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInContCanConnect(){
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP();
    }


    /*
     * Tests that getCitiesInRegion() runs without errors
     */
    @Test
    void getCitiesInRegionTest(){
        city.getCitiesInRegion();
    }

    @Test
    void getCitiesInRegionNotNullTest(){
        ArrayList<City> cities = city.getCitiesInRegion();
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInRegionCanConnect(){
        ArrayList<City> cities = city.getCitiesInRegion();
    }


}

