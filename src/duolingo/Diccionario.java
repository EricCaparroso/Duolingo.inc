package duolingo;

import duolingo.utils.ClasificadorPalabras;

import java.util.List;
import java.util.Scanner;

public class Diccionario {
    public static void main(String[] args) {

        ClasificadorPalabras clasificador = new ClasificadorPalabras();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al clasificador de palabras!");
        while (true) {
            System.out.println();
            System.out.println("Menú:");
            System.out.println("1. Añadir palabra");
            System.out.println("2. Eliminar palabra");
            System.out.println("3. Existe palabra");
            System.out.println("4. Mostrar iniciales disponibles");
            System.out.println("5. Ver palabras por inicial");
            System.out.println("6. Cerrar programa");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la palabra: ");
                    String palabra = scanner.nextLine();
                    clasificador.añadirPalabra(palabra);
                    System.out.println("La palabra se ha añadido correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese la palabra que desea eliminar: ");
                    palabra = scanner.nextLine();
                    if (clasificador.eliminarPalabra(palabra)) {
                        System.out.println("La palabra se ha eliminado correctamente.");
                    } else {
                        System.out.println("La palabra no estaba almacenada.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la palabra que desea buscar: ");
                    palabra = scanner.nextLine();
                    if (clasificador.existePalabra(palabra)) {
                        System.out.println("La palabra se ha encontrado.");
                    } else {
                        System.out.println("La palabra no está almacenada.");
                    }
                    break;
                case 4:
                    List<Character> iniciales = clasificador.obtenerIniciales();
                    System.out.println("Iniciales disponibles: " + iniciales);
                    break;
                case 5:
                    System.out.print("Ingrese la inicial: ");
                    char inicial = scanner.nextLine().toLowerCase().charAt(0);
                    List<String> palabras = clasificador.obtenerPalabrasPorInicial(inicial);
                    System.out.println("Palabras que comienzan con '" + inicial + "': " + palabras);
                    break;
                case 6:
                    System.out.println("Adiós!");
                    return;
                default:
                    System.out.println("Opción inválida!");
            }
        }
    }
}


