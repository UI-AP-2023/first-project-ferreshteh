package exception;

public class Email extends InputEx{
    public Email() {
        super("email is not true");
    }

    public Email(String message) {
        super(message);
    }
}
