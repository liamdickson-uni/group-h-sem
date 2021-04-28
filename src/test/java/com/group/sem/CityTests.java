package com.group.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityTests {

    static City city;
    static App app;

    @BeforeAll
    static void init() {
        city = City.getInstance();
        app = App.getInstance();
        String location = "34.105.185.101:3306";
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.connect(location);
    }

    /**
     * Tests that getCitiesByPop() runs with out errors
     */
    @Test
    void getCitiesByPopTest() {
        city.getCitiesByPop();
    }

    @Test
    void getCitiesByPopIsNotNull() {
        ArrayList<City> cities = city.getCitiesByPop();
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCitiesByPopCanConnect() {
        ArrayList<City> cities = city.getCitiesByPop();
    }

    /**
     * Tests that getCitiesInDistrictByPop() runs with out errors
     */
    @Test
    void getCitiesInDistrictByPopTest() {
        city.getCitiesInDistrictByPop("Texas");
    }

    @Test
    void getCitiesInDistrictByPopIsNotNull() {
        ArrayList<City> cities = city.getCitiesInDistrictByPop("Texas");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getCitiesInDistrictByPopCanConnect() {
        ArrayList<City> cities = city.getCitiesInDistrictByPop("Arizona");
    }


    /**
     * Tests that getDistrictByPop() runs with out errors
     */
    @Test
    void getDistrictByPopTest() {
        city.getDistrictByPop("Scotland");
    }

    @Test
    void getDistrictByPopNotNull() {
        ArrayList<City> cities = city.getDistrictByPop("Scotland");
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getDistrictByPopCanConnect() {
        ArrayList<City> cities = city.getDistrictByPop("Scotland");
    }

    /**
     * Tests that getCitiesPopulation() runs with out errors
     */
    @Test
    void getCitiesPopulationTest() {
        city.getCitiesPopulation("London");
    }

    @Test
    void getCitiesPopulationCanConnect() {
        ArrayList<City> cities = city.getCitiesPopulation("Texas");
    }

    /**
     * Tests that setNGetCitiesInDistrictByPop() runs with out errors
     */
    @Test
    void setNGetCitiesInDistrictByPopTest() {
        city.setNGetCitiesInDistrictByPop("Texas", 10);
    }

    @Test
    void setNGetCitiesInDistrictByPopNotNull() {
        ArrayList<City> cities = city.setNGetCitiesInDistrictByPop("Texas", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void setNGetCitiesInDistrictByPopCanConnect() {
        ArrayList<City> cities = city.setNGetCitiesInDistrictByPop("Texas", 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    /**
     * Tests that getSetNCityInWorldByPop() runs with out errors
     */
    @Test
    void getSetNCityInWorldByPopTest() {
        city.getSetNCityInWorldByPop(10 );
    }

    @Test
    void getSetNCityInWorldByPopNotNull() {
        ArrayList<City> cities = city.getSetNCityInWorldByPop( 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

    @Test
    void getSetNCityInWorldByPopCanConnect() {
        ArrayList<City> cities = city.getSetNCityInWorldByPop( 10);
        for (City city : cities) {
            assertNotNull(cities);
        }
    }

}


