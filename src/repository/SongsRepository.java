package repository;

import model.Album;
import model.Song;

import java.sql.*;
import java.util.ArrayList;

public class SongsRepository {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Integer rowsAffected = 0;
    String url = "jdbc:postgresql://localhost:5432/finalmusicproject";
    String dbUsername = "postgres";
    String dbPassword = "postgres";
    public SongsRepository(){

        try{
            connection = DriverManager.getConnection(url,dbUsername, dbPassword);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Song> getSongs(Integer album_id){
        ArrayList<Song> songs = new ArrayList<Song>();
        for(int id = 1; id <= 20; id++){

            String query = "select song_id as sid, song_title as title, duration as dur, album_id as aid from songs where song_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    Song song = new Song(0, null,0,0);
                    song.setId(resultSet.getInt("sid"));
                    song.setTitle(resultSet.getString("title"));
                    song.setDuration(resultSet.getInt("dur"));
                    song.setAlbumId(resultSet.getInt("aid"));
                    songs.add(song);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        for(int id = 24; id <= 29; id++){

            String query = "select song_id as sid, song_title as title, duration as dur, album_id as aid from songs where song_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    Song song = new Song(0, null,0,0);
                    song.setId(resultSet.getInt("sid"));
                    song.setTitle(resultSet.getString("title"));
                    song.setDuration(resultSet.getInt("dur"));
                    song.setAlbumId(resultSet.getInt("aid"));
                    songs.add(song);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        ArrayList<Song> songs2 = new ArrayList<Song>();
        for(Song song: songs){
            if(song.getAlbumId() == album_id){
                songs2.add(song);
            }

        }
        return songs2;
    }
    public ArrayList<Album> getAlbums(Integer artist_id){
        ArrayList<Album> albums = new ArrayList<Album>();
        for(int id = 1; id <= 7; id++){

            String query = "SELECT album_id as alid, album_title as title, release_year as y, artist_id as aid from albums where album_id = ?;";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    Album album = new Album(0,null,0,0);
                    album.setId(resultSet.getInt("alid"));
                    album.setTitle(resultSet.getString("title"));
                    album.setReleaseYear(resultSet.getInt("y"));
                    album.setArtistId(resultSet.getInt("aid"));
                    albums.add(album);

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        ArrayList<Album> albums2 = new ArrayList<Album>();
        for(Album albumm: albums){
            if(albumm.getArtistId() == artist_id){
                albums2.add(albumm);
            }

        }
        return albums2;
    }


    public Song songPage(String enteredTitle)
    {
        Integer id = 0;
        String title = null;
        Integer duration = 0;
        Integer albumId = 0;
        Song song = new Song(id,title,duration,albumId);
        int result = 0;

        String query = "SELECT song_id AS id, song_title AS title, duration AS dur, album_id AS albumID FROM songs WHERE song_title = ?;";
        ///CHECKING IF THERE ARE ALBUMS NAMED LIKE THAT
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, enteredTitle);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                song.setId(resultSet.getInt("id"));
                song.setTitle(resultSet.getString("title"));
                song.setDuration(resultSet.getInt("dur"));
                song.setAlbumId(resultSet.getInt("albumID"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return song;
    }

    public int songExists(String enteredTitle)
    {
        int result = 0;
        String query = "SELECT COUNT(*) AS albums_count FROM albums WHERE album_title = ?;";
        ///CHECKING IF THERE ARE ALBUMS NAMED LIKE THAT
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1, enteredTitle);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int albumsCount = resultSet.getInt("albums_count");
                if(albumsCount > 0) result = 1;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        if(result == 0)
        {
            String query1 = "SELECT COUNT(*) AS songs_count FROM songs WHERE song_title = ?;";
            ///CHECKING IF THERE ARE ALBUMS NAMED LIKE THAT
            try(PreparedStatement preparedStatement = connection.prepareStatement(query1)){

                preparedStatement.setString(1, enteredTitle);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    int songsCount = resultSet.getInt("songs_count");
                    if(songsCount > 0) result = 2;

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(result == 0)
        {
            String query2 = "SELECT COUNT(*) AS artists_count FROM artists WHERE complete_name = ?;";
            ///CHECKING IF THERE ARE ALBUMS NAMED LIKE THAT
            try(PreparedStatement preparedStatement = connection.prepareStatement(query2)){

                preparedStatement.setString(1, enteredTitle);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next())
                {
                    int artistsCount = resultSet.getInt("artists_count");
                    if(artistsCount > 0) result = 3;

                }

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean artistExists(String enteredName){
        String query2 = "SELECT COUNT(*) AS artists_count FROM artists WHERE complete_name = ?;";
        ///CHECKING IF THERE ARE ALBUMS NAMED LIKE THAT
        try(PreparedStatement preparedStatement = connection.prepareStatement(query2)){

            preparedStatement.setString(1, enteredName);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                int artistsCount = resultSet.getInt("artists_count");
                if(artistsCount > 0) return true;

            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}
