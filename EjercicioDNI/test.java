package EjercicioDNI;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        try {
            p1.setNombre("Ignacio");
            p1.setEdad(21);
            p1.setDni("77665380S");
        } catch (DniInvalidoException | EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }

        try {
            p1.setNombre("Pablo");
            p1.setEdad(19);
            p1.setDni("77665380F");
        } catch (DniInvalidoException | EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }

        p1.mostrarInfo();
        p1.actualizarDatos("Juan", 23, "77445289S");
        p1.mostrarInfo();
        p1.esMayorDeEdad();

        RegistroPersonas registro = new RegistroPersonas();
        try {
            registro.agregarPersona(p1);
        } catch (DniInvalidoException | EdadInvalidaException | DniDuplicadoException e) {
            System.out.println(e.getMessage());

        }

        registro.buscarPorNombre("Juan");

        try {
            registro.agregarPersona(p2);
        } catch (DniInvalidoException | EdadInvalidaException | DniDuplicadoException e) {
            System.out.println(e.getMessage());
            }

        registro.listarPersonas();
    }
}
