package homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

class ViewCommand implements Command {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public void execute(Catalog catalog) throws InvalidDataException {
        Document document = catalog.findById(id);
        if (document == null) {
            throw new InvalidDataException("Document with ID " + id + " not found in catalog.");
        }

        if (document.getPath() != null) {
            // local file document
            File file = new File(document.getPath());
            if (!file.exists()) {
                throw new InvalidDataException("File does not exist: " + document.getPath());
            }

            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                throw new InvalidDataException("Error opening file: " + e.getMessage());
            }
        } else if (document.getUrl() != null) {
            // URL document
            try {
                Desktop.getDesktop().browse(new URI(document.getUrl()));
            } catch (IOException | URISyntaxException e) {
                throw new InvalidDataException("Error opening URL: " + e.getMessage());
            }
        }
    }
}