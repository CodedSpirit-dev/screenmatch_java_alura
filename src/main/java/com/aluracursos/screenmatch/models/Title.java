package com.aluracursos.screenmatch.models;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {

    @SerializedName("Title")
    private String name;
    @SerializedName("Year")
    public int releaseYear;
    public int durationInMinutes;
    public Boolean isUserPlanIncluded;
    private double sumOfRatings;
    private int numberOfRatings;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;

    }

    public Title(TitleOmdb myTitleOmdb) {
        this.name = myTitleOmdb.title();
        this.releaseYear = Integer.valueOf(myTitleOmdb.year());
        this.durationInMinutes = Integer.valueOf(myTitleOmdb.runtime().substring(0,2));


    }

    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public int getDurationInMinutes() {
        return durationInMinutes;
    }
    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }
    public Boolean getUserPlanIncluded() {
        return isUserPlanIncluded;
    }
    public void setUserPlanIncluded(Boolean userPlanIncluded) {
        isUserPlanIncluded = userPlanIncluded;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public double getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(double sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public void displayInfo() {
        System.out.println("Title name: " + name);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Duration: " + getDurationInMinutes() + " minutes");
        System.out.println("Included in user plan? " + isUserPlanIncluded);
    }

    public void rateTitle(double rating) {
        sumOfRatings += rating;
        numberOfRatings++;
    }

    public double getAverageRating() {
        return sumOfRatings / numberOfRatings;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", releaseYear=" + releaseYear +
                ", duration in minutes=" + durationInMinutes;
    }
}
