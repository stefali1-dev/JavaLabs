import java.util.Vector;

public class Company implements Comparable<Company>,Node{

    String name;

    Vector<String> persons; // names of persons that work at this company;

    public Company(String name) {
        this.name = name;
        persons = new Vector<String>();
    }

    public void addPerson(String name)
    {
        persons.add(name);
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
    public int compareTo(Company company) {
        return this.name.compareTo(company.name);
    }
}
