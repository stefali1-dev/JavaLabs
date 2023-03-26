package homework;

public class AddCommand implements Command {

    Document document; // the new entry to be added

    public void setDocument(Document document) {
        this.document = document;
    }

    @Override
    public void execute(Catalog catalog) {
        catalog.addDocument(document);
    }
}
