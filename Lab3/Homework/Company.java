import java.util.Vector;

public class Company implements Comparable<Company>,Node{

    String name;

    Vector<String> persons; // names of persons that work at this company;

    /**
     * Constructor for the Company Class
     *
     * @param name the name to be set
     */
    public Company(String name) {
        this.name = name;
        persons = new Vector<String>();
    }

    /**
     * Function to add a person to the persons vector
     * @param name name of the person to be added
     */
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

    /**
     * The Override of the inherited function compareTo
     * @param company the object to be compared.
     * @return value corresponding to the alphabetical order of the objects' name:
     *  - 0 if the strings are equal
     *  - <0 if this object's name string has lower alphabetical hierarchy
     *  - >0 if this object's name string has higher alphabetical hierarchy
     */
    @Override
    public int compareTo(Company company) {
        return this.name.compareTo(company.name);
    }
}
