package homework;

public class ToStringCommand implements Command{
    String catalogString;
    @Override
    public void execute(Catalog catalog) {
        catalogString = " Catalog name: " + catalog.getName() + ":\n";
        catalogString += "Catalog documents: \n";
        for(Document document : catalog.getDocuments()){
            catalogString += document.toString() + "\n";
        }
    }

    public String getCatalogString() {
        return catalogString;
    }
}
