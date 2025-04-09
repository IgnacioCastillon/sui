package CasoPractico1;

public class MovilRadio extends TelefonoMovil implements Radio{
    public MovilRadio(int numero, String marca, String modelo, String operadorMovil) {
        super(numero, marca, modelo, operadorMovil);
    }

    @Override
    public void escucharSintonia(String Sintonia) {
        System.out.println("Escuchando la sintonia: "+Sintonia);
    }
}
