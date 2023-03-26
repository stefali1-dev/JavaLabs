package homework;


public class ListCommand implements Command{
    @Override
    public void execute(Catalog catalog) {
        System.out.println(catalog.getDocuments());
    }
}
