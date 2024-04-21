package com.aluracursos.screenmatch.main;

// Importing necessary classes
import com.aluracursos.screenmatch.calculations.TimeCalculator;
import com.aluracursos.screenmatch.models.Episode;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;
import com.aluracursos.screenmatch.calculations.RecommendationFilter;
import com.aluracursos.screenmatch.models.Title;

import java.util.ArrayList;

/**
 * Main class with lists
 * This class is responsible for creating instances of movies and series, rating them and adding them to a list.
 * It also prints the name and classification of each movie in the list.
 */
public class MainWithLists {
    public static void main(String[] args) {
        // Creating and rating movies
        Movie theMatrix = new Movie("The Matrix", 1999);
        theMatrix.rateTitle(9.5);
        theMatrix.rateTitle(8.0);
        Series houseOfCards = new Series("House of Cards", 2013);
        Movie theMatrixReloaded = new Movie("The Matrix Reloaded", 2003);
        theMatrixReloaded.rateTitle(7.5);
        theMatrixReloaded.rateTitle(8.0);
        Movie avatar = new Movie("Avatar", 2023);
        avatar.rateTitle(9.0);
        avatar.rateTitle(8.5);
        avatar.rateTitle(9.0);
        Movie theLordOfTheRings = new Movie("The Lord of the Rings", 2001);
        theLordOfTheRings.rateTitle(9.5);
        theLordOfTheRings.rateTitle(9.0);
        theLordOfTheRings.rateTitle(9.5);
        Series lost = new Series("Lost", 2004);

        // Creating a list of titles and adding the movies and series to it
        ArrayList<Title> titleList = new ArrayList<>();
        titleList.add(theMatrix);
        titleList.add(theMatrixReloaded);
        titleList.add(avatar);
        titleList.add(theLordOfTheRings);
        titleList.add(houseOfCards);
        titleList.add(lost);

        // Printing the name and classification of each movie in the list
        for (Title item: titleList){
            System.out.println(item.getName());
            if (item instanceof Movie movie){
                System.out.println("Classification: " + movie.getClassification());
            }
        }
    }
}