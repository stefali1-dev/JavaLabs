package compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Operation {

    Catalog catalog;

    public Operation(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void add(Document document){
        catalog.addDocument(document);
    }

    @Override
    public String toString() {
        String returnString = " Catalog name: " + catalog.getName() + ":\n";
        returnString += "Catalog documents: \n";
        for(Document document : catalog.getDocuments()){
            returnString += document.toString() + "\n";
        }

        return returnString;
    }

    public void save(){
        try {
            // create a map
            Map<String, Object> jsonMap = new HashMap<>();

            ArrayList<Map<String, Object>> documentMapArray = new ArrayList<>();

            for(Document document : catalog.getDocuments()){
                Map<String, Object> documentMap = new HashMap<>();

                documentMap.put("name", document.getName());
                documentMap.put("ID", document.getID());
                documentMap.put("tags", document.getTags());
                documentMap.put("path", document.getPath());

                documentMapArray.add(documentMap);
            }

            jsonMap.put("entries", documentMapArray);
            jsonMap.put("name", catalog.getName());

            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert map to JSON file
            mapper.writeValue(Paths.get("catalog.json").toFile(), jsonMap);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void load(String path){
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON file to map
            Map<?, ?> map = mapper.readValue(Paths.get(path).toFile(), Map.class);


            // print map entries
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
