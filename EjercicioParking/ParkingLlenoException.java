package EjercicioParking;

public class ParkingLlenoException extends RuntimeException {
    public ParkingLlenoException(String message) {
        super(message);
    }
}
