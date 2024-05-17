package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.EpisodeDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.GenreGroup;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> getAllSeries() {
        return convertDataDTO(repository.findAll());
    }

    public List<SerieDTO> mostRecentEpisodes() {
        return convertDataDTO(repository.mostRecentEpisodes());
    }

    public List<SerieDTO> getTop5Series()
    {
        return convertDataDTO(repository.findTop5ByOrderByImdbRatingDesc());
    }

    public List<SerieDTO> convertDataDTO(List<Serie> serie) {
        return serie.stream()
                .map(s -> new SerieDTO(
                        s.getId(),
                        s.getTitle(),
                        s.getTotalSeasons(),
                        s.getPoster(),
                        s.getGenre(),
                        s.getActors(),
                        s.getPlot(),
                        s.getImdbRating()
                ))
                .collect(Collectors.toList());
    }

    public SerieDTO getSeriesById(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()) {
            Serie s = serie.get();
            return new SerieDTO(
                    s.getId(),
                    s.getTitle(),
                    s.getTotalSeasons(),
                    s.getPoster(),
                    s.getGenre(),
                    s.getActors(),
                    s.getPlot(),
                    s.getImdbRating()
            );
        } else {
            return null;
        }
    }

    public List<EpisodeDTO> getAllSeasons(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if(serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodes().stream()
                    .map(e -> new EpisodeDTO(e.getSeason(), e.getTitle(), e.getEpisodeNumber(), "Description not available", 0.0))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public List<EpisodeDTO> getSeason(Long id, Integer seasonNumber) {
        return repository.getSeasonByNumber(id, seasonNumber).stream()
                .map(e -> new EpisodeDTO(e.getSeason(), e.getTitle(), e.getEpisodeNumber(), "Description not available", 0.0))
                .collect(Collectors.toList());
    }

    public List<Integer> getSeasons(Long id) {
        return repository.getSeasons(id);
    }

    public List<SerieDTO> getSeriesByGenre(String genre) {
        GenreGroup genreGroup = GenreGroup.fromSpanish(genre);
        return convertDataDTO(repository.findByGenre(genreGroup));
    }
}
