package model;

public class likedSongs {
    private Integer userId;
    private Integer songId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public likedSongs(Integer userId, Integer songId) {
        this.userId = userId;
        this.songId = songId;
    }
}
