package controller;

import repository.PersonRepository;
import view.DeleteAccountView;

import javax.swing.*;

public class DeleteAccountController {

    PersonRepository repo = new PersonRepository();
    DeleteAccountView view = null;

    public DeleteAccountController() {
        this.view = new DeleteAccountView(this);
    }

    public void DeleteAccountClicked(){
        if(repo.deleteUser(getView().getUsername(), getView().getPassword()) == 1){
            JOptionPane.showMessageDialog(null, "Account successfully deleted", "", JOptionPane.INFORMATION_MESSAGE);
            view.setVisibility(false);
            LogInController logInController = new LogInController();
        }
        else if(repo.deleteUser(getView().getUsername(), getView().getPassword()) == -1){
            JOptionPane.showMessageDialog(null, "Incorrect username or password", "", JOptionPane.WARNING_MESSAGE);
        }
        else if(repo.deleteUser(getView().getUsername(), getView().getPassword()) == 0){
            JOptionPane.showMessageDialog(null, "Something went wrong. Try again", "", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void backButtonClicked(){
        view.setVisibility(false);
        LogInController logInController = new LogInController();
    }

    public DeleteAccountView getView() {
        return view;
    }

    public void setView(DeleteAccountView view) {
        this.view = view;
    }
}
