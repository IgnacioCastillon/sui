package EjercicioParking;

import java.time.LocalDateTime;

public class Vehiculo {
    private String matricula;
    private LocalDateTime horaEntrada;

    public Vehiculo() {
    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    @Override
    public String toString() {
        return "vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", horaEntrada=" + horaEntrada +
                '}'+super.toString();
    }
}
