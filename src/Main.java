import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;

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
        TheMatrix.rateTitle(10.0);

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

        /*com.aluracursos.screenmatch.models.Movie TheMatrixReloaded;
        TheMatrixReloaded = new com.aluracursos.screenmatch.models.Movie();
        TheMatrixReloaded.movieName = "The Matrix Reloaded";
        TheMatrixReloaded.releaseYear = 2003;
        TheMatrixReloaded.durationInMinutes = 138;
        TheMatrixReloaded.isUserPlanIncluded = false;

        TheMatrixReloaded.displayMovieInfo();
        TheMatrixReloaded.rateMovie(8.5);
        TheMatrixReloaded.rateMovie(9.0);

        System.out.println(TheMatrixReloaded.getSumOfRatings());
        System.out.println(TheMatrixReloaded.getNumberOfRatings());
        System.out.println(TheMatrixReloaded.getAverageRating());

        System.out.println("-------------------------------------------------");*/

    }
}
