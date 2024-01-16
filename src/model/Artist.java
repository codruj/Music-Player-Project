package model;

public class Artist {
    private Integer id;
    private String name;
    private String genres;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Artist(Integer id, String name, String genres) {
        this.id = id;
        this.name = name;
        this.genres = genres;
    }
}
