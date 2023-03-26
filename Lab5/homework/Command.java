package homework;

public interface Command {

    public abstract void execute(Catalog catalog) throws InvalidDataException, InvalidCommandException;;

}
