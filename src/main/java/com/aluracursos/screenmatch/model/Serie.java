package com.aluracursos.screenmatch.model;

import com.aluracursos.screenmatch.service.UseChatGPT;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String title;
    private Integer totalSeasons;
    private String poster;
    @Enumerated(EnumType.STRING)
    private GenreGroup genre;
    private String actors;
    private String plot;
    private Double imdbRating;
    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episode> episodes = new ArrayList<>();

    public Serie() {
    }

    public Serie(SeriesData seriesData){
        this.title = seriesData.title();
        this.totalSeasons = seriesData.totalSeasons();
        this.imdbRating = seriesData.imdbRating() != null ? Double.valueOf(seriesData.imdbRating()) : null;
        this.poster = seriesData.poster();
        this.genre = GenreGroup.valueOf(seriesData.genre().split(",")[0].trim().toUpperCase());
        this.actors = seriesData.actors();
        this.plot = seriesData.plot();
    }


    @Override
    public String toString() {
        return "Title='" + title + '\'' +
                ", TotalSeasons=" + totalSeasons +
                ", Rating=" + imdbRating +
                ", Poster='" + poster + '\'' +
                ", Genre=" + genre +
                ", Actors='" + actors + '\'' +
                ", Plot='" + plot + '\'' +
                ", Episodes=" + episodes;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        episodes.forEach(e -> e.setSerie(this));
        this.episodes = episodes;
    }
}
