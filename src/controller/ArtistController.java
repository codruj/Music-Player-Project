package controller;

import Tables.AlbumTable;
import Tables.ArtistTable;
import Tables.SongTable;
import model.Album;
import model.Song;
import repository.ReviewRepository;
import repository.SongsRepository;
import view.AlbumView;
import view.ArtistView;

import java.util.ArrayList;

public class ArtistController {
    private ArtistView view = null;
    private String search;
    private SongsRepository songsRepository = new SongsRepository();
    private ReviewRepository reviewRepository = new ReviewRepository();

    ArrayList<Album> albums = new ArrayList<Album>();
    ArrayList<Song> songs = new ArrayList<Song>();
    ArrayList<AlbumTable> tables = new ArrayList<AlbumTable>();
    ArrayList<SongTable> tablesSongs = new ArrayList<SongTable>();
    public ArtistController(String search) {
        this.search = search;
        view = new ArtistView(this);
        setView(view);
    }
    public void displayDetails(){
        System.out.println(this.getSearch());
        albums = songsRepository.getAlbums(reviewRepository.getArtist(this.getSearch()).getId());
        for(Album album: albums){
            System.out.println(album);
            tables.add(new AlbumTable(album));
        }
    }

    public void goToAlbum(int nr){
        AlbumController albumController = new AlbumController(reviewRepository.getAlbumById(this.getTables().get(nr).getAlbumId()).getTitle());
        view.setVisibility(false);
    }

    public void backButtonClicked(){
        view.setVisibility(false);
        MainPageController mainPageController = new MainPageController();
    }
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public ArtistView getView() {
        return view;
    }

    public void setView(ArtistView view) {
        this.view = view;
    }

    public ArrayList<AlbumTable> getTables() {
        return tables;
    }

    public void setTables(ArrayList<AlbumTable> tables) {
        this.tables = tables;
    }
}
