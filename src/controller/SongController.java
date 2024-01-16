package controller;

import view.SongView;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SongController {
private SongView view = null;
private String username = null;



    public SongController(String title) {
        view = new SongView(this,title);
        this.setView(view);
    }

    public void backButtonClicked(){
        view.stopButtonClicked();
        view.setVisibility(false);
        MainPageController mainPageController = new MainPageController();
    }

    public SongView getView() {
        return view;
    }

    public void setView(SongView view) {
        this.view = view;
    }

}
