package repository;

import Tables.ReviewAlbum;
import Tables.ReviewArtist;
import Tables.ReviewSong;
import controller.ReviewsController;
import model.Album;
import model.Artist;
import model.Song;
import view.ReviewsView;

import java.sql.*;
import java.util.ArrayList;

public class ReviewRepository {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Integer rowsAffected = 0;
    String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
    String dbUsername = "postgres";
    String dbPassword = "postgres";
    public ReviewRepository(){

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
    public Song getSong(String name){
        Integer id = 0;
        String name1 = null;
        Integer duration = null;
        Integer albumId = 0;
        Song song = new Song(id,name1,duration,albumId);
        String query = "SELECT song_id as sid, song_title as title, duration as dur, album_id as aid from songs where song_title = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                song.setId(resultSet.getInt("sid"));
                song.setTitle(resultSet.getString("title"));
                song.setDuration(resultSet.getInt("dur"));
                song.setAlbumId(resultSet.getInt("aid"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return song;
    }
    public Album getAlbum(String name){
        Integer id = 0;
        String name1 = null;
        Integer year = null;
        Integer artistId = 0;
        Album album = new Album(id,name1,year,artistId);
        String query = "SELECT album_id as alid, album_title as title, release_year as y, artist_id as aid from albums where album_title = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                album.setId(resultSet.getInt("alid"));
                album.setTitle(resultSet.getString("title"));
                album.setReleaseYear(resultSet.getInt("y"));
                album.setArtistId(resultSet.getInt("aid"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return album;
    }
    public int insertReview(Integer id, String rate, String search) {
        int ok = 0;
        try {
            SongsRepository songsRepository = new SongsRepository();
            if(songsRepository.songExists(search) == 1){
                String query = "INSERT INTO reviewalbum (album_id, rate) VALUES (?, ?);";
                preparedStatement = connection.prepareStatement(query);


                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, rate);

                int resultSet = preparedStatement.executeUpdate();
                if(resultSet != 0)
                    ok = 1;
            }
            else if(songsRepository.songExists(search) == 2){
                String query = "INSERT INTO reviewsong(song_id, rate) VALUES (?, ?);";
                preparedStatement = connection.prepareStatement(query);


                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, rate);

                int resultSet = preparedStatement.executeUpdate();
                if(resultSet != 0)
                    ok = 1;
            }
            else if(songsRepository.songExists(search) == 3){

                String query = "INSERT INTO reviewartist(artist_id, rate) VALUES (?, ?);";
                preparedStatement = connection.prepareStatement(query);


                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, rate);



                int resultSet = preparedStatement.executeUpdate();


                if(resultSet != 0)
                    ok = 1;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return ok;
    }

    public ArrayList<ReviewArtist> getReviewArtists(){
        ArrayList<ReviewArtist> reviews = new ArrayList<ReviewArtist>();
        for(int id = 1; id <= 1000; id++){

            String query = "SELECT review_id as rid, artist_id as alid, rate as review from reviewartist where review_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    ReviewArtist review = new ReviewArtist(0,0,null);
                    review.setReviewId(resultSet.getInt("rid"));
                    review.setArtistId(resultSet.getInt("alid"));
                    review.setReview(resultSet.getString("review"));
                    reviews.add(review);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }


        return reviews;
    }
    public ArrayList<ReviewSong> getReviewSongs(){
        ArrayList<ReviewSong> reviews = new ArrayList<ReviewSong>();
        for(int id = 1; id <= 1000; id++){

            String query = "SELECT review_id as rid, song_id as alid, rate as review from reviewsong where review_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    ReviewSong review = new ReviewSong(0,0,null);
                    review.setReviewId(resultSet.getInt("rid"));
                    review.setSongId(resultSet.getInt("alid"));
                    review.setReview(resultSet.getString("review"));
                    reviews.add(review);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }


        return reviews;
    }
    public ArrayList<ReviewAlbum> getReviewAlbums(){
        ArrayList<ReviewAlbum> reviews = new ArrayList<ReviewAlbum>();
        for(int id = 1; id <= 1000; id++){

            String query = "SELECT review_id as rid, album_id as alid, rate as review from reviewalbum where review_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    ReviewAlbum review = new ReviewAlbum(0,0,null);
                    review.setReviewId(resultSet.getInt("rid"));
                    review.setAlbumId(resultSet.getInt("alid"));
                    review.setReview(resultSet.getString("review"));
                    reviews.add(review);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }


        return reviews;
    }
    public Song getSongById(Integer id){
        String name1 = null;
        Integer duration = null;
        Integer albumId = 0;
        Song song = new Song(id,name1,duration,albumId);
        String query = "SELECT song_id as sid, song_title as title, duration as dur, album_id as aid from songs where song_id = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                song.setId(resultSet.getInt("sid"));
                song.setTitle(resultSet.getString("title"));
                song.setDuration(resultSet.getInt("dur"));
                song.setAlbumId(resultSet.getInt("aid"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return song;
    }
    public Album getAlbumById(Integer id){
        String name1 = null;
        Integer year = null;
        Integer artistId = 0;
        Album album = new Album(id,name1,year,artistId);
        String query = "SELECT album_id as alid, album_title as title, release_year as y, artist_id as aid from albums where album_id = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                album.setId(resultSet.getInt("alid"));
                album.setTitle(resultSet.getString("title"));
                album.setReleaseYear(resultSet.getInt("y"));
                album.setArtistId(resultSet.getInt("aid"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return album;
    }
    public Artist getArtistById(Integer id){
        String name1 = null;
        String genres = null;
        Artist artist = new Artist(id,name1,genres);
        String query = "SELECT artist_id as alid, complete_name as name, genres as g from artists where artist_id = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                artist.setId(resultSet.getInt("alid"));
                artist.setName(resultSet.getString("name"));
                artist.setGenres(resultSet.getString("g"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return artist;
    }
}
