package EjercicioDNI;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona p1 = new Persona();
        Persona p2 = new Persona();
        Persona p3 = new Persona();
        Persona p4 = new Persona();
        try {
            p1.setNombre("Ignacio");
            p1.setEdad(21);
            p1.setDni("77665380S");
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }

        try {
            p2.setNombre("Pablo");
            p2.setEdad(19);
            p2.setDni("77665380S");
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }

        try {
            p3.setNombre("Marcos");
            p3.setEdad(18);
            p3.setDni("77665380S");
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }

        try {
            p4.setNombre("Jon");
            p4.setEdad(35);
            p4.setDni("77665380S");
        } catch (EdadInvalidaException e) {
            System.out.println(e.getMessage());
        }


        p1.esMayorDeEdad();

        RegistroPersonas registro = new RegistroPersonas();
        try {
            registro.agregarPersona(p1);
        } catch (DniDuplicadoException e) {
            System.out.println(e.getMessage());
        }


        registro.buscarPorNombre("Ignacio");

        try {
            registro.agregarPersona(p2);
        } catch (DniDuplicadoException e) {
            System.out.println(e.getMessage());
            }
        try {
            registro.agregarPersona(p4);
        }catch (DniDuplicadoException e){
            System.out.println(e.getMessage());
        }

        p2.actualizarDatos(p2.getNombre(),p2.getEdad(),"77665291S");

        try {
            registro.agregarPersona(p2);
        } catch (DniDuplicadoException e) {
            System.out.println(e.getMessage());
        }


        p3.actualizarDatos("Jose", 28, "77884290S");

        try {
            registro.agregarPersona(p3);
        } catch (DniDuplicadoException e) {
            System.out.println(e.getMessage());
        }

        registro.listarPersonas();
    }


}
