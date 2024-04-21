import com.aluracursos.screenmatch.calculations.TimeCalculator;
import com.aluracursos.screenmatch.models.Episode;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;
import com.aluracursos.screenmatch.calculations.RecommendationFilter;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");

        Movie TheMatrix;
        TheMatrix = new Movie();
        TheMatrix.setName("The Matrix");
        TheMatrix.setReleaseYear(1999);
        TheMatrix.setDurationInMinutes(136);
        TheMatrix.setUserPlanIncluded(true);

        TheMatrix.displayInfo();
        TheMatrix.rateTitle(9.5);
        TheMatrix.rateTitle(8.0);

        System.out.println("-------------------------------------------------");

        Series houseOfCards = new Series();
        houseOfCards.setName("House of Cards");
        houseOfCards.setReleaseYear(2013);
        houseOfCards.setNumberOfSeasons(6);
        houseOfCards.setMinutesPerEpisode(51);
        houseOfCards.setNumberOfEpisodesPerSeason(13);
        houseOfCards.setUserPlanIncluded(true);
        houseOfCards.displayInfo();

        System.out.println("-------------------------------------------------");

        TimeCalculator timeCalculator = new TimeCalculator();

        Movie TheMatrixReloaded;
        TheMatrixReloaded = new Movie();
        TheMatrixReloaded.setName("The Matrix Reloaded");
        TheMatrixReloaded.setReleaseYear(2003);
        TheMatrixReloaded.setDurationInMinutes(138);
        TheMatrixReloaded.setUserPlanIncluded(true);
        TheMatrixReloaded.displayInfo();

        timeCalculator.totalEstimatedTimeTitle(TheMatrix);
        timeCalculator.totalEstimatedTimeTitle(houseOfCards);
        timeCalculator.totalEstimatedTimeTitle(TheMatrixReloaded);

        System.out.println("-------------------------------------------------");

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        recommendationFilter.filter(TheMatrix);

        Episode episode = new Episode();
        episode.setEpisodeNumber(1);
        episode.setEpisodeName("Chapter 1");
        episode.setSeries(houseOfCards);
        episode.setTotalVisualizations(1000);

        recommendationFilter.filter(episode);
    }
}
