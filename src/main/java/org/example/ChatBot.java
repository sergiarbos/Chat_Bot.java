package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Diccionario de respuestas
        HashMap<String, String> respuestas = new HashMap<>();
        respuestas.put("hola", "¡Hola! ¿Cómo estás?");
        respuestas.put("cómo estás", "Estoy bien, gracias por preguntar.");
        respuestas.put("adiós", "¡Hasta luego! Que tengas un buen día.");
        respuestas.put("nombre", "Soy un bot de chat en Java.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al bot de chat. Escribe algo:");

        while (true) {
            String input = scanner.nextLine().toLowerCase(); // Convertir a minúsculas
            if (input.equals("salir")) {
                System.out.println("Adiós!");
                break;
            }
            System.out.println(respuestas.getOrDefault(input, "Lo siento, no entiendo."));
        }

        scanner.close();
    }
}
