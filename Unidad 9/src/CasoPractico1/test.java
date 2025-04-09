package CasoPractico1;

public class test {
    public static void main(String[] args) {
        TelefonoFijo telefono = new TelefonoFijo(634824724, "Xiaomi", "Cagarruta");
        TelefonoMovil movil = new TelefonoMovil(629519746, "Iphone", "15 Pro", "Orange");
        telefono.realizarLlamada(629519746);

        movil.realizarLlamada(634792989);

        MovilRadio movilRadio = new MovilRadio(624712724,"Iphone","16","PTV Telecom");
        movilRadio.escucharSintonia("Bad Bunny");

        MovilCamara movilCamara = new MovilCamara(952481249,"Oppo", "242", "Movistar");
        movilCamara.realizarFoto("64px");

    }
}
