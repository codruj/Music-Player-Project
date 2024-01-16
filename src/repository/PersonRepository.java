package repository;

import java.sql.*;
public class PersonRepository {

    public boolean ok = false;

    public boolean isUniqueUser(String enteredUsername) { ///REGISTRATION FUNCTION
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
            String dbUsername = "postgres";
            String dbPassword = "postgres";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);


            String query = "SELECT COUNT(*) AS user_count FROM users WHERE username = ?;";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, enteredUsername);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int userCount = resultSet.getInt("user_count");
                if(userCount > 0) ok = false;
                else ok = true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Eroare 1");
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("eroare 2");
            }
        }
        return ok;
    }
    public boolean correctUser(String enteredUsername, String enteredPass) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
            String dbUsername = "postgres";
            String dbPassword = "postgres";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);


            String query = "SELECT COUNT(*) AS user_count FROM users WHERE username = ? AND passwordd = ?;";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPass);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int userCount = resultSet.getInt("user_count");
                if(userCount > 0) ok = true;
                else ok = false;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Eroare 1");
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("eroare 2");
            }
        }
        return ok;
    }
    public int deleteUser(String username, String password) {
        int ok = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        if(correctUser(username, password) == true){
            try {
                String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
                String dbUsername = "postgres";
                String dbPassword = "postgres";

                connection = DriverManager.getConnection(url, dbUsername, dbPassword);


                String query = "DELETE FROM users WHERE username = ?;";
                preparedStatement = connection.prepareStatement(query);


                preparedStatement.setString(1, username);
                int rowsAffect = preparedStatement.executeUpdate();
                if(rowsAffect > 0) ok = 1;

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } finally {
                // Close resources in a finally block to ensure they are closed even if an exception occurs
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        else ok = -1;
        return ok;
    }
    public boolean isValidAdmin(String enteredPassword) { ///ADMIN FUNCTION
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
            String dbUsername = "postgres";
            String dbPassword = "postgres";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);


            String query = "SELECT pass FROM admins WHERE pass = ?;";
            preparedStatement = connection.prepareStatement(query);


            preparedStatement.setString(1, enteredPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
    public String insertUser(String username, String passwordd, String firstName, String lastName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
            String dbUsername = "postgres";
            String dbPassword = "postgres";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            System.out.println("Inserting"+username+"."+passwordd+"."+firstName+"."+lastName);

            String query = "INSERT INTO users(username, passwordd, first_name, last_name) VALUES (?, ?, ?, ?);";
            preparedStatement = connection.prepareStatement(query);

            System.out.println("CHECK 1");

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, passwordd);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);

            System.out.println("CHECK 2");


            rowsAffected = preparedStatement.executeUpdate();

            System.out.println("CHECK 3"+rowsAffected);

            ok = true;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return "Error at DB level";
        } finally {
            // Close resources in a finally block to ensure they are closed even if an exception occurs
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                return rowsAffected + " Rows Affected. Success! Connection Closed!";
            } catch (SQLException e) {
                e.printStackTrace();
                return "Error at DB level";
            }
        }
    }

    public void getUser(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Integer rowsAffected = 0;
        try {
            String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
            String dbUsername = "postgres";
            String dbPassword = "postgres";

            connection = DriverManager.getConnection(url, dbUsername, dbPassword);

//            String query = "INSERT INTO person values('Bogdan', 'Test')";
            String query = "SELECT username, passwordd FROM users;";
            preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Display function to show the Resultset
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println(username + "     " + password);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }
}
