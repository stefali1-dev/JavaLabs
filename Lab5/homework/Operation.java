package homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Operation {

    Catalog catalog;

    AddCommand addCommand;
    ListCommand listCommand;
    LoadCommand loadCommand;
    ReportCommand reportCommand;
    SaveCommand saveCommand;
    ToStringCommand toStringCommand;
    ViewCommand viewCommand;

    public Operation(Catalog catalog, AddCommand addCommand, ListCommand listCommand, LoadCommand loadCommand,
                     ReportCommand reportCommand, SaveCommand saveCommand, ToStringCommand toStringCommand,
                     ViewCommand viewCommand) {
        this.catalog = catalog;
        this.addCommand = addCommand;
        this.listCommand = listCommand;
        this.loadCommand = loadCommand;
        this.reportCommand = reportCommand;
        this.saveCommand = saveCommand;
        this.toStringCommand = toStringCommand;
        this.viewCommand = viewCommand;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }


}