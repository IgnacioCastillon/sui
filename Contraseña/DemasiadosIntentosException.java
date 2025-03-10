package Contraseña;

public class DemasiadosIntentosException extends RuntimeException {
    public DemasiadosIntentosException(String message) {
        super(message);
    }
}
