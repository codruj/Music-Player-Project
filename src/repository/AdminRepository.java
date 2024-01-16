package repository;

import model.Artist;

import java.sql.*;

public class AdminRepository {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Integer rowsAffected = 0;
    String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
    String dbUsername = "postgres";
    String dbPassword = "postgres";
    public AdminRepository(){

        try{
            connection = DriverManager.getConnection(url,dbUsername, dbPassword);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public Artist getArtist(String name){
        Integer id = 0;
        String name1 = null;
        String genres = null;
        Artist artist = new Artist(id,name1, genres);
        String query = "SELECT artist_id as aid, complete_name as cn, genres as gen from artists where complete_name = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                artist.setId(resultSet.getInt("aid"));
                artist.setName(resultSet.getString("cn"));
                artist.setGenres(resultSet.getString("gen"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return artist;
    }
    public int updateGenre(String name, String genreToAdd){
        int ok = 0;
        Artist artist = getArtist(name);
        String genress = artist.getGenres();
        String query = "UPDATE artists SET genres = ? WHERE complete_name = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            String result = genress + ", " + genreToAdd;
            preparedStatement.setString(1, result);
            preparedStatement.setString(2, name);
            int resultSet = preparedStatement.executeUpdate();
            if(resultSet != 0){
                ok = 1;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return ok;
    }
}
