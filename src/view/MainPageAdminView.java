package view;

import controller.MainPageAdminController;
import controller.ReviewsController;

import javax.swing.*;
import java.awt.*;

public class MainPageAdminView {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel0 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel("Choose the artist");
    JTextField artist = new JTextField();
    JLabel label2 = new JLabel("Add a new genre for them");
    JTextField genre = new JTextField();
    JButton doneButton = new JButton("Done");
    JButton seeReviewsButton = new JButton("See reviews");
    JButton logOutButton = new JButton("Log out");
    JFrame frame = new JFrame("Spotify Wannabe");

    public MainPageAdminView(MainPageAdminController controller) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);

        artist.setPreferredSize(new Dimension(100, 20));
        genre.setPreferredSize(new Dimension(100, 20));
        logOutButton.addActionListener(e -> controller.logOutButtonClicked());
        doneButton.addActionListener(e -> controller.doneButtonClicked());
        seeReviewsButton.addActionListener(e -> controller.seeReviewsClicked());

        panel0.add(logOutButton);
        panel1.add(label1);
        panel1.add(artist);
        panel2.add(label2);
        panel2.add(genre);
        panel3.add(doneButton);
        panel3.add(seeReviewsButton);

        JPanel panel = new JPanel();
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        frame.setContentPane(panel);
        frame.setVisible(true);

    }
    public String getArtist() {
        return artist.getText();
    }
    public String getGenre() {
        return genre.getText();
    }

    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
