package view;

import controller.AdminController;

import javax.swing.*;
import java.awt.*;

import controller.StarRateController;
import view.ReviewsView;
import controller.ReviewsController;
public class StarRateView {

    ReviewsController reviewsController = new ReviewsController();
    ReviewsView reviewsView = new ReviewsView(reviewsController);
    String init;
    String name;
    String title;
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel0 = new JPanel();
    JLabel reviewLabel = new JLabel();
    JTextField review = new JTextField();
    JButton nextButton = new JButton("Next");
    JButton logOutButton = new JButton("Log out");
    JButton backButton = new JButton("<--");
    JFrame frame = new JFrame("Spotify Wannabe");
    public StarRateView(StarRateController controller, String text) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        review.setPreferredSize(new Dimension(100, 50));


        nextButton.addActionListener(e -> controller.nextStarRateClicked());
        logOutButton.addActionListener(e -> controller.logOutButtonClicked());
        backButton.addActionListener(e -> controller.backButtonClicked());
        init = "Write here your opinion on: ";
        title = init + text;
        reviewLabel.setText(title);
        panel0.add(backButton);
        panel0.add(logOutButton);
        panel1.add(reviewLabel);
        panel1.add(review);

        panel2.add(nextButton);

        JPanel panel = new JPanel();
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);


        frame.setContentPane(panel);
        frame.setVisible(true);

    }
    public String getPassword() {
        return review.getText();
    }

    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
