package com.aluracursos.screenmatch.dto;


import com.aluracursos.screenmatch.model.GenreGroup;


public record SerieDTO (
        String title,
        Integer totalSeasons,
        String poster,
        GenreGroup genre,
        String actors,
        String plot,
        Double imdbRating
) {
}
