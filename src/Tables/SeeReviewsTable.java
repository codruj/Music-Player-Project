package Tables;

import model.Album;
import model.Artist;
import model.Song;
import repository.ReviewRepository;
import repository.SongsRepository;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SeeReviewsTable {
    JLabel name = new JLabel();
    JLabel releaseYear = new JLabel();
    JLabel artistLabel = new JLabel();
    JLabel reviewAlbumLabel = new JLabel();
    JLabel reviewArtistLabel = new JLabel();
    JLabel reviewSongLabel = new JLabel();
    JPanel bannerPanel = new JPanel();
    Integer albumId;
    Integer artistId;
    Integer songId;
    JLabel songTitle = new JLabel();
    JLabel duration = new JLabel();
    JLabel albumSong = new JLabel();
    JLabel artistName = new JLabel();
    JLabel genres = new JLabel();
    JLabel newLabel = new JLabel();
    Album album = new Album(0,null, 0, 0);
    Song song = new Song(0, null, 0,0);
    Artist artist = new Artist(0,null, null);
    ReviewRepository repo = new ReviewRepository();
    public SeeReviewsTable(ReviewAlbum reviewAlbum, ReviewArtist reviewArtist, ReviewSong reviewSong){

        if(reviewArtist == null && reviewSong == null){
            albumId = reviewAlbum.getAlbumId();
            name.setText(repo.getAlbumById(albumId).getTitle());
            name.setPreferredSize(new Dimension(100, 50));
            releaseYear.setText(String.valueOf(repo.getAlbumById(albumId).getReleaseYear()));
            releaseYear.setPreferredSize(new Dimension(100, 50));
            artistLabel.setText(String.valueOf(repo.getArtistById(repo.getAlbumById(albumId).getArtistId()).getName()));
            artistLabel.setPreferredSize(new Dimension(100, 50));
            reviewAlbumLabel.setText(reviewAlbum.getReview());
            reviewAlbumLabel.setPreferredSize(new Dimension(100, 50));
            bannerPanel.setPreferredSize(new Dimension(400, 60));
            bannerPanel.setLayout(new GridLayout(1, 4, 10, 10));

            bannerPanel.add(name);
            bannerPanel.add(releaseYear);
            bannerPanel.add(artistLabel);
            bannerPanel.add(reviewAlbumLabel);
        }
        else
            if(reviewAlbum == null && reviewSong == null){
                artistId = reviewArtist.getArtistId();
                artistName.setText(repo.getArtistById(artistId).getName());
                artistName.setPreferredSize(new Dimension(100, 50));
                genres.setText(repo.getArtistById(artistId).getGenres());
                genres.setPreferredSize(new Dimension(100, 50));
                newLabel.setPreferredSize(new Dimension(100, 50));
                reviewArtistLabel.setText(reviewArtist.getReview());
                reviewArtistLabel.setPreferredSize(new Dimension(100, 50));
                bannerPanel.setPreferredSize(new Dimension(400, 60));
                bannerPanel.setLayout(new GridLayout(1, 4, 10, 10));

                bannerPanel.add(artistName);
                bannerPanel.add(genres);
                bannerPanel.add(newLabel);
                bannerPanel.add(reviewArtistLabel);
            }
            else{
                songId = reviewSong.getSongId();
                songTitle.setText(repo.getSongById(songId).getTitle());
                songTitle.setPreferredSize(new Dimension(100, 50));
                duration.setText(String.valueOf(repo.getSongById(songId).getDuration()));
                duration.setPreferredSize(new Dimension(100, 50));
                albumSong.setText(repo.getAlbumById(repo.getSongById(songId).getAlbumId()).getTitle());
                albumSong.setPreferredSize(new Dimension(100, 50));
                reviewSongLabel.setText(reviewSong.getReview());
                reviewSongLabel.setPreferredSize(new Dimension(100, 50));
                bannerPanel.setPreferredSize(new Dimension(400, 60));
                bannerPanel.setLayout(new GridLayout(1, 4, 10, 10));

                bannerPanel.add(songTitle);
                bannerPanel.add(duration);
                bannerPanel.add(albumSong);
                bannerPanel.add(reviewSongLabel);

            }

    }

    public int getAlbumId() {
        return albumId;
    }
    public JPanel getBannerPanel() {
        return bannerPanel;
    }
}
