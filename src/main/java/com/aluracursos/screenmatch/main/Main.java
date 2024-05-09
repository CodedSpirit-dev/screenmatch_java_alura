package com.aluracursos.screenmatch.main;

import com.aluracursos.screenmatch.model.*;
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
    // Repository for persisting series data
    private SerieRepository repository;
    // List to store series objects
    private List<Serie> series;

    /**
     * Constructor for the Main class.
     * @param serieRepository The repository used for persisting series data.
     */
    public Main(SerieRepository serieRepository) {
        this.repository = serieRepository;
    }

    /**
     * Method to show the menu to the user.
     * This method asks the user for the name of the series they want to search for,
     * then retrieves and prints the data for the series and its seasons.
     */
    public void showMenu() {
        // Variable to store the user's menu option
        var option = -1;
        // Loop until the user chooses to exit
        while (option != 0) {
            // Display the menu options
            var menu = """
                    1 - Search for series
                    2 - Search episodes
                    3 - Show searched series
                    4 - Search series by title
                    5 - Top 5 best series
                    6 - Search series by category
                    7 - Search series by total seasons and IMDb rating
                    8 - Search episodes by name

                    0 - Exit
                    """;
            System.out.println(menu);
            // Get the user's menu option
            option = keyboard.nextInt();
            keyboard.nextLine();

            // Perform the appropriate action based on the user's menu option
            switch (option) {
                case 1:
                    // Search for a series
                    searchWebSeries();
                    break;
                case 2:
                    // Search for episodes of a series
                    searchEpisodesBySeries();
                    break;
                case 3:
                    // Show the series that have been searched for
                    showSearchedSeries();
                    break;
                case 4:
                    // Search for a series by title
                    searchSeriesByTitle();
                    break;
                case 5:
                    // Show the top 5 best series
                    top5BestSeries();
                    break;
                    case 6:
                        searchSeriesByCategory();
                        break;
                    case 7:
                        searchSeriesByTotalSeasonsAndImdbRating();
                        break;
                    case 8:
                        searchEpisodesByName();
                        break;
                case 0:
                    // Exit the application
                    System.out.println("Goodbye!");
                    break;
                default:
                    // Handle an invalid menu option
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void searchEpisodesByName() {
        System.out.println("Please write the name of the episode you want to search for: ");
        var episodeName = keyboard.nextLine();
        List<Episode> foundEpisodes = repository.episodesByName(episodeName);

        foundEpisodes.forEach(e ->
                System.out.printf("Serie: %s Season: %s Episode: %s Rating %s",
                        e.getSerie(), e.getSeason(), e.getEpisodeNumber(), e.getImbdRating()));

    }

    private void searchSeriesByTotalSeasonsAndImdbRating() {
        System.out.println("Please write the total seasons of the series you want to search for: ");
        var totalSeasons = keyboard.nextInt();
        System.out.println("Please write the IMDb rating of the series you want to search for: ");
        var imdbRating = keyboard.nextDouble();
        List<Serie> filterSeries = repository.findSeriesBySeasonAndImdbRating(totalSeasons, imdbRating);
        System.out.println("Series by total seasons and IMDb rating: ");
        filterSeries.forEach(s ->
                System.out.println(s.getTitle() + " - " + s.getTotalSeasons() + " - " + s.getImdbRating()));
    }

    private void searchSeriesByCategory() {
        System.out.println("Please write the genre of the series you want to search for: ");
        var genre = keyboard.nextLine().toUpperCase();
        var category = GenreGroup.fromString(genre);
        List<Serie> seriesByCategory = repository.findByGenre(category);
        System.out.println("Series by category: " + genre);
        seriesByCategory.forEach(System.out::println);
    }

    /**
     * Method to display the top 5 best series based on IMDb rating.
     * This method retrieves the top 5 series from the repository and prints their title and IMDb rating.
     */
    private void top5BestSeries() {
        // Retrieve the top 5 series from the repository
        List<Serie> top5 = repository.findTop5ByOrderByImdbRatingDesc();
        // Print the title and IMDb rating of each series
        top5.forEach(s -> System.out.println(s.getTitle() + " - " + s.getImdbRating()));
    }

    /**
     * Method to search for a series by title.
     * This method asks the user for the title of the series they want to search for,
     * then retrieves and prints the data for the series.
     */
    private void searchSeriesByTitle() {
        // Ask the user for the title of the series they want to search for
        System.out.println("Please write the name of the series you want to search for: ");
        var seriesName = keyboard.nextLine();

        // Retrieve the series from the repository
        Optional<Serie> searchedSerie = repository.findByTitleContainsIgnoreCase(seriesName);

        // Print the series data if it was found, or a message if it was not found
        if (searchedSerie.isPresent()) {
            System.out.println("The series was found: " + searchedSerie.get());
        } else {
            System.out.println("Serie not found.");
        }
    }

    /**
     * Method to get the series data from the API.
     * This method asks the user for the name of the series they want to search for,
     * then retrieves and returns the data for the series.
     * @return The series data.
     */
    private SeriesData getSeriesData() {
        // Ask the user for the name of the series they want to search for
        System.out.println("Please write the name of the series you want to search for: ");
        var seriesName = keyboard.nextLine();
        // Retrieve the series data from the API
        var json = apiConsume.obtainData(URL_BASE + "=" + seriesName.replace(" ", "+") + API_KEY);
        System.out.println(json);
        // Convert the series data from JSON to a SeriesData object
        SeriesData data = converter.obtainData(json, SeriesData.class);
        return data;
    }

    /**
     * Method to search for episodes by series.
     * This method retrieves and prints the data for each episode of the series.
     */
    private void searchEpisodesBySeries() {
        // Show the series that have been searched for
        showSearchedSeries();
        // Ask the user for the name of the series they want to search for episodes of
        System.out.println("Please write the name of the series episodes you want to search for: ");
        var seriesName = keyboard.nextLine();
        // Retrieve the series from the list of series
        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitle().equalsIgnoreCase(seriesName))
                .findFirst();

        // If the series was found, retrieve and print the data for each episode
        if (serie.isPresent()) {
            var foundSerie = serie.get();
            List<SeasonData> seasons = new ArrayList<>();

            for (int i = 1; i <= foundSerie.getTotalSeasons(); i++) {
                // Retrieve the season data from the API
                var json = apiConsume.obtainData(URL_BASE + "=" + foundSerie.getTitle().replace(" ", "+") + "&season=" + i + API_KEY);
                // Convert the season data from JSON to a SeasonData object
                SeasonData seasonData = converter.obtainData(json, SeasonData.class);
                // Add the season data to the list of seasons
                seasons.add(seasonData);
            }
            // Print the season data
            seasons.forEach(System.out::println);
            // Convert the episode data from JSON to Episode objects and add them to the series
            List<Episode> episodes = seasons.stream()
                    .flatMap(d -> d.episodes().stream()
                            .map(e -> new Episode(d.seasonNumber(), e)))
                    .collect(Collectors.toList());

            // Add the episodes to the series
            foundSerie.setEpisodes(episodes);
            // Save the series in the repository
            repository.save(foundSerie);
        }
    }

    /**
     * Method to search for a web series.
     * This method retrieves and prints the data for the series.
     */
    private void searchWebSeries() {
        // Retrieve the series data from the API
        SeriesData dataSeries = getSeriesData();
        // Convert the series data to a Serie object
        Serie serie = new Serie(dataSeries);
        // Save the series in the repository
        repository.save(serie);
        // Print the series data
        System.out.println(dataSeries);
    }

    /**
     * Method to show the searched series.
     * This method prints the data for each series that has been searched for.
     */
    private void showSearchedSeries() {
        // Retrieve all series from the repository
        series = repository.findAll();

        // Sort the series by genre and print them
        series.stream()
                .sorted(Comparator.comparing(Serie::getGenre))
                .forEach(System.out::println);
    }
}