package homework;

public class Project implements Comparable<Project>{
    String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Project project2) {
        return this.name.compareTo(project2.name);
    }
}
