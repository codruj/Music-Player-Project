package Tables;

public class ReviewAlbum {
    Integer reviewId;
    Integer albumId;
    String review;

    public ReviewAlbum(Integer reviewId, Integer albumId, String review) {
        this.reviewId = reviewId;
        this.albumId = albumId;
        this.review = review;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
