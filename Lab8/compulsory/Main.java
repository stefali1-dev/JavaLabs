package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        try {

            // creating singleton instance
            Database.getInstance();

            Statement stmt = Database.getConnection().createStatement();

            // reading and executing the sql script
            String script = new String(Files.readAllBytes(Paths.get("create_tables.sql")));
            stmt.execute(script);

            stmt.close();

            // adding entries in artists table
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");


            Database.closeConnection();
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}