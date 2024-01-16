package view;

import Tables.SeeReviewsTable;
import Tables.SongTable;
import controller.AlbumController;
import controller.SeeReviewsController;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeeReviewsView {

        Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        JLabel titleLabel = new JLabel("All reviews");
        JFrame frame = new JFrame("Spotify Wannabe");
        JButton backButton = new JButton("Back to menu");

        ArrayList<JPanel> songPanels;

        JPanel panel1 = new JPanel();
        JPanel panelAux = new JPanel();
        JScrollPane scrollPane;
        public SeeReviewsView(SeeReviewsController controller){

            controller.displayDetails();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(500, 350));
            frame.setLayout(new BorderLayout());

            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            backButton.setFocusable(false);
            backButton.setPreferredSize(new Dimension(150, 30));

            frame.add(titleLabel, BorderLayout.NORTH);

            scrollPane = new JScrollPane(panelAux);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.Y_AXIS));

            for(SeeReviewsTable sb : controller.getTables()){
                panelAux.add(sb.getBannerPanel());
            }
            frame.add(scrollPane, BorderLayout.CENTER);

            panel1.add(backButton);
            frame.add(panel1, BorderLayout.SOUTH);

            frame.setVisible(true);

            backButton.addActionListener(e -> controller.backButtonClicked());


        }
        public void setVisibility(boolean isVisible){
            frame.setVisible(isVisible);
        }


}
