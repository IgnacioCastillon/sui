package CasoPractico2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GestorInventario {
    static Set<String> codigo1 = new TreeSet<>();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();

    public static void añadirProducto(){
        boolean encontrado = false;
        String codigo;
        System.out.println("Codigo del producto:");
        codigo = sc.nextLine();
        for (String c : codigo1){
            if (codigo.equalsIgnoreCase(c)){
                encontrado=true;
            }
        }
        if (!encontrado){
            System.out.println("Nombre del producto:");
            String nombre = sc.nextLine();
            System.out.println("Precio:");
            Double precio = sc.nextDouble();
            sc.nextLine();
            codigo1.add(codigo);
            productos.add(new Producto(codigo,nombre,precio));
        }else System.out.println("Ya hay un producto registrado con este codigo");
    }

    public static void eliminarProducto(){
        boolean encontrado = false;
        Producto eliminar = new Producto();
        System.out.println("Codigo del producto a eliminar:");
        String codigo = sc.nextLine();
        for (String c : codigo1){
            if (codigo.equalsIgnoreCase(c)){
                encontrado = true;
            }
        }
        if (encontrado){
            for (Producto c : productos){
                if (codigo.equalsIgnoreCase(c.getCodigo())){
                    eliminar = c;
                }
            }
            productos.remove(eliminar);
            codigo1.remove(eliminar.getCodigo());
            System.out.println("Producto con codigo "+eliminar.getCodigo()+" eliminado");
        }else System.out.println("No existe ningun producto con este codigo.");
    }

    public static void mostrarProductos() {
        for (String a : codigo1) {
            for (Producto c : productos) {
                if (a.equalsIgnoreCase(c.getCodigo())) {
                    System.out.println(c.toString());
                }
            }
        }
    }

    public static void buscarCodigo(){
        boolean encontrado = false;
        Producto mostrar = new Producto();
        System.out.println("Introduce el codigo del producto que quieres buscar:");
        String codigo = sc.nextLine();
        for (String c : codigo1){
            if (codigo.equalsIgnoreCase(c)){
                encontrado = true;
            }
        }
        if (encontrado){
            for (Producto c : productos){
                if (codigo.equalsIgnoreCase(c.getCodigo())){
                    mostrar = c;
                }
            }
            System.out.println(mostrar.toString());
        }else System.out.println("No existe ningun producto con este codigo.");
    }

    public static void mostrarRangoDePrecio(){
        boolean encontrado = false;
        Set<Double> precios = new TreeSet<>();
        System.out.println("Introduce el rango de precios para buscar productos:\nPrecio mas bajo:");
        double precioBajo = sc.nextDouble();
        sc.nextLine();
        System.out.println("Precio mas alto: ");
        double precioAlto = sc.nextDouble();
        sc.nextLine();
        for (Producto c : productos){
            if (c.getPrecio()>=precioBajo&&c.getPrecio()<=precioAlto){
                encontrado = true;
                precios.add(c.getPrecio());
            }
        }
        if (!encontrado){
            System.out.println("No hay ningun producto cuyo precio este dentro de este rango");
        }else{
            for (Double c : precios){
                for (Producto p : productos){
                    if (c==p.getPrecio()){
                        System.out.println(p.toString());
                    }
                }
            }
        }
    }
}
