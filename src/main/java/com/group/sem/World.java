package com.group.sem;

public class World {

        /**
         *  The following code creates a singleton instance of the World Class to be used throughout the program
         */

        //Private constructor
        private static World INSTANCE;

        //Empty Constructor
        World(){
        }

        //Static factory method for obtaining the instance
        public static World getInstance(){
            if (INSTANCE == null) {
                INSTANCE = new World();
            }
            return INSTANCE;
        }


    /*
     * Represents Country Name
     */
    public String countryName;


    /*
     * Represents a City Name
     */
    public String cityName;


    /*
     * Represents a City District
     */
    public String cityDistrict;


    /*
     * Represents a City Population
     */
    public int cityPopulation;


    /*
    * Represents a countries region
     */

    public String region;

    
}
