package com.aluracursos.screenmatch.dto;


import com.aluracursos.screenmatch.model.GenreGroup;


public record SerieDTO (
        Long id,
        String title,
        Integer totalSeasons,
        String poster,
        GenreGroup genre,
        String actors,
        String plot,
        Double imdbRating
) {
}
