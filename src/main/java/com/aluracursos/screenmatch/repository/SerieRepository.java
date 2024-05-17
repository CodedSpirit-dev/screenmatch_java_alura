package com.aluracursos.screenmatch.repository;

import com.aluracursos.screenmatch.dto.EpisodeDTO;
import com.aluracursos.screenmatch.model.Episode;
import com.aluracursos.screenmatch.model.GenreGroup;
import com.aluracursos.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Serie} entities.
 * Extends {@link JpaRepository} to provide standard CRUD operations.
 * Includes custom queries for searching series by title, genre, rating, and episodes by name.
 */
public interface SerieRepository extends JpaRepository<Serie, Long>{

    /**
     * Finds a series by its title containing the specified string, ignoring case.
     *
     * @param title The string to search for within the series titles.
     * @return An {@link Optional} containing the found series if present; otherwise, an empty {@link Optional}.
     */
    Optional<Serie> findByTitleContainsIgnoreCase(String title);

    /**
     * Retrieves the top 5 series ordered by IMDb rating in descending order.
     *
     * @return A list of the top 5 series based on IMDb rating.
     */
    List<Serie> findTop5ByOrderByImdbRatingDesc();

    /**
     * Finds series belonging to a specified genre.
     *
     * @param genre The {@link GenreGroup} to filter the series by.
     * @return A list of series that belong to the specified genre.
     */
    List<Serie> findByGenre(GenreGroup genre);


    /**
     * Custom query to find series with a total number of seasons less than or equal to a specified value
     * and an IMDb rating greater than or equal to a specified value.
     *
     * @param totalSeasons The maximum number of seasons.
     * @param imdbRating The minimum IMDb rating.
     * @return A list of series meeting the criteria.
     */
    @Query(value = "SELECT s FROM Serie s WHERE s.totalSeasons <= :totalSeasons AND s.imdbRating >= :imdbRating")
    List<Serie> findSeriesBySeasonAndImdbRating(int totalSeasons, double imdbRating);

    /**
     * Custom query to find episodes by name, using a case-insensitive search.
     *
     * @param episodeName The name or partial name of the episode to search for.
     * @return A list of episodes matching the search criteria.
     */
    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE e.title ILIKE %:episodeName%")
    List<Episode> episodesByName(String episodeName);

    /**
     * Custom query to retrieve the top 5 episodes of a series, ordered by IMDb rating in descending order.
     * Note: This method uses a JPQL query that incorrectly includes the SQL 'LIMIT' clause, which is not supported in JPQL.
     *
     * @param serie The series to find top episodes for.
     * @return A list of the top 5 episodes for the specified series.
     */
    @Query ("SELECT e FROM Serie s JOIN s.episodes e WHERE s = :serie ORDER BY e.imbdRating DESC LIMIT 5")
    List<Episode> top5Episodes(Serie serie);

    /**
     * Custom query to retrieve the most recent episodes of all series, ordered by launch date in descending order.
     *
     * @return A list of the most recent episodes of all series.
     */
    @Query("SELECT s FROM Serie s " + "JOIN s.episodes e " + "GROUP BY s " + "ORDER BY MAX(e.launchDate) DESC LIMIT 5")
    List<Serie> mostRecentEpisodes();

    /**
     * Retrieves all episodes of a series by its ID.
     *
     * @param id The ID of the series to retrieve episodes for.
     * @return A list of {@link EpisodeDTO} objects representing the episodes of the series.
     */
    @Query("SELECT e FROM Serie s JOIN s.episodes e WHERE s.Id = :id AND e.season = :seasonNumber")
    List<Episode> getSeasonByNumber(Long id, Integer seasonNumber);

    /**
     * Retrieves all seasons of a series by its ID.
     *
     * @param id The ID of the series to retrieve seasons for.
     * @return A list of season numbers for the series.
     */
    @Query("SELECT DISTINCT e.season FROM Serie s JOIN s.episodes e WHERE s.Id = :id")
    List<Integer> getSeasons(Long id);
}