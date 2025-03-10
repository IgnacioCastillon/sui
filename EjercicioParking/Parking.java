package EjercicioParking;

import java.time.format.DateTimeFormatter;

public class Parking {
    private Vehiculo[] vehiculo = new Vehiculo[20];
    private int numVehiculos;
    private int capacidadMaxima = 0;

    public Parking(int capacidadMaxima) {
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



    public void ingresarVehiculo(String matricula){
        if (numVehiculos<capacidadMaxima) {
            for (int i = 0; i < numVehiculos; i++) {
                if (matricula.equalsIgnoreCase(vehiculo[i].getMatricula())) {
                    throw new VehiculoDuplicadoException("Esta matricula ya esta registrada en el parking");
                }
            }
        }
        if (numVehiculos < capacidadMaxima) {
            vehiculo[numVehiculos] = new Vehiculo(matricula);
            numVehiculos++;
            System.out.println("Vehiculo con matricula "+matricula+" ingresado exitosamente");
        }else throw new ParkingLlenoException("Parking lleno");
    }


    public void salirVehiculo(String matricula){
        for (int i=0; i<numVehiculos; i++) {
            if (vehiculo[i].getMatricula().equals(matricula)) {
                System.out.println("Vehiculo con matricula "+matricula+" sacado del parking");
                int vehiculoeliminado = i;
                vehiculo[i] = null;
                for (int j=0; j<=numVehiculos; j++) {
                    if (j>vehiculoeliminado) {
                    vehiculo[j-1] = vehiculo[j];
                        System.out.println("caca");
                        vehiculo[j] = null;
                    }
                }
                numVehiculos--;
            }else if (i==numVehiculos-1){
                throw new VehiculoNoEncontradoException("Vehiculo no encontrado");
            }
        }
    }

    public void mostrarVehiculos(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\tHH:mm:ss");
        System.out.println("\nVehiculos en el parking:");
        System.out.println("Matricula\t\t\t\tHora de entrada");
        for (int i=0; i<numVehiculos; i++) {
            System.out.println(vehiculo[i].getMatricula()+"\t\t\t\t\t\t"+vehiculo[i].getHoraEntrada().format(formatter));
        }
    }
}
