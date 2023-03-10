import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Person implements Comparable<Person>, Node {

    String name;
    String birthDate;

    Map<Person, Node> relationship;

    /**
     * The constructor for the Person Class
     *
     * @param name - the name of the person
     * @param birthDate - the birthdate of the person
     */
    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        relationship = new HashMap<>();
    }

    /**
     * Function to add a relationship in the Map
     * @param node - the node to be put in the relationship Map
     */
    public void addRelationship(Node node)
    {
        relationship.put(this, node);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * The Override of the inherited function compareTo
     * @param person the object to be compared.
     * @return value corresponding to the alphabetical order of the objects' name:
     *  - 0 if the strings are equal
     *  - <0 if this object's name string has lower alphabetical hierarchy
     *  - >0 if this object's name string has higher alphabetical hierarchy
     */
    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
}
