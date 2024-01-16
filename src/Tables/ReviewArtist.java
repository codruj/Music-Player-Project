package Tables;

public class ReviewArtist {
    Integer reviewId;
    Integer artistId;
    String review;

    public ReviewArtist(Integer reviewId, Integer artistId, String review) {
        this.reviewId = reviewId;
        this.artistId = artistId;
        this.review = review;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
