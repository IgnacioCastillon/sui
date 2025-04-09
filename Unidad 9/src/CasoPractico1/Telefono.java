package CasoPractico1;

public abstract class Telefono {
    private int numero;

    public Telefono(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void recibirLlamada(int numero){
        System.out.printf("Llamada recibida: "+numero);
    }

    public void realizarLlamada(int numero){
        System.out.printf("Realizando llamada a: "+numero);
    }
}
