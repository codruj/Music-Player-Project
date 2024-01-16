package controller;
import repository.PersonRepository;
import view.LogInView;
import modelUsers.LogInModel;

import javax.swing.*;

public class LogInController
{
    private LogInModel model = new LogInModel();
    private PersonRepository repo = new PersonRepository();
    private LogInView view;
    public LogInController(){
        view = new LogInView(this);
        setView(view);
    }
    public LogInModel getModel(){return model;}
    public void setModel(LogInModel model){ this.model = model; }
    public LogInView getView(){return view;}
    public void setView(LogInView view){this.view = view;}

    public void adminButtonClicked()
    {
        view.setVisibility(false);
        AdminController adminController = new AdminController();
    }
    public void registerButtonClicked()
    {
        view.setVisibility(false);
        RegistrationController registrationController = new RegistrationController();
    }

    public boolean attemptLogIn(String username, String password)
    {
        boolean isValid = model.isValidUser(username, password);
        return isValid;
    }
    public void nextButtonClicked()
    {
        if(attemptLogIn(view.getUsername(), view.getPass()) == true){
            view.setVisibility(false);
            MainPageController mainPageController = new MainPageController();
        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong username or password", "", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void deleteClicked(){
        view.setVisibility(false);
        DeleteAccountController deleteAccountController = new DeleteAccountController();
    }
}
