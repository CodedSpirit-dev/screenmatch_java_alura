public class Movie {
    String name;
    int year;
    int lengthInMinutes;
    Boolean includedInTheUserPlan;

    void showMovieInfo() {
        System.out.println("My movie is " + name);
        System.out.println("It was released in " + year);
        System.out.println("It lasts " + lengthInMinutes + " minutes");
        System.out.println("Is it included in the user plan? " + includedInTheUserPlan);
    }

    // Method to check if the movie is included in the user plan
}