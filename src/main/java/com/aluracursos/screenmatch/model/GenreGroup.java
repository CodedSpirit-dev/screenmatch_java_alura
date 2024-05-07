package com.aluracursos.screenmatch.model;

public enum GenreGroup {
    ACTION("Action"),
    ADVENTURE("Adventure"),
    ANIMATION("Animation"),
    BIOGRAPHY("Biography"),
    COMEDY("Comedy"),
    CRIME("Crime"),
    DOCUMENTARY("Documentary"),
    DRAMA("Drama"),
    FAMILY("Family"),
    FANTASY("Fantasy"),
    FILM_NOIR("Film-Noir"),
    GAME_SHOW("Game-Show"),
    HISTORY("History"),
    HORROR("Horror"),
    MUSIC("Music"),
    MUSICAL("Musical"),
    MYSTERY("Mystery"),
    NEWS("News"),
    REALITY_TV("Reality-TV"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Science-Fiction"),
    SHORT("Short"),
    SPORT("Sport"),
    TALK_SHOW("Talk-Show"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western");

    private String genreOMBD;

    GenreGroup(String genreOMBD) {
        this.genreOMBD = genreOMBD;
    }

    public static GenreGroup valueOfGenre(String text) {
        for (GenreGroup genreGroup : GenreGroup.values()) {
            if (genreGroup.genreOMBD.equalsIgnoreCase(text)) {
                return genreGroup;
            }
        }
        throw new IllegalArgumentException("Invalid genre: " + text);
    }
}
