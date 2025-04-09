package CasoPractico1;

public class TelefonoMovil extends TelefonoFijo{
    private String operadorMovil;

    public TelefonoMovil(int numero, String marca, String modelo, String operadorMovil) {
        super(numero, marca, modelo);
        this.operadorMovil = operadorMovil;
    }

    public String getOperadorMovil() {
        return operadorMovil;
    }

    public void setOperadorMovil(String operadorMovil) {
        this.operadorMovil = operadorMovil;
    }

    @Override
    public void realizarLlamada(int numero) {
        System.out.println("\n");
        super.realizarLlamada(numero);
        System.out.println(" con el operador "+operadorMovil);
    }
}
