package view;

import controller.MainPageController;
import controller.RegistrationController;
import controller.ReviewsController;

import javax.swing.*;
import java.awt.*;

public class ReviewsView {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel0 = new JPanel();
    JLabel welcomeLabel = new JLabel("Leave a review for:");
    JTextField searchBarField = new JTextField();
    JButton rateButton = new JButton("Go to rating");
    JButton logOutButton = new JButton("Log out");
    JButton backButton = new JButton("<--");
    JFrame frame = new JFrame("Spotify Wannabe");

    public ReviewsView(ReviewsController controller) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        searchBarField.setPreferredSize(new Dimension(100, 20));
        rateButton.addActionListener(e -> controller.rateButtonClicked());
        logOutButton.addActionListener(e -> controller.logOutButtonClicked());
        backButton.addActionListener(e -> controller.backButtonClicked());

        panel0.add(backButton);
        panel0.add(logOutButton);
        panel1.add(welcomeLabel);
        panel2.add(searchBarField);
        panel2.add(rateButton);

        JPanel panel = new JPanel();
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);


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
