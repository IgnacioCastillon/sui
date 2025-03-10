package ejercicioArray;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class BuscadorArray {

    static void generarArrayAleatorio(){
        Random rd = new Random();
        int[] array = new int[rd.nextInt(51)+10];
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int random;
            do {
                random = rd.nextInt(101); // Número aleatorio entre 0 y 100
            } while (uniqueNumbers.contains(random)); // Si el número ya existe, genera otro

            array[i] = random; // Asignar el número al array
            uniqueNumbers.add(random); // Añadir al HashSet para asegurar que no se repita
        }
    }
    int intentos=0;
    static void buscarElemento(int[] array, int valor){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                System.out.println("Elemento encontrado");
            }else throw new ElementoNoEncontradoException("Elemento no encontrado");
        }
    }
        }

