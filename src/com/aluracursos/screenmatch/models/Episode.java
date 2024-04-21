package com.aluracursos.screenmatch.models;

import com.aluracursos.screenmatch.calculations.Classification;

public class Episode implements Classification {
    private int episodeNumber;
    private String episodeName;
    private Series series;
    private int totalVisualizations;

    public int getTotalVisualizations() {
        return totalVisualizations;
    }

    public void setTotalVisualizations(int totalVisualizations) {
        this.totalVisualizations = totalVisualizations;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    @Override
    public int getClassification() {
        if(totalVisualizations >= 1000){
            return 10;
        }else if(totalVisualizations >= 500){
            return 8;
        }else if(totalVisualizations >= 100){
            return 6;
        }else if(totalVisualizations >= 50){
            return 4;
        }
        return 1;
    }

}
