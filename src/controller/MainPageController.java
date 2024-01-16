package controller;

import view.MainPageView;
import repository.SongsRepository;
import javax.swing.*;

public class MainPageController {
    private MainPageView view = null;
    private String username = null;

    public MainPageController(){
        view = new MainPageView(this);
        setView(view);
    }

    public MainPageView getView() {
        return view;
    }

    public void setView(MainPageView view) {
        this.view = view;
    }

    private SongsRepository repository = new SongsRepository();
    public SongsRepository getRepository() {
        return repository;
    }

    public void setRepository(SongsRepository repository) {
        this.repository = repository;
    }

    public int searchSong(String title)
    {
        int isValid = repository.songExists(title);
        return isValid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void searchButtonClicked()
    {
            String name = getView().getSearch();
            if(searchSong(name)==0)
                JOptionPane.showMessageDialog(null, "Wrong name", "", JOptionPane.WARNING_MESSAGE);
            else if(searchSong(name)==1) {
                AlbumController songController = new AlbumController(name);
                view.setVisibility(false);
            }
            else if(searchSong(name)==2) {
                SongController songController = new SongController(name);
                view.setVisibility(false);
            }
            else if(searchSong(name)==3) {

                System.out.println(name);
                ArtistController artistController = new ArtistController(name);
                view.setVisibility(false);

            }

    }

    public void logOutButtonClicked(){
        view.setVisibility(false);
        LogInController logInController = new LogInController();
    }
    public void likedSongsClicked()
    {
        view.setVisibility(false);
        LikedSongsController likedSongsController = new LikedSongsController();
    }

    public void merchButtonClicked()
    {
        view.setVisibility(false);
        MerchController merchController = new MerchController();

    }

    public void reviewsClicked()
    {
        view.setVisibility(false);
        String text = null;
        ReviewsController mainPageController = new ReviewsController();

    }
}
