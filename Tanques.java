package CasoPractico5;

public class Tanques {
    private double volumen_maximo;
    private double volumen_minimo;
    private double volumen_actual;

    public Tanques(double volumen_maximo, double volumen_minimo, double volumen_actual) {
        this.volumen_maximo = volumen_maximo;
        this.volumen_minimo = volumen_minimo;
        this.volumen_actual = volumen_actual;
    }

    public double getVolumen_maximo() {
        return volumen_maximo;
    }

    public void setVolumen_maximo(double volumen_maximo) throws TanqueLLenoException{

        this.volumen_maximo = volumen_maximo;
    }

    public double getVolumen_minimo(){


        return volumen_minimo;
    }

    public void setVolumen_minimo(double volumen_minimo) throws TanqueVacioException {
        if (volumen_minimo<0){
            throw new TanqueVacioException("EL volumen minimo no puede ser inferior a 0");
        }
        this.volumen_minimo = volumen_minimo;
    }

    public double getVolumen_actual() {
        return volumen_actual;
    }

    public void setVolumen_actual(double volumen_actual) {
        this.volumen_actual = volumen_actual;
    }

    public double añadirLeche(double cantidad) throws TanqueLLenoException{
        if ((volumen_actual+cantidad)>volumen_maximo){
            throw new TanqueLLenoException("El volumen actual no puede superar al volumen maximo del deposito.");
        }else {
            volumen_actual = volumen_actual + cantidad;
            return volumen_actual;
        }
    }

    public double retirarLeche(double cantidad) throws TanqueVacioException{
        if (volumen_actual < volumen_minimo) {
            throw new TanqueVacioException("El volumen actual no puede ser inferior al volumen minimo");
        }
        volumen_actual = volumen_actual-cantidad;
        return volumen_actual;
    }



    public void mostrarInfo(){
        System.out.println("Volumen maximo: "+volumen_maximo);
        System.out.println("Volumen minimo: "+volumen_minimo);
        System.out.println("Volumen actual: "+volumen_actual);
    }

}
