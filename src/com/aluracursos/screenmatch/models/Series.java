package com.aluracursos.screenmatch.models;

public class Series extends Title{
    private int numberOfSeasons;
    private int numberOfEpisodesPerSeason;
    private int minutesPerEpisode;

    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }

    @Override
    public int getDurationInMinutes() {
        return minutesPerEpisode * numberOfSeasons * numberOfEpisodesPerSeason;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public int getNumberOfEpisodesPerSeason() {
        return numberOfEpisodesPerSeason;
    }

    public void setNumberOfEpisodesPerSeason(int numberOfEpisodesPerSeason) {
        this.numberOfEpisodesPerSeason = numberOfEpisodesPerSeason;
    }

    public int getMinutesPerEpisode() {
        return minutesPerEpisode;
    }

    public void setMinutesPerEpisode(int minutesPerEpisode) {
        this.minutesPerEpisode = minutesPerEpisode;
    }
}
