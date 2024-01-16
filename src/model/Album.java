package model;

public class Album {
    private Integer id;
    private String title;
    private Integer releaseYear;
    private Integer artistId;

    public Album(Integer id, String title, Integer releaseYear, Integer artistId) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.artistId = artistId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }
}
