import java.util.Scanner;

public class AIChatbot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      AI CHATBOT STARTED");
        System.out.println("Type 'bye' to exit.");
        System.out.println("=================================");

        while (true) {

            System.out.print("\nYou: ");
            String input = sc.nextLine().toLowerCase();

            if (input.contains("hello") || input.contains("hi")) {
                System.out.println("Bot: Hello! How can I help you today?");
            }

            else if (input.contains("your name")) {
                System.out.println("Bot: My name is CodeAlpha AI Chatbot.");
            }

            else if (input.contains("how are you")) {
                System.out.println("Bot: I am fine. Thank you for asking.");
            }

            else if (input.contains("java")) {
                System.out.println("Bot: Java is a popular object-oriented programming language.");
            }

            else if (input.contains("ai")) {
                System.out.println("Bot: AI stands for Artificial Intelligence.");
            }

            else if (input.contains("college")) {
                System.out.println("Bot: College is a place where students learn professional skills.");
            }

            else if (input.contains("help")) {
                System.out.println("Bot: You can ask me about Java, AI, College, or general greetings.");
            }

            else if (input.contains("bye")) {
                System.out.println("Bot: Goodbye! Have a great day.");
                break;
            }

            else {
                System.out.println("Bot: Sorry, I don't understand that question.");
            }
        }

        sc.close();
    }
}