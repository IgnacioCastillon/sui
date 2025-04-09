package CasoPractico02;

public class Smartphone extends Dispositivo{
    public Smartphone(String modelo, String marca, boolean conectado) {
        super(modelo, marca, conectado);
    }
    public void hacerLlamada(String numero){
        System.out.println("Realizando llamada a "+numero);
    }
}
