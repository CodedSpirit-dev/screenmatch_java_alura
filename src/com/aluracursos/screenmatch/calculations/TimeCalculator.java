package com.aluracursos.screenmatch.calculations;
import com.aluracursos.screenmatch.models.Movie;
import com.aluracursos.screenmatch.models.Series;
import com.aluracursos.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void totalEstimatedTimeTitle(Title title ){ //This method show how much time will take to complete all the series and movies included in a list
       this.totalTime += title.getDurationInMinutes();
        System.out.println("The total time to watch all the series and movies included in the list is: " + totalTime + " minutes");
    }
}
