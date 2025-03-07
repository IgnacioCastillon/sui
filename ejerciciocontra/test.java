package ejerciciocontra;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario hola = new Usuario();
        try {
            System.out.println("Introducir contraseña: ");
            hola.setPassword(sc.nextLine());
            hola.actualizarHistorial(hola.getPassword());
            System.out.println(hola.getPassword());
            hola.mostrarHistorial();
            System.out.println("Introducir contraseña: ");
            hola.setPassword(sc.nextLine());
            hola.actualizarHistorial(hola.getPassword());
            System.out.println(hola.getPassword());
            hola.mostrarHistorial();
            System.out.println("Introducir contraseña: ");
            hola.setPassword(sc.nextLine());
            hola.actualizarHistorial(hola.getPassword());
            System.out.println(hola.getPassword());
            hola.mostrarHistorial();
            System.out.println("Introducir contraseña: ");
            hola.setPassword(sc.nextLine());
            hola.actualizarHistorial(hola.getPassword());
            System.out.println(hola.getPassword());
            hola.mostrarHistorial();
        }catch (PasswordInvalidaException e){
            System.out.println(e.getMessage());
        } catch (PasswordRepetidaException e) {
            throw new RuntimeException(e);
        }

        hola.mostrarHistorial();
    }
}
