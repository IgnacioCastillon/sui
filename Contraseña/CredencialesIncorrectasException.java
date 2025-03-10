package Contraseña;

public class CredencialesIncorrectasException extends RuntimeException {
    public CredencialesIncorrectasException(String message) {
        super(message);
    }
}
