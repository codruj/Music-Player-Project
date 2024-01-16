package controller;
import view.RegistrationView;
import modelUsers.RegistrationModel;
import repository.PersonRepository;

import javax.swing.*;

public class RegistrationController {
    private PersonRepository repository = new PersonRepository();
    private RegistrationView view;
    public RegistrationController(){
        view = new RegistrationView(this);
        setView(view);
    }
    private RegistrationModel model;
    public RegistrationModel getModel(){return model;}
    public void setModel(RegistrationModel model){this.model = model;}
    public RegistrationView getView(){return view;}
    public void setView(RegistrationView view){this.view = view;}

    public void finishRegisteringClicked(){
        System.out.println("maricica");
        boolean verif = repository.isUniqueUser(view.getUsername());
        if(verif == false)
            JOptionPane.showMessageDialog(null, "Username already exists :(", "", JOptionPane.WARNING_MESSAGE);
        else{
            System.out.println("paulabaciu");
            repository.insertUser(view.getUsername(),view.getPass(),view.getFirstName(),view.getLastName());
            JOptionPane.showMessageDialog(null, "Successfully registered!", "", JOptionPane.INFORMATION_MESSAGE);
            view.setVisibility(false);
            LogInController mainPageController = new LogInController();
        }
    }
    public void backButtonClicked(){
        view.setVisibility(false);
        LogInController logInController = new LogInController();
    }
}
