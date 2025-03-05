package CasoPractico5;

public class Operaciones {
    public static void main(String[] args) {
        Tanques t1 = new Tanques(25000,0,0);
        Tanques t2 = new Tanques(10000,0,0);
        Tanques t3 = new Tanques(10000,0,0);
        Tanques t4 = new Tanques(5000,0,0);
        Tanques t5 = new Tanques(5000,0,0);

        try {
            t1.añadirLeche(22500);
            t1.mostrarInfo();
            t1.añadirLeche(6000);
            t1.mostrarInfo();
        }catch (TanqueLLenoException e){
            System.out.println(e.getMessage());
        }


    }
}
