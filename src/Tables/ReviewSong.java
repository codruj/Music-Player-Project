package Tables;

public class ReviewSong {
    Integer reviewId;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public ReviewSong(Integer reviewId, Integer songId, String review) {
        this.reviewId = reviewId;
        this.songId = songId;
        this.review = review;
    }

    Integer songId;
    String review;
}
