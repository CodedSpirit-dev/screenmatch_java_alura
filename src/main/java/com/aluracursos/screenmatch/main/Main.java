package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.Episode;
import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.model.SeriesData;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.ApiConsume;
import com.aluracursos.screenmatch.service.DataConversion;

import java.util.*;
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
    private SerieRepository repository;
    private List<Serie> series;

    public Main(SerieRepository serieRepository) {
        this.repository = serieRepository;
    }

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
        showSearchedSeries();
        System.out.println("Please write the name of the series episodes you want to search for: ");
        var seriesName = keyboard.nextLine();

        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(seriesName))
                .findFirst();

if (serie.isPresent()) {
    var foundSerie = serie.get();
    List<SeasonData> seasons = new ArrayList<>();

    for (int i = 1; i <= foundSerie.getTotalSeasons(); i++) {
        //var json = apiConsume.obtainData(URL_BASE + "=" + getSeriesData().title().replace(" ", "+") + "&season=" + i + API_KEY);
        var json = apiConsume.obtainData(URL_BASE + "=" + foundSerie.getTitle().replace(" ", "+") + "&season=" + i + API_KEY);
        SeasonData seasonData = converter.obtainData(json, SeasonData.class);
        seasons.add(seasonData);
    }
    seasons.forEach(System.out::println);
    List<Episode> episodes = seasons.stream()
            .flatMap(d -> d.episodes().stream()
                    .map(e -> new Episode(d.seasonNumber(), e)))
            .collect(Collectors.toList());

    foundSerie.setEpisodes(episodes);
    repository.save(foundSerie);
}
    }

    /**
     * Method to search for a web series.
     * This method retrieves and prints the data for the series.
     */
    private void searchWebSeries() {
        SeriesData dataSeries = getSeriesData();
        Serie serie = new Serie(dataSeries);
        repository.save(serie);
        //seriesData.add(dataSeries);
        System.out.println(dataSeries);
    }

    /**
     * Method to show the searched series.
     * This method prints the data for each series that has been searched for.
     */
    private void showSearchedSeries() {
        series = repository.findAll();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenre))
                .forEach(System.out::println);
    }
}