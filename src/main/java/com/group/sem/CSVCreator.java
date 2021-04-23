package com.group.sem;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


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

    public static void createCSV(String pathToCSV, ResultSet rset) throws IOException, SQLException {

        FileWriter out = new FileWriter(pathToCSV);
        CSVPrinter printer = CSVFormat.RFC4180.withHeader(rset).print(out);
        printer.printRecords(rset);
        printer.flush();
        printer.close();
}


}










