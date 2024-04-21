package com.aluracursos.screenmatch.models;

public class Title implements Comparable<Title> {


    private String Name;
    public int releaseYear;
    public int durationInMinutes;
    public Boolean isUserPlanIncluded;
    private double sumOfRatings;
    private int numberOfRatings;

    public Title(String name, int releaseYear) {
        Name = name;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
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
        System.out.println("Title name: " + Name);
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
}
