package CasoPractico02;

public abstract class Dispositivo implements Conectable{
    private String modelo;
    private String marca;
    private boolean conectado;

    public Dispositivo(String modelo, String marca, boolean conectado) {
        this.modelo = modelo;
        this.marca = marca;
        this.conectado = conectado;
    }

    @Override
    public void conectarWifi() {
        conectado = true;
    }

    @Override
    public void desconectarWifi() {
        conectado = false;
    }

    @Override
    public boolean estaConectado() {
        return conectado;
    }

    public void mostrarInfo(){
        System.out.println("Modelo: "+modelo+"\nMarca: "+marca+"\nEstado de conexion: "+conectado);
    }
}
