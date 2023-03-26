package homework;

import java.util.List;

public class Catalog {

    String name;

    List<Document> documents;

    public Catalog(String name, List<Document> documents) {
        this.name = name;
        this.documents = documents;
    }
    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDocument(Document document){
        documents.add(document);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", documents=" + documents +
                '}';
    }

    public Document findById(String id) {
        for(Document document : documents){
            if(document.getID() == id)
                return document;
        }
        return null;
    }
}