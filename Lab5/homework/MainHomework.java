package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainHomework {
    public static void main(String[] args) throws InvalidDataException {


        // map containing tags regarding Ion Document
        Map<String, String> ionTags = new HashMap<>();
        ionTags.put("Title", "Ion");
        ionTags.put("Author", "Liviu Rebreianu");

        Document bookIon = new Document("Ion", "123", ionTags, "ion.txt", null);

        // map containing tags regarding Baltagul Document
        Map<String, String> baltagulTags = new HashMap<>();
        baltagulTags.put("Title", "Baltagul");
        baltagulTags.put("Author", "Mihail Sadoveanu");

        Document bookBaltagul = new Document("Baltagul", "12345", baltagulTags, "baltagul.txt", null);

        Catalog bookCatalog = new Catalog("Book Catalog", new ArrayList<>());

        Operation catalogOperation =
                new Operation(bookCatalog, new AddCommand(), new ListCommand(), new LoadCommand(),
                new ReportCommand(null, null), new SaveCommand(), new ToStringCommand(),
                new ViewCommand());

        catalogOperation.addCommand.setDocument(bookIon);
        catalogOperation.addCommand.execute(bookCatalog);

        catalogOperation.addCommand.setDocument(bookBaltagul);
        catalogOperation.addCommand.execute(bookCatalog);

        System.out.println("Catalog documents list: ");
        catalogOperation.listCommand.execute(bookCatalog);

        // saving the catalog as a .json
        catalogOperation.saveCommand.execute(bookCatalog);

        // loading the catalog in a .json format
        catalogOperation.loadCommand.setPath("catalog.json");
        catalogOperation.loadCommand.execute(bookCatalog);

        // printing the textual representation of the catalog
        catalogOperation.toStringCommand.execute(bookCatalog);
        System.out.println("\nThe catalog displayed as a string: \n" + catalogOperation.toStringCommand.getCatalogString());


        // executing the view command on the document with the id 123
        catalogOperation.viewCommand.setId("123");
        catalogOperation.viewCommand.execute(bookCatalog);

        // executing the report command with null paths
        // catalogOperation.reportCommand.execute(bookCatalog);


    }
}
