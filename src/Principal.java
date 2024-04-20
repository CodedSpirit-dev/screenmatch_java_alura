public class Principal {
    public static void main(String[] args) {
        Movie TheMatrix;
        TheMatrix = new Movie();
        TheMatrix.movieName = "The Matrix";
        TheMatrix.releaseYear = 1999;
        TheMatrix.durationInMinutes = 136;
        TheMatrix.isUserPlanIncluded = true;

        TheMatrix.displayMovieInfo();
        TheMatrix.rateMovie(9.5);
        TheMatrix.rateMovie(10.0);

        System.out.println(TheMatrix.sumOfRatings);
        System.out.println(TheMatrix.);
        System.out.println(TheMatrix.getAverageRating());

        System.out.println("-------------------------------------------------");


        Movie TheMatrixReloaded;
        TheMatrixReloaded = new Movie();
        TheMatrixReloaded.movieName = "The Matrix Reloaded";
        TheMatrixReloaded.releaseYear = 2003;
        TheMatrixReloaded.durationInMinutes = 138;
        TheMatrixReloaded.isUserPlanIncluded = false;

        TheMatrixReloaded.displayMovieInfo();
        TheMatrixReloaded.rateMovie(8.5);
        TheMatrixReloaded.rateMovie(9.0);

        System.out.println(TheMatrixReloaded.sumOfRatings);
        System.out.println(TheMatrixReloaded.numberOfRatings);
        System.out.println(TheMatrixReloaded.getAverageRating());

        System.out.println("-------------------------------------------------");
        

    }
}
