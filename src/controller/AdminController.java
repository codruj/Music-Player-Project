package controller;
import view.AdminView;
import repository.PersonRepository;
import view.MainPageView;

import javax.swing.*;

public class AdminController {
    private PersonRepository repository = new PersonRepository();
    private AdminView view;
    public AdminController(){
        view = new AdminView(this);
        setView(view);
    }
    public PersonRepository getRepository(){return repository;}
    public void setRepository(PersonRepository repository){this.repository = repository;}
    public AdminView getView(){return view;}
    public void setView(AdminView view){this.view = view;}
    public boolean attemptAdmin(String password)
    {
        boolean isValid = repository.isValidAdmin(password);
        return isValid;
    }

    public void backButtonClicked(){
        view.setVisibility(false);
        LogInController logInController = new LogInController();
    }
    public void nextAdminClicked()
    {
        if(attemptAdmin(view.getPassword()) == true){
            MainPageAdminController mainPageAdminController = new MainPageAdminController();
            view.setVisibility(false);

        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong password", "", JOptionPane.WARNING_MESSAGE);
        }
    }

}
