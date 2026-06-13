import java.util.Scanner;

public class AIChatbox{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;

        System.out.println("Chatbot: Hello! Ask me something (type 'exit' to stop)");

        while (true) {
            System.out.print("You: ");
            input = sc.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            } else if (input.contains("hello")) {
                System.out.println("Chatbot: Hi there!");
            } else if (input.contains("name")) {
                System.out.println("Chatbot: I am a Java Chatbot.");
            } else if (input.contains("java")) {
                System.out.println("Chatbot: Java is a powerful programming language!");
            } else if (input.contains("how are you")) {
                System.out.println("Chatbot: I'm just code, but I'm doing great!");
            } else {
                System.out.println("Chatbot: I don't understand that.");
            }
        }
    }
}