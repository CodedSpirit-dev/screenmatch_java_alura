package com.aluracursos.screenmatch.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer season;
    private String title;
    private Integer episodeNumber;
    private Double imbdRating;
    private LocalDate launchDate;
    @ManyToOne
    private Serie serie;

    public Episode() {
    }

    public Episode(Integer number, EpisodeData d) {
        this.season = number;
        this.title = d.title();
        this.episodeNumber = Integer.valueOf(d.episodeNumber());
        try{
            this.imbdRating = Double.valueOf( d.imdbRating());
        }catch (NumberFormatException e){
            this.imbdRating = 0.0;
        }
        try {
            this.launchDate = LocalDate.parse(d.released());
        } catch (DateTimeParseException e){
            this.launchDate = null;
        }
    }

    public Episode(List<EpisodeData> episodes, EpisodeData e) {
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

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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