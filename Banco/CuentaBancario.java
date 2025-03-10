package Banco;





public class CuentaBancario {
    private String nombre;
    private double saldo;
    private Transaccion[] transacciones = new Transaccion[100];
    int transaccion = 0;

    public CuentaBancario() {
    }

    public CuentaBancario(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            String operacion = "Deposito";
            this.saldo += cantidad;
            transacciones[transaccion] = new Transaccion(operacion, cantidad);
            transaccion++;
        }else throw new DepositoInvalidoException("La cantidad no puede ser 0 o negativa");
    }

    public void reintengro(double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= this.saldo) {
                String operacion = "Reintegro";
            this.saldo -= cantidad;
            transacciones[transaccion] = new Transaccion(operacion,cantidad);
            transaccion++;
            }else throw new SaldoInsuficienteException("No se dispone de dicha cantidad a retirar");
        }else throw new ReintegroInvalidoException("La cantidad no puede ser 0 o negativa");
    }

    public void transferir(CuentaBancario destino, double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= this.getSaldo()) {
                this.saldo -= cantidad;
                String operacion = "Transferencia realizada a cuenta de " + destino.getNombre();
                this.agregarTransaccion(operacion, cantidad);
            destino.saldo+= cantidad;
            String operacion2 = "Transferencia recibida de " + this.getNombre();
                destino.agregarTransaccion(operacion2,cantidad);
            }else throw new SaldoInsuficienteException("No se dispone de dicha cantidad a retirar");
        }else throw new TransferenciaInvalidaException("La cantidad no puede ser 0 o negativa");

    }
    public void agregarTransaccion(String operacion, double cantidad) {
        if (transaccion<transacciones.length) {
            transacciones[transaccion] = new Transaccion(operacion, cantidad);
            transaccion++;
        }else System.out.println("No se pueden agregar mas transacciones");
    }

    public void mostrarHistorial(){
        System.out.println("Historial de movimientos de "+getNombre());
    for (int i = 0; i < transaccion; i++) {
        System.out.println(transacciones[i].toString());
    }
    }
}
