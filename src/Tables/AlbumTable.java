package Tables;

import model.Album;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AlbumTable {
    JLabel name = new JLabel();
    JLabel releaseYear = new JLabel();
    JButton playButton = new JButton("select");
    JPanel bannerPanel = new JPanel();
    Integer albumId;
    ImageIcon icon = new ImageIcon();

    JLabel label = new JLabel();


    String album1 = "src/view/reputation_50x50.jpg";
    String album2 = "src/view/folklore_50x50.jpg";
    String album3 = "src/view/beautybehind_50x50.jpg";
    String album4 = "src/view/guts_50x50.jpg";
    String album5 = "src/view/The_life_of_pablo_alternate_50x50.jpg";
    String album6 ="src/view/6a4e8da0-6c3a-11ee-9f0c-a1ec7dc8d3c8_1_50x50.jpg";
    String album7 = "src/view/freewheelinbob_50x50.jpg";

    public AlbumTable(Album data){

        int imageId = data.getId();
        if(imageId == 1){
            icon = createImageIcon(album1);
        }
        else if(imageId == 2){
            icon = createImageIcon(album2);
        }
        else if(imageId == 7){
            icon = createImageIcon(album3);
        }
        else if(imageId == 4){
            icon = createImageIcon(album4);
        }
        else if(imageId == 5){
            icon = createImageIcon(album5);
        }
        else if(imageId == 6){
            icon = createImageIcon(album6);
        }
        else if(imageId == 3){
            icon = createImageIcon(album7);
        }

        albumId = data.getId();
        label.setIcon(icon);
        name.setText(data.getTitle());
        name.setPreferredSize(new Dimension(100, 50));
        releaseYear.setText(String.valueOf(data.getReleaseYear()));
        releaseYear.setPreferredSize(new Dimension(100, 50));
        playButton.setFocusable(false);
        playButton.setPreferredSize(new Dimension(60, 40));
        bannerPanel.setPreferredSize(new Dimension(400, 60));
        bannerPanel.setLayout(new GridLayout(1, 4, 10, 10));

        bannerPanel.add(label);
        bannerPanel.add(name);
        bannerPanel.add(releaseYear);
        bannerPanel.add(playButton);

    }
    private ImageIcon createImageIcon(String imagePath) {
        try {
            return new ImageIcon(ImageIO.read(new File(imagePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int getAlbumId() {
        return albumId;
    }
    public JButton getPlayButton() {
        return playButton;
    }
    public JPanel getBannerPanel() {
        return bannerPanel;
    }
}
