package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.model.SeriesData;
import com.aluracursos.screenmatch.service.ApiConsume;
import com.aluracursos.screenmatch.service.DataConversion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Main class for the application.
 * This class is responsible for interacting with the user and orchestrating the flow of the application.
 */
public class Main {
    // Constant for the API key
    private final String API_KEY = "&apikey=6c660fbc";
    // Constant for the base URL of the API
    private final String URL_BASE = "https://www.omdbapi.com/?t";
    // Scanner object for reading user input
    private Scanner keyboard = new Scanner(System.in);
    // Service for consuming the API
    private ApiConsume apiConsume = new ApiConsume();
    // Service for converting data
    private DataConversion converter = new DataConversion();
    // List to store the series data
    private List<SeriesData> seriesData = new ArrayList<>();

    /**
     * Method to show the menu to the user.
     * This method asks the user for the name of the series they want to search for,
     * then retrieves and prints the data for the series and its seasons.
     */
    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Search for series
                    2 - Search episodes
                    3 - Show searched series

                    0 - Exit
                    """;
            System.out.println(menu);
            option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    searchWebSeries();
                    break;
                case 2:
                    searchEpisodesBySeries();
                    break;
                case 3:
                    showSearchedSeries();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Method to get the series data from the API.
     * This method asks the user for the name of the series they want to search for,
     * then retrieves and returns the data for the series.
     * @return The series data.
     */
    private SeriesData getSeriesData() {
        System.out.println("Please write the name of the series you want to search for: ");
        var seriesName = keyboard.nextLine();
        var json = apiConsume.obtainData(URL_BASE + "=" + seriesName.replace(" ", "+") + API_KEY);
        System.out.println(json);
        SeriesData data = converter.obtainData(json, SeriesData.class);
        return data;
    }

    /**
     * Method to search for episodes by series.
     * This method retrieves and prints the data for each episode of the series.
     */
    private void searchEpisodesBySeries() {
        SeriesData dataSeries = getSeriesData();
        List< SeasonData > seasons = new ArrayList<>();

        for (int i = 1; i <= dataSeries.totalSeasons(); i++) {
            var json = apiConsume.obtainData(URL_BASE + dataSeries.title().replace(" ", "+") + "&Season=" + i + API_KEY);
            SeasonData seasonData = converter.obtainData(json, SeasonData.class);
            seasons.add(seasonData);

        }
        seasons.forEach(System.out::println);
    }

    /**
     * Method to search for a web series.
     * This method retrieves and prints the data for the series.
     */
    private void searchWebSeries() {
        SeriesData dataSeries = getSeriesData();
        seriesData.add(dataSeries);
        System.out.println(dataSeries);
    }

    /**
     * Method to show the searched series.
     * This method prints the data for each series that has been searched for.
     */
    private void showSearchedSeries() {
        List<Serie> series = new ArrayList<>();
        series = seriesData.stream()
                .map(d -> new Serie(d))
                .collect(Collectors.toList());

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenre));

    }
}