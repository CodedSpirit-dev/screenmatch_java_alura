package com.aluracursos.screenmatch.model;

import java.time.LocalDate;

public class Episode {
    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double imbdRating;
    private LocalDate launchDate;

    public Episode(Integer number, EpisodeData d) {
        this.season = number;
        this.title = d.title();
        this.episodeNumber = Integer.valueOf(d.episodeNumber());
        try{
            this.imbdRating = Double.valueOf( d.imdbRating());
        }catch (NumberFormatException e){
            this.imbdRating = 0.0;
        }
        this.launchDate = LocalDate.parse(d.released());
    }


    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer seasonNumber) {
        this.season = seasonNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public Double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(Double imbdRating) {
        this.imbdRating = imbdRating;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return
                "season=" + season +
                ", title='" + title + '\'' +
                ", episodeNumber=" + episodeNumber +
                ", imbdRating=" + imbdRating +
                ", launchDate=" + launchDate
                ;
    }
}