package Banco;

public class DepositoInvalidoException extends RuntimeException {
    public DepositoInvalidoException(String message) {
        super(message);
    }
}
