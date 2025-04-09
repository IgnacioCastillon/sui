package CasoPractico02;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone("15 Pro", "Iphone", false);
        smartphone.conectarWifi();
        smartphone.hacerLlamada("634824724");
        smartphone.desconectarWifi();
        smartphone.mostrarInfo();

        SmartTV smartTV = new SmartTV("Pro","Samsung", false);
        smartTV.conectarWifi();
        smartTV.reproducirVideo("Vuelta al mundo");
        smartTV.mostrarInfo();

    }
}
