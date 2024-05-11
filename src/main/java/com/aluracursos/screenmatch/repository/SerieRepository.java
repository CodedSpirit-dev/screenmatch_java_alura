package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.model.Episode;
import com.aluracursos.screenmatch.model.GenreGroup;
import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for the Serie entity.
 * This interface extends JpaRepository and provides methods for performing CRUD operations on the Serie entity.
 */
public interface SerieRepository extends JpaRepository<Serie, Long>{

    /**
     * Method to find a Serie by title.
     * This method performs a case-insensitive search for a Serie with a title that contains the specified string.
     * @param title The string to search for in the Serie titles.
     * @return An Optional that contains the found Serie, or an empty Optional if no Serie was found.
     */
    Optional<Serie> findByTitleContainsIgnoreCase(String title);

    /**
     * Method to find the top 5 Series by IMDb rating.
     * This method returns a list of the top 5 Series ordered by IMDb rating in descending order.
     * @return A List of the top 5 Series by IMDb rating.
     */
    List<Serie> findTop5ByOrderByImdbRatingDesc();

    /**
     * Method to find Series by genre.
     * This method returns a list of Series that belong to the specified genre.
     * @param genre The genre to search for in the Series.
     * @return A List of Series that belong to the specified genre.
     */
    List<Serie> findByGenre(GenreGroup genre);

    @Query(value = "SELECT s FROM Serie s WHERE s.totalSeasons <= :totalSeasons AND s.imdbRating >= :imdbRating")
    List<Serie> findSeriesBySeasonAndImdbRating(int totalSeasons, double imdbRating);


    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE e.title ILIKE %:episodeName%")
    List<Episode> episodesByName(String episodeName);

    @Query ("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie ORDER BY e.imbdRating DESC LIMIT 5")
    List<Episode> top5Episodes(Serie serie);
}