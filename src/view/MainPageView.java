package view;

import controller.MainPageController;

import javax.swing.*;
import java.awt.*;
public class MainPageView extends JFrame{
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel0 = new JPanel();
    JLabel welcomeLabel = new JLabel("Welcome");
    JLabel question = new JLabel("What do you want to listen to?");
    JTextField searchBarField = new JTextField();
    ImageIcon icon = new ImageIcon("src/view/searchbar.jpg");
    JButton searchButton = new JButton();
    JButton likedSongsButton = new JButton("Liked songs");
    JButton reviewsButton = new JButton("Leave a review");
    JButton merchButton = new JButton("See merch");
    JFrame frame = new JFrame("Spotify Wannabe");
    JButton logOutButton = new JButton("Log out");

    public MainPageView(MainPageController controller) {
        //controller.setView(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        searchBarField.setPreferredSize(new Dimension(100, 20));
        searchButton.setPreferredSize(new Dimension(100, 100));
        searchButton.setIcon(icon);
        searchButton.addActionListener(e -> controller.searchButtonClicked());
        merchButton.addActionListener(e -> controller.merchButtonClicked());
        reviewsButton.addActionListener(e -> controller.reviewsClicked());
        logOutButton.addActionListener(e -> controller.logOutButtonClicked());

        panel0.add(logOutButton);
        panel1.add(welcomeLabel);
        panel1.add(question);
        panel2.add(searchBarField);
        panel2.add(searchButton);
        //panel3.add(likedSongsButton);
        panel3.add(merchButton);
        panel3.add(reviewsButton);

        JPanel panel = new JPanel();
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);


        frame.setContentPane(panel);
        frame.setVisible(true);

    }
    public String getSearch() {
        return searchBarField.getText();
    }

    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
