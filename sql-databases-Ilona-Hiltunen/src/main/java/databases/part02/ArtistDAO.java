package databases.part02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Data Access Object for the Artist table in the Chinook database.
 */
public class ArtistDAO {

    /**
     * The connection string used to connect to the database. You MUST use this
     * string when connecting to the database using JDBC. In the unit tests, this
     * field will be set to a different value.
     */
    private final String connectionString;
    private PreparedStatement preparedStatement= null;
    private Connection connection = null;
    private ResultSet resultSet = null;
    

    /**
     * Creates a new ArtistDAO that uses the specified connection string to connect
     * to the database. For example: "jdbc:sqlite:data/Chinook_Sqlite.sqlite"
     *
     * @param connectionString, see https://www.baeldung.com/java-jdbc-url-format
     */
    public ArtistDAO(String connectionString) {
        this.connectionString = connectionString;
    }

    /**
     * Returns a list of all artists in the database. The list is ordered by artist
     * name. If there are no artists in the database, an empty list is returned.
     *
     * @return a list of all artists in the database.
     */
    public List<Artist> getArtists() {
        List<Artist> artists = new ArrayList<>();
        
        try {
            connection = DriverManager.getConnection(connectionString);
            preparedStatement = connection.prepareStatement("SELECT * FROM Artist ORDER BY Name ASC");
            resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                artists.add(new Artist(resultSet.getLong("ArtistId"), resultSet.getString("Name")));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
            e.printStackTrace();
            }
        }

        return artists;
    }

    /**
     * Returns the artist with the specified id, or null if no artist exists with
     * that id.
     *
     * @param id the id of the artist to retrieve.
     * @return the artist with the specified id, or null if no artist exists with
     *         that id.
     */
    public Artist getArtistById(long id) {
        
       try {
        connection = DriverManager.getConnection(connectionString);
        preparedStatement = connection.prepareStatement("SELECT * FROM Artist WHERE ArtistId = (?)");
        preparedStatement.setLong(1, id);
        resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                return new Artist(resultSet.getLong("ArtistId"), resultSet.getString("Name"));
                }

       } catch (SQLException e) {
        e.printStackTrace();
       } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
            e.printStackTrace();
            }
        }
        
        return null;
    }
}
