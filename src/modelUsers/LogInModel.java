package modelUsers;

import java.sql.*;

import controller.LogInController;

public class LogInModel {

    private LogInModel model;
    private LogInController controller;
    public LogInModel getModel(){return model;}
    public void setModel(LogInModel model){ this.model = model; }
    public LogInController getController(){return controller;}
    public void setController(LogInController controller){this.controller = controller;}

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Integer rowsAffected = 0;
    String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
    String dbUsername = "postgres";
    String dbPassword = "postgres";
    public LogInModel(){

        try{
            connection = DriverManager.getConnection(url,dbUsername, dbPassword);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public boolean isValidUser(String enteredUsername, String enteredPassword)
    {
        String query = "SELECT username, passwordd from users where username = ? AND passwordd = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
