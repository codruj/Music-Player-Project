package view;

import Tables.AlbumTable;
import controller.ArtistController;
import controller.LikedSongsController;
import model.Artist;
import repository.ReviewRepository;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ArtistView {
    JLabel titleLabel = new JLabel();
    JFrame frame = new JFrame("Spotify Wannabe");
    JButton backButton = new JButton("Back to menu");
    ReviewRepository repo = new ReviewRepository();
    ArrayList<JPanel> songPanels;

    JPanel panel1 = new JPanel();
    JPanel panelAux = new JPanel();
    JScrollPane scrollPane;
    Artist artist = new Artist(0, null, null);
    String genres = null;
    public ArtistView(ArtistController controller){

        //controller.setView(this);

        controller.displayDetails();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 350));
        frame.setLayout(new BorderLayout());
        artist = repo.getArtist(controller.getSearch());
        genres = artist.getGenres();
        titleLabel.setText(controller.getSearch()+" genres: " + genres);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(150, 30));

        frame.add(titleLabel, BorderLayout.NORTH);

        scrollPane = new JScrollPane(panelAux);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));

        for(AlbumTable ab : controller.getTables()){
            panelAux.add(ab.getBannerPanel());
        }
        frame.add(scrollPane, BorderLayout.CENTER);

        panel1.add(backButton);
        frame.add(panel1, BorderLayout.SOUTH);

        frame.setVisible(true);

        backButton.addActionListener(e -> controller.backButtonClicked());

        for(int i = 0; i<controller.getTables().size(); i++){
            final int no = i;
            controller.getTables().get(i).getPlayButton().addActionListener(e -> controller.goToAlbum(no));
        }

    }
    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }
}
