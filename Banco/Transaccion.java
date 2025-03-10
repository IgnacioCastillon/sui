package Banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaccion {
    private String operacion;
    private double cantidad;
    private LocalDateTime fecha;



    public Transaccion(String operacion, double cantidad) {
        this.operacion = operacion;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fecha.format(formatter)+"-"+operacion+" de "+cantidad;

    }
}
