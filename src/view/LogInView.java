package view;

import controller.LogInController;

import javax.swing.*;
import java.awt.*;
public class LogInView{ //extends JPanel
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JButton adminButton = new JButton("Admin");
    JLabel logInLabel = new JLabel("LOG IN");
    JTextField usernameField = new JTextField("username");
    JPasswordField passwordField = new JPasswordField("password");
    JLabel registerLabel = new JLabel("New here?");
    JButton registerButton = new JButton("Register here!");
    JButton nextButton = new JButton("Next");
    JButton delete = new JButton("Delete account");

    JFrame frame = new JFrame("Spotify Wannabe");

    public LogInView(LogInController controller) {
        //controller.setView(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        usernameField.setPreferredSize(new Dimension(100, 20));


        passwordField.setPreferredSize(new Dimension(100, 20));

        adminButton.addActionListener(e -> controller.adminButtonClicked());

        panel1.add(adminButton);
        panel1.add(logInLabel);
        panel1.add(usernameField);
        panel1.add(passwordField);


        registerButton.addActionListener(e -> controller.registerButtonClicked());

        panel2.add(registerLabel);
        panel2.add(registerButton);

        nextButton.addActionListener(e -> controller.nextButtonClicked());
        panel3.add(nextButton);

        delete.addActionListener(e -> controller.deleteClicked());
        panel4.add(delete);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);

        frame.setContentPane(panel);
        frame.setVisible(true);

    }
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPass() {
        return passwordField.getText();
    }


    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
    }
}
