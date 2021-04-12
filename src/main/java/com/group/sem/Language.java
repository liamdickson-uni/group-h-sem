package com.group.sem;

public class Language {


    /**
     *  The following code creates a singleton instance of the Language Class to be used throughout the program
     */

    //Private constructor
    private static Language INSTANCE;

    //Empty Constructor
    private Language(){
    }

    //Static factory method for obtaining the instance
    public static Language getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new Language();
        }
        return INSTANCE;
    }
  
  
  

    /**
     * Represents Country Code
     */
    public String CountryCode;

    /**
     * Represents Global Language
     */
    public String Language;

    /**
     * This represents if this is the official language of the country
     */

    public Enum IsOfficial;

    /**
     * Represents the percentage of people who speak the language in a given country
     */
    public double Percentage;
}
