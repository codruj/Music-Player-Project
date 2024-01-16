package view;

import controller.DeleteAccountController;

import javax.swing.*;
import java.awt.*;

public class DeleteAccountView {
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel0 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel deleteLabel = new JLabel("Delete your account");
    JLabel passLabel = new JLabel("Password");
    JLabel userLabel = new JLabel("Username");
    JPasswordField passwordField = new JPasswordField();
    JTextField usernameField = new JTextField();
    JButton nextButton = new JButton("Delete");
    JButton backButton = new JButton("Delete");

    JFrame frame = new JFrame("Spotify Wannabe");

    public DeleteAccountView(DeleteAccountController controller) {
        //controller.setView(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);

        usernameField.setPreferredSize(new Dimension(100, 20));
        passwordField.setPreferredSize(new Dimension(100, 20));

        backButton.addActionListener(e -> controller.backButtonClicked());
        nextButton.addActionListener(e -> controller.DeleteAccountClicked());

        panel0.add(backButton);
        panel1.add(deleteLabel);
        panel2.add(userLabel);
        panel2.add(usernameField);
        panel3.add(passLabel);
        panel3.add(passwordField);
        panel4.add(nextButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);


        frame.setContentPane(panel);
        frame.setVisible(true);

    }
    public String getPassword() {
        return passwordField.getText();
    }
    public String getUsername() {
        return usernameField.getText();
    }
    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
