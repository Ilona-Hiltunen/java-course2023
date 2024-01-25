package databases.part03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import databases.part02.Artist;

/**
 * Data Access Object for the Album table in the Chinook database.
 */
public class AlbumDAO {

    /**
     * The connection string used to connect to the database. You MUST use this
     * string when connecting to the database using JDBC. In the unit tests, this
     * field will be set to a different value.
     */
    private final String connectionString;
    
    
    /**
     * Creates a new AlbumDAO that uses the specified connection string to connect
     * to the database. For example: "jdbc:sqlite:data/Chinook_Sqlite.sqlite"
     *
     * @param jdbcConnection see https://www.baeldung.com/java-jdbc-url-format
     */
    public AlbumDAO(String jdbcConnection) {
        this.connectionString = jdbcConnection;
    }

    /**
     * Returns a list of all albums that have the specified artist as the artist.
     * If there are no albums for the specified artist, the list is empty.
     *
     * @param artist the artist whose albums to retrieve.
     * @return a list of all albums that have the specified artist as the artist,
     *         sorted by AlbumId in ascending order.
     */
    public List<Album> getAlbumsByArtist(Artist artist) {
       
        List<Album> albums = new ArrayList<>();

         try (Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM Album WHERE ArtistId = ? ORDER BY AlbumId ASC")) {
            pStatement.setLong(1, artist.getId());

                try (ResultSet resultSet = pStatement.executeQuery()) {
                    while (resultSet.next()) {
                Album album = new Album(resultSet.getLong("AlbumId"), resultSet.getString("Title"), resultSet.getLong("ArtistId"));
                albums.add(album);
                    }
                
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
           
        return albums;
    }

    /**
     * Adds the specified album to the database. Returns true if the album was
     * added successfully, false otherwise.
     *
     * @param album the album to add to the database.
     * @return true if the album was added successfully, false otherwise.
     */
    public boolean addAlbum(Album album) {
        
        try (Connection connection = DriverManager.getConnection(connectionString);
            PreparedStatement pStatement = connection.prepareStatement("INSERT INTO Album (Title, ArtistId) VALUES (?, ?)")) {
            pStatement.setString(1, album.getTitle());
            pStatement.setLong(2, album.getArtistId());
            int rows = pStatement.executeUpdate();
                if (rows > 0) {
                return true;
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Updates the specified album in the database. Returns true if the album was
     * updated successfully, false otherwise.
     *
     * @param album the album to update in the database.
     * @return true if the album was updated successfully, false otherwise.
     */
    public boolean updateAlbum(Album album) {
        
        try (Connection connection = DriverManager.getConnection(connectionString);
        PreparedStatement pStatement = connection.prepareStatement("UPDATE Album SET Title = ?, ArtistId = ? WHERE AlbumId = ?")) {
        pStatement.setString(1, album.getTitle());
        pStatement.setLong(2, album.getArtistId());
        pStatement.setLong(3, album.getId());
        int rows = pStatement.executeUpdate();
            if (rows > 0) {
            return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Deletes the specified album from the database. Returns true if the album was
     * deleted successfully, false otherwise.
     *
     * @param album the album to delete from the database.
     * @return true if the album was deleted successfully, false otherwise.
     */
    public boolean deleteAlbum(Album album) {
        /*
         * See hints for the methods above.
         *
         * Remember to use the `connectionString` instead of hard coding it, otherwise
         * your tetss will be deleting albums from your actual database!
         */
        try (Connection connection = DriverManager.getConnection(connectionString);
        PreparedStatement pStatement = connection.prepareStatement("DELETE FROM Album WHERE AlbumId = ?")) {
        pStatement.setLong(1, album.getId());
        int rows = pStatement.executeUpdate();
            if (rows > 0) {
            return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
