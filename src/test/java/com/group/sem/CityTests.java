package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityTests {

    static City city;

    @BeforeAll
    static void init() {
        city = City.getInstance();
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
        city.getCitiesInCountryByPop("United States of America");
    }

    @Test
    void getCitiesInCountryByPopIsNotNull(){
        ArrayList<City> cities = city.getCitiesInCountryByPop("Italy");
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInCountryByPopCanConnect(){
        ArrayList<City> cities = city.getCitiesInCountryByPop("France");
    }


    /**
     * Tests that getCitiesInDistrictByPop() runs with out errors
     */
    @Test
    void getCitiesInDistrictByPopTest() {
        city.getCitiesInDistrictByPop("Texas");
    }

    @Test
    void getCitiesInDistrictByPopIsNotNull(){
        ArrayList<City> cities = city.getCitiesInDistrictByPop("Texas");
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInDistrictByPopCanConnect(){
        ArrayList<City> cities = city.getCitiesInDistrictByPop("Arizona");
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
        city.getCapitalCitiesInContinentByPoP("North America");
    }

    @Test
    void getCapitalCityInContinentByPopNotNullTest(){
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP("Europe");
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCapitalCitiesIContinentByPopCanConnect(){
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP("Oceania");
    }


    /*
     * Tests that getCitiesInCont() runs without errors
     */
    @Test
    void getCitiesInContinentTest(){
        city.getCitiesInCont("North America");
    }

    @Test
    void getCitiesInContNotNullTest(){
        ArrayList<City> cities = city.getCitiesInCont("North America");
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInContCanConnect(){
        ArrayList<City> cities = city.getCapitalCitiesInContinentByPoP("Europe");
    }


    /*
     * Tests that getCitiesInRegion() runs without errors
     */
    @Test
    void getCitiesInRegionTest(){
        city.getCitiesInRegion("Western Europe");
    }

    @Test
    void getCitiesInRegionNotNullTest(){
        ArrayList<City> cities = city.getCitiesInRegion("Western Europe");
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesInRegionCanConnect(){
        ArrayList<City> cities = city.getCitiesInRegion("Western Europe");
    }


    /**
     * Tests that getCitiesInRegion() runs without errors
     */
    @Test
    void getCapitalCitiesInRegionTest(){
        city.getCapitalCitiesInRegionByPoP("Middle East");
    }

    @Test
    void getCapitalCitiesInRegionNotNullTest(){
        ArrayList<City> cities = city.getCapitalCitiesInRegionByPoP("Middle East");
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCapitalCitiesInRegionCanConnect(){
        ArrayList<City> cities = city.getCapitalCitiesInRegionByPoP("Middle East");
    }

    /**
     * Tests that getDistrictByPop() runs with out errors
     */
    @Test
    void getCitiesPopulationTest() {
        city.getCitiesPopulation("Texas");
    }

    @Test
    void getCitiesPopulationNotNull(){
        ArrayList<City> cities = city.getCitiesPopulation("Texas");
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getCitiesPopulationCanConnect(){
        ArrayList<City> cities = city.getCitiesPopulation("Texas");
    }

    /**
     * Tests that getS() runs with out errors
     */
    @Test
    void getSetNCitiesInContByPopTest() {
        city.getSetNCitiesInContByPop("North America","1");
    }

    @Test
    void getSetNCitiesInContByPopNotNull(){
        ArrayList<City> cities = city.getSetNCitiesInContByPop("North America","10");

        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void getSetNCitiesInContByPopCanConnect(){
        ArrayList<City> cities = city.getSetNCitiesInContByPop("North America","5");
    }
  
    /**
    * Tests that setNGetCitiesInDistrictByPop() runs with out errors
    */
    @Test
    void setNGetCitiesInDistrictByPopTest() {
        city.setNGetCitiesInDistrictByPop("Texas",10);
    }

    @Test
    void setNGetCitiesInDistrictByPopNotNull(){
        ArrayList<City> cities = city.setNGetCitiesInDistrictByPop("Texas",10);
      
    @Test
    void setNGetCitiesInDistrictByPopCanConnect(){
        ArrayList<City> cities = city.setNGetCitiesInDistrictByPop("Texas",10);
    }

    /**
     * Tests that setNGetCitiesInRegionByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInRegionByPopTest() {
        city.setNGetCitiesInRegionByPop("Middle East",10);
    }

    @Test
    void setNGetCitiesInRegionByPopNotNull(){
        ArrayList<City> cities = city.setNGetCitiesInRegionByPop("Middle East",10);
        for (City city: cities){
            assertNotNull(cities);}
    }

    @Test
    void setNGetCitiesInRegionByPopCanConnect(){
        ArrayList<City> cities = city.setNGetCitiesInRegionByPop("Middle East",10);
    }
  
}


