package model;

public class Merch {
    private Integer id;
    private Integer artistId;
    private String merchName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    public Merch(Integer id, Integer artistId, String merchName) {
        this.id = id;
        this.artistId = artistId;
        this.merchName = merchName;
    }
}
