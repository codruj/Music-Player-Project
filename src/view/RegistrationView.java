package view;
import controller.LogInController;
import controller.RegistrationController;

import javax.swing.*;
import java.awt.*;
public class RegistrationView extends JPanel{
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel0 = new JPanel();
    JLabel RegisterLabel = new JLabel("Registration");
    JTextField firstNameField = new JTextField("First name");
    JTextField lastNameField = new JTextField("Last Name");
    JTextField usernameField = new JTextField("Username");
    JPasswordField passwordField = new JPasswordField("Password");
    JButton doneRegisteringButton = new JButton("Complete registering");
    JButton backButton = new JButton("<--");

    JFrame frame = new JFrame("Spotify Wannabe");

    public RegistrationView(RegistrationController controller) {
        //controller.setView(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);


        usernameField.setPreferredSize(new Dimension(100, 20));


        passwordField.setPreferredSize(new Dimension(100, 20));

        backButton.addActionListener(e -> controller.backButtonClicked());
        panel0.add(backButton);
        panel1.add(RegisterLabel);
        panel1.add(firstNameField);
        panel1.add(lastNameField);
        panel1.add(usernameField);
        panel1.add(passwordField);


        doneRegisteringButton.addActionListener(e -> controller.finishRegisteringClicked());

        panel2.add(doneRegisteringButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);

        frame.setContentPane(panel);
        frame.setVisible(true);

    }
    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
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
