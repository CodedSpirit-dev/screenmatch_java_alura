package com.aluracursos.screenmatch.controller;

import com.aluracursos.screenmatch.dto.EpisodeDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.repository.SerieRepository;
import com.aluracursos.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieService service;

    @GetMapping("")
    public List<SerieDTO> getAllSeries() {
        return service.getAllSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> getTop5Series() {
        return service.getTop5Series();
    }

    @GetMapping("/lanzamientos")
    public List<SerieDTO> mostRecentEpisodes() {
        return service.mostRecentEpisodes();
    }

    @GetMapping("/{id}")
    public SerieDTO getSeriesById(@PathVariable Long id) {
        return service.getSeriesById(id);
    }

    @GetMapping("/{id}/temporadas/")
    public List<Integer> getSeasons(@PathVariable Long id){
        return service.getSeasons(id);
    }

    @GetMapping("/{id}/temporadas/todas")
        public List<EpisodeDTO> getAllSeasons(@PathVariable Long id){
        return service.getAllSeasons(id);
    }

    @GetMapping("/{id}/temporadas/{season}")
    public List<EpisodeDTO> getSeason(@PathVariable Long id, @PathVariable Integer season){
        return service.getSeason(id, season);
    }

    @GetMapping("/categoria/{genre}")
    public List<SerieDTO> getSeriesByGenre(@PathVariable String genre){
        return service.getSeriesByGenre(genre);
    }

}
