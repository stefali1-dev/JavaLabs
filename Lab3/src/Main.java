import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Alex");
        Person person2 = new Person("Matei");

        person1.addPerson(person2.getName());
        person2.addPerson(person1.getName());

        Company company1 = new Company("Amazon");
        company1.addPerson(person1.getName());
        company1.addPerson(person2.getName());

        person1.addCompany(company1.getName());
        person2.addCompany(company1.getName());

        List nodeObjects = new ArrayList<Node>();

        nodeObjects.add(person1);
        nodeObjects.add(person2);
        nodeObjects.add(company1);

    }
}