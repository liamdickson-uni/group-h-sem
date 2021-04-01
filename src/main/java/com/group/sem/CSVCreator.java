package com.group.sem;




import java.io.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;



public class CSVCreator {

    /**
     * The following code creates a singleton instance of the CSVWriter Class to be used throughout the program
     */

    //Private constructor
    private static CSVCreator INSTANCE;

    //Empty Constructor
    private CSVCreator() {
    }

    //Static factory method for obtaining the instance
    public static CSVCreator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CSVCreator();
        }
        return INSTANCE;
    }

    /**
     *
     * @param pathToCSV
     * @param data
     * @throws IOException
     * @throws SQLException
     */
    public void createCSVFile(String pathToCSV, ResultSet data) throws IOException, SQLException {

    }
}

