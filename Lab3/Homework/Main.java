import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Programmer person1 = new Programmer("Alex", "2.05.2001", "Python");
        Designer person2 = new Designer("Matei", "10.09.2002", "Photoshop");

        person1.addRelationship(person2);
        person2.addRelationship(person1);

        Company company1 = new Company("Amazon");
        Company company2 = new Company("Centric");


        person1.addRelationship(company1);
        person2.addRelationship(company2);

        Network network = new Network();

        network.addNote(person1);
        network.addNote(person2);
        network.addNote(company1);
        network.addNote(company2);

        List nodeList = network.getNodeList();

        for (int i = 0; i < nodeList.size(); i++)
            System.out.print(nodeList.get(i) + " ");

    }
}