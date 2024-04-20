public class Movie {
    String movieName;
    int releaseYear;
    int durationInMinutes;
    Boolean isUserPlanIncluded;
    private double sumOfRatings;
    private int numberOfRatings;

    int getNumberOfRatings() {
        return numberOfRatings;
    }

    double getSumOfRatings() {
        return sumOfRatings;
    }

    void displayMovieInfo() {
        System.out.println("Movie name: " + movieName);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Duration: " + durationInMinutes + " minutes");
        System.out.println("Included in user plan? " + isUserPlanIncluded);
    }

    void rateMovie(double rating) {
        sumOfRatings += rating;
        numberOfRatings++;
    }

    double getAverageRating() {
        return sumOfRatings / numberOfRatings;
    }
}