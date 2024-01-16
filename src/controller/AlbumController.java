package controller;

import Tables.AlbumTable;
import Tables.SongTable;
import model.Album;
import model.Song;
import repository.ReviewRepository;
import repository.SongsRepository;
import view.AlbumView;
import view.ArtistView;
import view.SongView;

import java.util.ArrayList;

public class AlbumController {
    private AlbumView view = null;
    private String search;
    private SongsRepository songsRepository = new SongsRepository();
    private ReviewRepository reviewRepository = new ReviewRepository();

    ArrayList<Album> albums = new ArrayList<Album>();
    ArrayList<Song> songs = new ArrayList<Song>();
    ArrayList<SongTable> tables = new ArrayList<SongTable>();
    //ArrayList<SongTable> tablesSongs = new ArrayList<SongTable>();

    public AlbumController(String search) {
        this.search = search;
        view = new AlbumView(this);
        setView(view);
    }
    public void displayDetails(){
        System.out.println(this.getSearch());
        songs = songsRepository.getSongs(reviewRepository.getAlbum(this.getSearch()).getId());
        for(Song song: songs){
            System.out.println(song);
            tables.add(new SongTable(song));
        }
    }

    public void goToSong(int nr){
        int albumId = reviewRepository.getAlbum(this.getSearch()).getId();
        songs = songsRepository.getSongs(albumId);

        SongController controller = new SongController(reviewRepository.getSongById(this.getTables().get(nr).getSongId()).getTitle());

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

    public AlbumView getView() {
        return view;
    }

    public void setView(AlbumView view) {
        this.view = view;
    }

    public ArrayList<SongTable> getTables() {
        return tables;
    }

    public void setTables(ArrayList<SongTable> tables) {
        this.tables = tables;
    }
}
