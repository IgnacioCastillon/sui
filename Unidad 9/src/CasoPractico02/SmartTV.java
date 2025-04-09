package CasoPractico02;

public class SmartTV extends Dispositivo{
    public SmartTV(String modelo, String marca, boolean conectado) {
        super(modelo, marca, conectado);
    }
    public void reproducirVideo(String video){
        System.out.println("Reproduciendo video: "+video);
    }
}
