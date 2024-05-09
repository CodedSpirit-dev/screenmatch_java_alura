package com.aluracursos.screenmatch.model;

/**
 * Enum representing the genre of a series.
 * Each genre corresponds to a string value used in the OMBD API.
 */
public enum GenreGroup {
    ACTION("Action", "Acción"),
    ADVENTURE("Adventure", "Aventura"),
    ANIMATION("Animation", "Animación"),
    BIOGRAPHY("Biography", "Biografía"),
    COMEDY("Comedy", "Comedia"),
    CRIME("Crime", "Crimen"),
    DOCUMENTARY("Documentary", "Documental"),
    DRAMA("Drama", "Drama"),
    FAMILY("Family", "Familia"),
    FANTASY("Fantasy", "Fantasía"),
    FILM_NOIR("Film-Noir", "Film-Noir"),
    GAME_SHOW("Game-Show", "Concurso"),
    HISTORY("History", "Historia"),
    HORROR("Horror", "Horror"),
    MUSIC("Music", "Música"),
    MUSICAL("Musical", "Musical"),
    MYSTERY("Mystery", "Misterio"),
    NEWS("News", "Noticias"),
    REALITY_TV("Reality-TV", "Reality-TV"),
    ROMANCE("Romance", "Romance"),
    SCIENCE_FICTION("Science-Fiction", "Ciencia-Ficción"),
    SHORT("Short", "Corto"),
    SPORT("Sport", "Deporte"),
    TALK_SHOW("Talk-Show", "Talk-Show"),
    THRILLER("Thriller", "Thriller"),
    WAR("War", "Guerra"),
    WESTERN("Western", "Western");

    // The string value of the genre used in the OMBD API
    private String genreOMBD;
    // The string value of the genre in Spanish
    private String genreSpanish;

    /**
     * Constructor for the GenreGroup enum.
     * @param genreOMBD The string value of the genre used in the OMBD API.
     * @param genreSpanish The string value of the genre in Spanish.
     */
    GenreGroup(String genreOMBD, String genreSpanish) {
        this.genreOMBD = genreOMBD;
        this.genreSpanish = genreSpanish;
    }

    /**
     * Method to get a GenreGroup from a string.
     * This method returns the GenreGroup whose string value matches the specified text.
     * @param text The string to match to a GenreGroup.
     * @return The matching GenreGroup.
     * @throws IllegalArgumentException If no matching GenreGroup is found.
     */
    public static GenreGroup fromString(String text) {
        for (GenreGroup genreGroup : GenreGroup.values()) {
            if (genreGroup.genreOMBD.equalsIgnoreCase(text)) {
                return genreGroup;
            }
        }
        throw new IllegalArgumentException("Invalid genre: " + text);
    }

    public static GenreGroup fromSpanish(String text) {
        for (GenreGroup genreGroup : GenreGroup.values()) {
            if (genreGroup.genreSpanish.equalsIgnoreCase(text)) {
                return genreGroup;
            }
        }
        throw new IllegalArgumentException("Invalid genre: " + text);
    }

}