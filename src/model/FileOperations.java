package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileOperations {
    private String filePath;
    private static String line = "";
    private static String splitBy = ",";

    public FileOperations(String filePath) {
        this.filePath = filePath;
    }

    public static String getLine() {
        return line;
    }

    public static String getSplitBy() {
        return splitBy;
    }
    public BufferedReader readFile() throws FileNotFoundException {
        BufferedReader br = null;
        try {
        br = new BufferedReader(new FileReader(this.filePath));
        //parsing a CSV file into BufferedReader class constructor
        br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            return br;
        }
    }
}
