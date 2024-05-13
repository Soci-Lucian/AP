package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataImporter {
    public void importData(String datasetPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(datasetPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processData(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processData(String data) {

    }
}
