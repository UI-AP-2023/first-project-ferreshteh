package exception;

public class ShoppingEx extends Exception{
    public ShoppingEx(String message) {
        super(message);
    }

    public ShoppingEx() {
        super("phone Error");
    }
}
