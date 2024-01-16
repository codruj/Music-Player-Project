package controller;

import repository.AdminRepository;
import repository.SongsRepository;
import view.MainPageAdminView;
import view.MainPageView;
import view.ReviewsView;

import javax.swing.*;

public class MainPageAdminController {
    private MainPageAdminView view = null;
    private SongsRepository songsRepository = new SongsRepository();
    private AdminRepository adminRepository = new AdminRepository();

    public MainPageAdminView getView() {
        return view;
    }

    public void setView(MainPageAdminView view) {
        this.view = view;
    }


    public MainPageAdminController() {
        view = new MainPageAdminView(this);
        setView(view);
    }

    public void seeReviewsClicked(){
        view.setVisibility(false);
        SeeReviewsController seeReviewsController = new SeeReviewsController();
    }

    public void doneButtonClicked(){
        if(songsRepository.artistExists(view.getArtist()) == false)
            JOptionPane.showMessageDialog(null, "Wrong name", "", JOptionPane.WARNING_MESSAGE);
        else
        {
            int ok = adminRepository.updateGenre(view.getArtist(), view.getGenre());
            if(ok == 1){
                JOptionPane.showMessageDialog(null, "Thank you!", "", JOptionPane.INFORMATION_MESSAGE);
                view.setVisibility(false);
                MainPageAdminController mainPageAdminController = new MainPageAdminController();
            }
            else JOptionPane.showMessageDialog(null, "Something didn't work well. Try again!", "", JOptionPane.WARNING_MESSAGE);

        }
    }

    public void logOutButtonClicked(){
        view.setVisibility(false);
        LogInController logInController = new LogInController();
    }
}
