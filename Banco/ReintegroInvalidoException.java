package Banco;

public class ReintegroInvalidoException extends RuntimeException {
    public ReintegroInvalidoException(String message) {
        super(message);
    }
}
