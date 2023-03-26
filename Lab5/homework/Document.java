package homework;

import java.util.Map;

public class Document {
    String name;
    String ID;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    Map<String, String> tags;
    String path;
    String Url;

    public Document(String name, String ID, Map<String, String> tags, String path, String Url) {
        this.name = name;
        this.ID = ID;
        this.tags = tags;
        this.path = path;
        this.Url = Url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", tags=" + tags +
                ", path='" + path + '\'' +
                '}';
    }
}