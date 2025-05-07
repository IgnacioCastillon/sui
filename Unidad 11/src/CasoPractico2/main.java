package CasoPractico2;

import java.util.Scanner;

public class main extends GestorInventario{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean terminado = false;
        while (!terminado){
            System.out.println("-----------------------------------");
            System.out.println("1. Añadir producto");
            System.out.println("2. Eliminar producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Buscar Producto");
            System.out.println("5. Buscar por rango de precio");
            System.out.println("6. Salir");
            System.out.println("-----------------------------------");
            int resultado = sc.nextInt();
            switch (resultado){
                case 1 -> añadirProducto();
                case 2 -> eliminarProducto();
                case 3 -> mostrarProductos();
                case 4 -> buscarCodigo();
                case 5 -> mostrarRangoDePrecio();
                case 6 -> terminado = true;
            }
        }
        System.out.println("Programa finalizado");
    }
}
