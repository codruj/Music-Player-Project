package controller;

import repository.SongsRepository;
import view.ReviewsView;

import javax.swing.*;

public class ReviewsController {
    private ReviewsView view = null;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReviewsController(){
        view = new ReviewsView(this);
        setView(view);
    }

    public ReviewsView getView() {
        return view;
    }

    public void setView(ReviewsView view) {
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

    public void rateButtonClicked()
    {
        if(repository.songExists(view.getSearch()) == 0)
            JOptionPane.showMessageDialog(null, "Name does not exist :(", "", JOptionPane.WARNING_MESSAGE);
        else{
            StarRateController starRateController = new StarRateController(view.getSearch());
            view.setVisibility(false);
        }
    }
    public void logOutButtonClicked(){
        view.setVisibility(false);
        LogInController logInController = new LogInController();
    }
    public void backButtonClicked(){
        view.setVisibility(false);
        MainPageController mainPageController = new MainPageController();
    }
}
