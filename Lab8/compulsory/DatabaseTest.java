import org.example.Database;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/lab8";
    private static final String USER = "postgres";
    private static final String PASSWORD = "b4";

    private Database database;

    @BeforeEach
    void setUp() {
        database = Database.getInstance();
    }

    @AfterEach
    void tearDown() throws SQLException {
        Database.closeConnection();
    }

    @Test
    void testGetInstance() {
        assertNotNull(database);
        assertSame(database, Database.getInstance());
    }

    @Test
    void testGetConnection() {
        Connection connection = Database.getConnection();
        assertNotNull(connection);
        assertSame(connection, Database.getConnection());
    }

    @Test
    void testCloseConnection() throws SQLException {
        Connection connection = Database.getConnection();
        assertFalse(connection.isClosed());
        Database.closeConnection();
        assertTrue(connection.isClosed());
    }

}