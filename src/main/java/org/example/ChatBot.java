import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import java.util.Scanner;

public class ChatBotAI {
    private static final String API_KEY = "YOUR_KEY_API_HERE";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OpenAiService service = new OpenAiService(API_KEY);

        System.out.println("Welcome to ChatBot AI. Write 'salir' to finish.");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("ChatBot: Good Bye!");
                break;
            }


            CompletionRequest request = CompletionRequest.builder()
                    .model("gpt-3.5-turbo")
                    .prompt(userInput)
                    .maxTokens(50)
                    .build();

            // Obtain Answer
            String response = service.createCompletion(request).getChoices().get(0).getText().trim();
            System.out.println("ChatBot: " + response);
        }

        scanner.close();
    }
}

