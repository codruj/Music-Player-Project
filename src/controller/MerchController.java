package controller;

import Tables.MerchTable;
import Tables.SongTable;
import model.Album;
import model.Merch;
import model.Song;
import repository.MerchRepository;
import repository.ReviewRepository;
import repository.SongsRepository;
import view.AlbumView;
import view.MerchView;

import java.util.ArrayList;

public class MerchController {
    private MerchView view = null;
    private MerchRepository repo = new MerchRepository();
    private ReviewRepository reviewRepository = new ReviewRepository();

    ArrayList<Merch> products = new ArrayList<Merch>();
    ArrayList<MerchTable> tables = new ArrayList<MerchTable>();
    //ArrayList<SongTable> tablesSongs = new ArrayList<SongTable>();

    public MerchController() {
        view = new MerchView(this);
        setView(view);
    }
    public void displayDetails(){
        products = repo.getMerchProducts();
        for(Merch product: products){
            System.out.println(product);
            tables.add(new MerchTable(product));
        }
    }


    public void backButtonClicked(){
        view.setVisibility(false);
        MainPageController mainPageController = new MainPageController();
    }

    public MerchView getView() {
        return view;
    }

    public void setView(MerchView view) {
        this.view = view;
    }

    public ArrayList<MerchTable> getTables() {
        return tables;
    }

    public void setTables(ArrayList<MerchTable> tables) {
        this.tables = tables;
    }
}
