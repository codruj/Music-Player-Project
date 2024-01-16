package repository;

import Tables.ReviewArtist;
import model.Artist;
import model.Merch;

import java.sql.*;
import java.util.ArrayList;

public class MerchRepository {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Integer rowsAffected = 0;
    String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
    String dbUsername = "postgres";
    String dbPassword = "postgres";
    public MerchRepository(){

        try{
            connection = DriverManager.getConnection(url,dbUsername, dbPassword);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public ArrayList<Merch> getMerchProducts(){
        ArrayList<Merch> products = new ArrayList<Merch>();
        for(int id = 1; id <= 1000; id++){

            String query = "SELECT merch_id as mid, merch_title as name, artist_id as aid from merch where merch_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    Merch product = new Merch(0,0,null);
                    product.setId(resultSet.getInt("mid"));
                    product.setArtistId(resultSet.getInt("aid"));
                    product.setMerchName(resultSet.getString("name"));
                    products.add(product);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }


        return products;
    }
}
