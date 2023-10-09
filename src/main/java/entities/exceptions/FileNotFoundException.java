package entities.exceptions;

public class FileNotFoundException extends ProgramException {

    public FileNotFoundException() {
        super();
    }

    public FileNotFoundException(String message) {
        super(message);
    }
}
