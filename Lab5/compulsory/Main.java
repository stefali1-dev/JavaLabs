package compulsory;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        // map containing tags regarding Ion Document
        Map<String, String> ionTags = new HashMap<>();
        ionTags.put("Title", "Ion");
        ionTags.put("Author", "Liviu Rebreianu");

        Document bookIon = new Document("Ion", "123", ionTags, "\\ion.txt");

        // map containing tags regarding Baltagul Document
        Map<String, String> baltagulTags = new HashMap<>();
        baltagulTags.put("Title", "Baltagul");
        baltagulTags.put("Author", "Mihail Sadoveanu");

        Document bookBaltagul = new Document("Baltagul", "12345", baltagulTags, "\\baltagul.txt");

        Catalog BookCatalog = new Catalog("Book Catalog", new ArrayList<>());

        Operation CatalogOperation = new Operation(BookCatalog);
        CatalogOperation.add(bookIon);
        CatalogOperation.add(bookBaltagul);

        // printing the textual representation of the catalog
        System.out.println(CatalogOperation.toString());

        // saving the catalog as .json
        CatalogOperation.save();

        // loading the catalog
        CatalogOperation.load("catalog.json");
    }
}