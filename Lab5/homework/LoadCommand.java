package homework;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.Map;

public class LoadCommand implements Command{
    String path;

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void execute(Catalog catalog) {
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
