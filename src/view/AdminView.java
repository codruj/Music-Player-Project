package view;
import controller.AdminController;
import controller.LogInController;

import javax.swing.*;
import java.awt.*;
public class AdminView {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel0 = new JPanel();
    JLabel adminLabel = new JLabel("ADMIN");
    JLabel passLabel = new JLabel("Write the admin password to log in");
    JPasswordField passwordField = new JPasswordField();
    JButton nextButton = new JButton("Next");
    JButton backButton = new JButton("<--");

    JFrame frame = new JFrame("Spotify Wannabe");

    public AdminView(AdminController controller) {
        //controller.setView(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        passwordField.setPreferredSize(new Dimension(100, 20));

        backButton.addActionListener(e -> controller.backButtonClicked());
        nextButton.addActionListener(e -> controller.nextAdminClicked());
        panel0.add(backButton);
        panel1.add(adminLabel);
        panel1.add(passLabel);
        panel1.add(passwordField);

        panel2.add(nextButton);

        JPanel panel = new JPanel();
        panel.add(panel0);
        panel.add(panel1);
        panel.add(panel2);


        frame.setContentPane(panel);
        frame.setVisible(true);

    }
    public String getPassword() {
        return passwordField.getText();
    }

    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
