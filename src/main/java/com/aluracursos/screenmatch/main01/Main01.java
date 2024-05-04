package com.aluracursos.screenmatch.main01;

import com.aluracursos.screenmatch.model.Episode;
import com.aluracursos.screenmatch.model.EpisodeData;
import com.aluracursos.screenmatch.model.SeasonData;
import com.aluracursos.screenmatch.model.SeriesData;
import com.aluracursos.screenmatch.service.ApiConsume;
import com.aluracursos.screenmatch.service.DataConversion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Main class for the application.
 * This class is responsible for interacting with the user and orchestrating the flow of the application.
 */
public class Main01 {
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
        // Print the data for the series
        System.out.println(data);

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
        //seasons.forEach(System.out::println);

        //Show only the title of the series to the seasons
        /*for (int i = 0; i < data.totalSeasons(); i++) {
            List<EpisodeData> episodesSeason = seasons.get(i).episodes();
            //Show the title of the series
            for (EpisodeData episodeData : episodesSeason) {
                System.out.println(episodeData.title());
            }
        }*/
        //seasons.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));

        //Convert all the information into a list of the type "episodeData"
        List<EpisodeData> episodesData = seasons.stream()
                .flatMap(t -> t.episodes().stream())
                .collect(Collectors.toList());



        //Top 5 episodes
        /*System.out.println("===Top 5 episodes===");
        episodesData.stream()
                .filter(e -> !e.imdbRating().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(EpisodeData::imdbRating).reversed())
                .limit(5)
                .forEach(System.out::println);*/

        // Transforming data into a episode type list
        List<Episode> episodes = seasons.stream()
                .flatMap(t -> t.episodes().stream()
                        .map(d -> new Episode(t.seasonNumber(), d)))
                .collect(Collectors.toList());
        //episodes.forEach(System.out::println);

        //Search episodes by specific year
    /*System.out.println("Please write the year you want to search for: ");
    var date = keyboard.nextInt();
    keyboard.nextLine();

    LocalDate dateSearch = LocalDate.of(date, 1, 1);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    episodes.stream()
            .filter(e -> e.getLaunchDate() != null && e.getLaunchDate().isAfter(dateSearch))
            .forEach(e -> System.out.println(
                    "Season: " + e.getSeason() +
                            " Title: " + e.getTitle() +
                            " Launch Date: " + e.getLaunchDate().format(dtf)
            ));*/

        // Search episodes by title fragments
/*        System.out.println("Please write the title fragment you want to search for: ");
        var titleFragment = keyboard.nextLine();

        Optional<Episode> searchedEpisode = episodes.stream()
                .filter(e -> e.getTitle().toUpperCase().contains(titleFragment.toUpperCase()))
                .findFirst();

        if (searchedEpisode.isPresent()) {
            System.out.println(searchedEpisode.get());
        } else {
            System.out.println("No episode found with the title fragment: " + titleFragment);
        }*/

        Map<Integer, Double> averageRatingBySeason = episodes.stream()
                .filter(e -> e.getImbdRating() > 0.0)
                .collect(Collectors.groupingBy(Episode::getSeason,
                        Collectors.averagingDouble(Episode::getImbdRating)));

        System.out.println(averageRatingBySeason);

        DoubleSummaryStatistics est = episodes.stream()
                .filter(e -> e.getImbdRating() > 0.0)
                .collect(Collectors.summarizingDouble(Episode::getImbdRating));
        System.out.println("Worst evaluation: " + est.getMin() + "\nBest evaluation: " + est.getMax() + "\nAverage: " + est.getAverage());
    }}