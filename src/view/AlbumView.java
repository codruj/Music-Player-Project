package view;

import Tables.AlbumTable;
import Tables.SongTable;
import controller.AlbumController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlbumView {
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    JLabel titleLabel = new JLabel();
    JFrame frame = new JFrame("Spotify Wannabe");
    JButton backButton = new JButton("Back to menu");

    ArrayList<JPanel> songPanels;

    JPanel panel1 = new JPanel();
    JPanel panelAux = new JPanel();
    JScrollPane scrollPane;
    public AlbumView(AlbumController controller){

        controller.displayDetails();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 350));
        frame.setLayout(new BorderLayout());

        titleLabel.setText(controller.getSearch());
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        backButton.setFocusable(false);
        backButton.setPreferredSize(new Dimension(150, 30));

        frame.add(titleLabel, BorderLayout.NORTH);

        scrollPane = new JScrollPane(panelAux);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));

        for(SongTable sb : controller.getTables()){
            panelAux.add(sb.getBannerPanel());
        }
        frame.add(scrollPane, BorderLayout.CENTER);

        panel1.add(backButton);
        frame.add(panel1, BorderLayout.SOUTH);

        frame.setVisible(true);

        backButton.addActionListener(e -> controller.backButtonClicked());

        for(int i = 0; i<controller.getTables().size(); i++){
            final int no = i;
            controller.getTables().get(i).getPlayButton().addActionListener(e -> controller.goToSong(no));
        }

    }
    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

}
