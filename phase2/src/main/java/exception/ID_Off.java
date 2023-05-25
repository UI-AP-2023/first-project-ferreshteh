package exception;

public class ID_Off extends Exception {
    public ID_Off() {
        super("id is not exist");
    }

    public ID_Off(String message) {
        super(message);
    }
}
