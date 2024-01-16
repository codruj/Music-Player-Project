package model;

public class Song {
    private Integer id;
    private String title;
    private Integer duration;
    private Integer albumId;

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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Song(Integer id, String title, Integer duration, Integer albumId) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.albumId = albumId;
    }
}
