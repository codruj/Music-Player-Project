package controller;

import repository.ReviewRepository;
import repository.SongsRepository;
import view.ReviewsView;
import view.StarRateView;

import javax.swing.*;

public class StarRateController {
    private StarRateView view = null;
    private String text;


    public StarRateController(String text){

        this.text = text;
        view = new StarRateView(this, text);
        setView(view);
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    private ReviewRepository repo = new ReviewRepository();
    private SongsRepository songsRepo = new SongsRepository();
    public void nextStarRateClicked(){
            Integer id = null;
            if (songsRepo.songExists(this.getText()) == 1) {
                id = repo.getAlbum(this.getText()).getId();
            }
            else if (songsRepo.songExists(this.getText()) == 2) {
                id = repo.getSong(this.getText()).getId();
            }
            else if (songsRepo.songExists(this.getText()) == 3) {
                id = repo.getArtist(this.getText()).getId();
            }




            if(repo.insertReview(id, view.getPassword(), this.getText())==1)
            {
                JOptionPane.showMessageDialog(null, "Review left", "", JOptionPane.INFORMATION_MESSAGE);
                view.setVisibility(false);
                MainPageController mainPageController = new MainPageController();
            }
            else JOptionPane.showMessageDialog(null, "Something didn't work well. Try again!", "", JOptionPane.WARNING_MESSAGE);

    }

    public void logOutButtonClicked(){
        view.setVisibility(false);
        LogInController logInController = new LogInController();
    }
    public void backButtonClicked(){
        view.setVisibility(false);
        ReviewsController reviewsController = new ReviewsController();
    }
    public StarRateView getView() {
        return view;
    }

    public void setView(StarRateView view) {
        this.view = view;
    }
}
