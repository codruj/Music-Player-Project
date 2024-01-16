package controller;

import Tables.*;
import model.Album;
import model.Song;
import repository.ReviewRepository;
import repository.SongsRepository;
import view.AlbumView;
import view.SeeReviewsView;

import java.util.ArrayList;

public class SeeReviewsController {
    private SeeReviewsView view = null;
    private SongsRepository songsRepository = new SongsRepository();
    private ReviewRepository reviewRepository = new ReviewRepository();
    ArrayList<ReviewAlbum> albums = new ArrayList<ReviewAlbum>();
    ArrayList<ReviewSong> songs = new ArrayList<ReviewSong>();
    ArrayList<ReviewArtist> artists = new ArrayList<ReviewArtist>();
    ArrayList<SeeReviewsTable> tables = new ArrayList<SeeReviewsTable>();
    //ArrayList<SongTable> tablesSongs = new ArrayList<SongTable>();

    public SeeReviewsController() {
        view = new SeeReviewsView(this);
        setView(view);
    }
    public void displayDetails(){
        albums = reviewRepository.getReviewAlbums();
        for(ReviewAlbum reviewAlbum: albums){
            System.out.println(reviewAlbum);
            tables.add(new SeeReviewsTable(reviewAlbum, null, null));
        }
        songs = reviewRepository.getReviewSongs();
        for(ReviewSong reviewSong: songs){
            System.out.println(reviewSong);
            tables.add(new SeeReviewsTable(null, null, reviewSong));
        }
        artists = reviewRepository.getReviewArtists();
        for(ReviewArtist reviewArtist: artists){
            System.out.println(reviewArtist);
            tables.add(new SeeReviewsTable(null, reviewArtist, null));
        }
    }


    public void backButtonClicked(){
        view.setVisibility(false);
        LogInController mainPageController = new LogInController();
    }

    public SeeReviewsView getView() {
        return view;
    }

    public void setView(SeeReviewsView view) {
        this.view = view;
    }

    public ArrayList<SeeReviewsTable> getTables() {
        return tables;
    }

    public void setTables(ArrayList<SeeReviewsTable> tables) {
        this.tables = tables;
    }
}
