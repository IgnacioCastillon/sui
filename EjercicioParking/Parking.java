package EjercicioParking;

public class Parking {
    private Vehiculo[] vehiculo;
    private int numVehiculos;
    private int capacidadMaxima = 0;

    public Parking(Vehiculo[] vehiculo, int numVehiculos, int capacidadMaxima) {
        this.vehiculo = vehiculo;
        this.numVehiculos = numVehiculos;
        this.capacidadMaxima = capacidadMaxima;
    }

    public Vehiculo[] getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo[] vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getNumVehiculos() {
        return numVehiculos;
    }

    public void setNumVehiculos(int numVehiculos) {
        this.numVehiculos = numVehiculos;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void ingresarVehicula(String matricula){

    }
}
