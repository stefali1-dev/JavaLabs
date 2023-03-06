import java.util.Vector;

public class Person implements Comparable<Person>, Node {

    String name;
    Vector<String> persons; // names of persons that this person has relationships with

    Vector<String> companies; // names of companies this person works at

    public Person(String name) {
        this.name = name;
        persons = new Vector<String>();
        companies = new Vector<String>();

    }

    public void addPerson(String name)
    {
        persons.add(name);
    }

    public void addCompany(String name)
    {
        companies.add(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.name);
    }
}
