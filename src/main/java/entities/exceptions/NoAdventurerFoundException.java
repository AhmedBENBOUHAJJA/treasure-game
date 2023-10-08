package entities.exceptions;

public class NoAdventurerFoundException extends ProgramException {
    public NoAdventurerFoundException() {
        super();
    }

    public NoAdventurerFoundException(String message) {
        super(message);
    }
}
