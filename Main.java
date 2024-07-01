package HW3Arrays;                                                                                                                    // Morgan Pickens 5/27/2024 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        CityLinkedList<City> cityList = new CityLinkedList<>(); // create new CityLinkedList
        boolean loaded = loadData(cityList, "citiesShort.txt"); // load the data 

        if (loaded) { // chat that data loaded right 
            System.out.println("Cities added to the list:");
            for (City city : cityList) { // iterate through the CityLinkedList
                System.out.println(city); // print each city
            }
        } else {
            System.out.println("Failed to load city data from the file.");
        }
    }

    
    //ldscity data from a file and adds it to the city list.    
    //param cityList the CityLinkedList to add data 
    //param filename the name of the file to read data from
    //return boolean indicating ifdata was loaded successfully
    
    private static boolean loadData(CityLinkedList<City> cityList, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true; // to skip the first line when we need to 
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; 
                }
                line = line.trim(); 
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                // split the line into parts
                String[] parts = line.split("\\s+", 2); // split into population and the rest

                if (parts.length < 2) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                try {
                    int population = Integer.parseInt(parts[0].replaceAll(",", "")); // for population parsing
                    String[] locationParts = parts[1].split(",");

                    if (locationParts.length < 2) {
                        System.out.println("Invalid line format: " + line);
                        continue;
                    }

                    String name = locationParts[0].trim();
                    String country = locationParts[locationParts.length - 1].trim();
                    String state = locationParts.length > 2 ? locationParts[1].trim() : "";

                    City city = new City(name, country, state, population);
                    cityList.add(city); // add the city to the linked list
                } catch (NumberFormatException e) {
                    System.out.println("Invalid population number: " + parts[0]);
                }
            }
            return true; // data loaded successfully
        } catch (IOException e) {
            e.printStackTrace(); 
            return false; // data loading failed
        }
    }
}


