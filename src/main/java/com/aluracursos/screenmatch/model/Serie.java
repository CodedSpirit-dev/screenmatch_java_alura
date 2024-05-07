package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.UseChatGPT;
import com.fasterxml.jackson.annotation.JsonAlias;
import jdk.jfr.Category;

import java.util.OptionalDouble;

public class Serie {
    private String title;
    private Integer totalSeasons;
    private Double imdbRating;
    private String poster;
    private GenreGroup genre;
    private String actors;
    private String plot;

    public Serie(SeriesData seriesData){
        this.title = seriesData.title();
        this.totalSeasons = seriesData.totalSeasons();
        this.imdbRating = OptionalDouble.of(Double.valueOf(seriesData.imdbRating())).orElse(0.0);
        this.poster = seriesData.poster();
        this.genre = GenreGroup.valueOf(seriesData.genre().split(",")[0].trim().toUpperCase());
        this.actors = seriesData.actors();
        this.plot = UseChatGPT.getTranslation(seriesData.plot());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(Integer totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public Double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(Double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public GenreGroup getGenre() {
        return genre;
    }

    public void setGenre(GenreGroup genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "Title='" + title + '\'' +
                ", TotalSeasons=" + totalSeasons +
                ", Rating=" + imdbRating +
                ", Poster='" + poster + '\'' +
                ", Genre=" + genre +
                ", Actors='" + actors + '\'' +
                ", Plot='" + plot + '\'';
    }
}
