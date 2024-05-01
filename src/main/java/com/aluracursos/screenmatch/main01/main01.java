package com.aluracursos.screenmatch.main01;

import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.SeriesData;
import com.aluracursos.screenmatch.service.ApiConsume;
import com.aluracursos.screenmatch.service.DataConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the application.
 * This class is responsible for interacting with the user and orchestrating the flow of the application.
 */
public class main01 {
    // Scanner object for reading user input
    private Scanner keyboard = new Scanner(System.in);
    // Service for consuming the API
    private ApiConsume apiConsume = new ApiConsume();
    // Constant for the API key
    private final String API_KEY = "&apikey=6c660fbc";
    // Constant for the base URL of the API
    private final String URL_BASE = "https://www.omdbapi.com/?t";
    // Service for converting data
    private DataConversion converter = new DataConversion();

    /**
     * Method to show the menu to the user.
     * This method asks the user for the name of the series they want to search for,
     * then retrieves and prints the data for the series and its seasons.
     */
    public void showMenu() {
        // Prompt the user for the name of the series
        System.out.println("Please write the name of the series you want to search for: ");
        String seriesName = keyboard.nextLine();
        // Retrieve the data for the series
        var json = apiConsume.obtainData(URL_BASE + "=" + seriesName.replace(" ", "+") + API_KEY);
        // Convert the data to a SeriesData object
        var data = converter.obtainData(json, SeriesData.class);

        // List to store the data for each season
        List<SeasonData> seasons = new ArrayList<>();
        // Loop over each season
        for (int i = 1; i <= data.totalSeasons(); i++) {
            // Retrieve the data for the season
            json = apiConsume.obtainData(URL_BASE + "=" + seriesName.replace(" ", "+") + "&Season=" + i + API_KEY);
            // Convert the data to a SeasonData object
            var dataSeason = converter.obtainData(json, SeasonData.class);
            // Add the season data to the list
            seasons.add(dataSeason);
        }
        // Print the data for each season
        seasons.forEach(System.out::println);
    }
}