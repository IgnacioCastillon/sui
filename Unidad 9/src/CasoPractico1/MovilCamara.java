package CasoPractico1;

public class MovilCamara extends TelefonoMovil implements Camara{
    public MovilCamara(int numero, String marca, String modelo, String operadorMovil) {
        super(numero, marca, modelo, operadorMovil);
    }

    @Override
    public void realizarFoto(String resolucion){
        System.out.println("Realizando fotografia con una resolucion de "+resolucion);
    }
}
