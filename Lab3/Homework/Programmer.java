public class Programmer extends Person{
    String preferredLanguage;

    public Programmer(String name, String birthDate, String preferredLanguage) {
        super(name, birthDate);
        this.preferredLanguage = preferredLanguage;
    }
}
