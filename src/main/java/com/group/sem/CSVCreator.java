package com.group.sem;

import com.opencsv.CSVWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class CSVCreator {

    /**
     *  The following code creates a singleton instance of the CSVWriter Class to be used throughout the program
     */

    //Private constructor
    private static CSVCreator INSTANCE;

    //Empty Constructor
    private CSVCreator(){
    }

    //Static factory method for obtaining the instance
    public static CSVCreator getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new CSVCreator();
        }
        return INSTANCE;
    }


    App app = App.getInstance();


    public void createCSVFileCountry(Path pathToCSV, ResultSet data) throws IOException, SQLException {

        try (CSVWriter writer = new CSVWriter(Files.newBufferedWriter(pathToCSV, StandardCharsets.UTF_8),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {

            writer.writeAll(data, true);
        }


    }
}
