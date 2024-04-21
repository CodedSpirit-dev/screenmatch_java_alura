import com.aluracursos.screenmatch.calculations.TimeCalculator;
import com.aluracursos.screenmatch.models.Episode;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;
import com.aluracursos.screenmatch.calculations.RecommendationFilter;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");

        Movie theMatrix = new Movie();
        theMatrix.setName("The Matrix");
        theMatrix.setReleaseYear(1999);
        theMatrix.setDurationInMinutes(136);

        System.out.println("Movie duration: " + theMatrix.getDurationInMinutes());

        theMatrix.displayInfo();
        theMatrix.rateTitle(9.5);
        theMatrix.rateTitle(8.0);

        System.out.println("-------------------------------------------------");

        Series houseOfCards = new Series();
        houseOfCards.setName("House of Cards");
        houseOfCards.setReleaseYear(2013);
        houseOfCards.setNumberOfSeasons(6);
        houseOfCards.setNumberOfEpisodesPerSeason(13);
        houseOfCards.setMinutesPerEpisode(51);

        System.out.println("Series duration: " + houseOfCards.getDurationInMinutes());

        houseOfCards.displayInfo();

        System.out.println("-------------------------------------------------");

        TimeCalculator timeCalculator = new TimeCalculator();

        Movie theMatrixReloaded = new Movie();
        theMatrixReloaded.setName("The Matrix Reloaded");
        theMatrixReloaded.setReleaseYear(2003);
        theMatrixReloaded.setDurationInMinutes(138);

        System.out.println("Movie duration: " + theMatrixReloaded.getDurationInMinutes());

        theMatrixReloaded.displayInfo();

        timeCalculator.totalEstimatedTimeTitle(theMatrix);
        timeCalculator.totalEstimatedTimeTitle(houseOfCards);
        timeCalculator.totalEstimatedTimeTitle(theMatrixReloaded);

        System.out.println("-------------------------------------------------");

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        recommendationFilter.filter(theMatrix);

        Episode episode = new Episode();
        episode.setEpisodeNumber(1);
        episode.setSeries(houseOfCards);
        episode.setTotalVisualizations(1000);

        recommendationFilter.filter(episode);

        System.out.println("-------------------------------------------------");

        Movie avatar = new Movie();
        avatar.setName("Avatar");
        avatar.setReleaseYear(2023);
        avatar.setDurationInMinutes(200);

        Movie theLordOfTheRings = new Movie();
        theLordOfTheRings.setName("The Lord of the Rings");
        theLordOfTheRings.setReleaseYear(2001);
        theLordOfTheRings.setDurationInMinutes(180);

        Series lost = new Series();
        lost.setName("Lost");
        lost.setReleaseYear(2000);
        lost.setNumberOfSeasons(10);
        lost.setNumberOfEpisodesPerSeason(10);
        lost.setMinutesPerEpisode(50);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(avatar);
        movieList.add(theLordOfTheRings);
        movieList.add(theMatrix);


        System.out.println("-------------------------------------------------");

        System.out.println("Size of the movie list: " + movieList.size());
        System.out.println("The first movie is: " + movieList.get(0).getName());

        System.out.println(movieList.toString());

        System.out.println("toString of the movie: " + movieList.get(0).toString());
    }
}