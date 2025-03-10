package Contraseña;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Intento {
    private long timestamp;
    private String resultado;

    public Intento(String resultado) {
        this.timestamp = System.currentTimeMillis();
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Intento{" +
                "timestamp=" + timestamp +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
