package data;

import constants.Paths;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Data {
    private static final String EQUAL = "=-=";

    public static void printData(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void saveData(String name, String data) {
        Map<String, String> dataMap = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(Paths.DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(EQUAL)) {
                    String[] parts = line.split(EQUAL, 2);
                    String key = parts[0].trim();
                    String val = parts[1].replaceAll("\"", "").trim();
                    dataMap.put(key, val);
                }
            }
        } catch (IOException e) {
            System.out.println("File not found, creating a new one...");
        }

        dataMap.put(name, data);

        try (FileWriter writer = new FileWriter(Paths.DATA_FILE)) {
            for (Map.Entry<String, String> entry : dataMap.entrySet())
                writer.write(entry.getKey() + EQUAL + "\"" + entry.getValue() + "\"\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static String readData(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(Paths.DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null)
                if (line.startsWith(name + EQUAL))
                    return line.split(EQUAL)[1].replaceAll("\"", "").trim();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return null;
    }
}