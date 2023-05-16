package duolingo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ClasificadorPalabras {
    private Map<Character, Set<String>> palabrasPorInicial;

    public ClasificadorPalabras() {
        palabrasPorInicial = new HashMap<>();
    }

    public void añadirPalabra(String palabra) {
        palabra = palabra.trim().toLowerCase();
        char inicial = palabra.charAt(0);
        if (!palabrasPorInicial.containsKey(inicial)) {
            palabrasPorInicial.put(inicial, new HashSet<>());
        }
        palabrasPorInicial.get(inicial).add(palabra);
    }

    public boolean eliminarPalabra(String palabra) {
        palabra = palabra.trim().toLowerCase();
        char inicial = palabra.charAt(0);
        if (palabrasPorInicial.containsKey(inicial)) {
            boolean eliminado = palabrasPorInicial.get(inicial).remove(palabra);
            if (eliminado && palabrasPorInicial.get(inicial).isEmpty()) {
                palabrasPorInicial.remove(inicial);
            }
            return eliminado;
        }
        return false;
    }

    public boolean existePalabra(String palabra) {
        palabra = palabra.trim().toLowerCase();
        char inicial = palabra.charAt(0);
        Set<String> palabrasSet = palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
        return palabrasSet.contains(palabra);
    }

    public List<Character> obtenerIniciales() {
        return new ArrayList<>(palabrasPorInicial.keySet());
    }

    public List<String> obtenerPalabrasPorInicial(char inicial) {
        Set<String> palabrasSet = palabrasPorInicial.getOrDefault(inicial, new HashSet<>());
        return new ArrayList<>(palabrasSet);
    }
}