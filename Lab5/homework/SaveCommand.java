package homework;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class SaveCommand implements Command{
    @Override
    public void execute(Catalog catalog) {
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
}
