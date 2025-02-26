import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.util.Scanner;

public class ChatBotAI {
    private static final String API_KEY = "TU_CLAVE_API_AQUI"; // Reemplaza con tu clave de OpenAI

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OpenAiService service = new OpenAiService(API_KEY);

        System.out.println("Bienvenido al ChatBot AI. Escribe 'salir' para terminar.");

        while (true) {
            System.out.print("Tú: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("salir")) {
                System.out.println("ChatBot: ¡Hasta luego!");
                break;
            }

            // Crear una solicitud a OpenAI
            CompletionRequest request = CompletionRequest.builder()
                    .model("gpt-3.5-turbo") // O usa "gpt-4" si tienes acceso
                    .prompt(userInput)
                    .maxTokens(50)
                    .build();

            // Obtener respuesta
            String response = service.createCompletion(request).getChoices().get(0).getText().trim();
            System.out.println("ChatBot: " + response);
        }

        scanner.close();
    }
}

