package com.aluracursos.screenmatch.calculations;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;
import com.aluracursos.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return this.totalTime;
    }

    public void totalEstimatedTimeTitle(Title title ){ //This method show how much time will take to complete all the series and movies included in a list
        System.out.println("Adding a length of " + title.getDurationInMinutes() + " minutes to the total time");
        this.totalTime += title.getDurationInMinutes();
    }
}
