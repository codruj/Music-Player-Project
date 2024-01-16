package Tables;

import model.Album;
import model.Artist;
import model.Merch;
import model.Song;
import repository.MerchRepository;
import repository.ReviewRepository;

import javax.swing.*;
import java.awt.*;

public class MerchTable {
    JLabel name = new JLabel();
    JLabel artist = new JLabel();
    Integer artistId;
    Integer merchId;
    ReviewRepository repo = new ReviewRepository();

    JPanel bannerPanel = new JPanel();
    public MerchTable(Merch data){

            merchId = data.getId();
            artistId = data.getArtistId();
            name.setText(data.getMerchName());
            name.setPreferredSize(new Dimension(100, 50));
            artist.setText(repo.getArtistById(data.getArtistId()).getName());
            artist.setPreferredSize(new Dimension(100, 50));
            bannerPanel.setPreferredSize(new Dimension(400, 60));
            bannerPanel.setLayout(new GridLayout(1, 2, 10, 10));

            bannerPanel.add(name);
            bannerPanel.add(artist);


    }

    public int getArtistId() {
        return artistId;
    }
    public JPanel getBannerPanel() {
        return bannerPanel;
    }
}
