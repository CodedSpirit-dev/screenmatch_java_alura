# screenmatch_java_alura

# ScreenMatch Java Alura

This project is a Java application that simulates a movie and series streaming platform. It includes classes for movies, series, and episodes, and implements a classification system.

## Classes

- `Title`: This is the base class for all titles on the platform. It includes properties such as name, release year, duration, and user plan inclusion. It also includes methods for rating the title and calculating the average rating.

- `Movie`: This class extends `Title` and implements the `Classification` interface. It includes an additional property for the director of the movie.

- `Episode`: This class implements the `Classification` interface. It includes properties for the episode number, episode name, series it belongs to, and total visualizations.

- `Classification`: This is an interface that includes a method for getting the classification of a title.

## Usage

To use this application, create instances of `Movie` or `Series`, set their properties, and call their methods as needed. For example:

```java
Movie TheMatrix = new Movie();
TheMatrix.setName("The Matrix");
TheMatrix.setReleaseYear(1999);
TheMatrix.setDurationInMinutes(136);
TheMatrix.setUserPlanIncluded(true);
TheMatrix.displayInfo();
TheMatrix.rateTitle(9.5);
TheMatrix.rateTitle(10.0);