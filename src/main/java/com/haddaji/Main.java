package com.haddaji;
import com.haddaji.HaddajiLLM;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔥 DeepSeek Console Chatbot");
        System.out.println("Type your message below. Type 'exit' to quit.\n");

        while (true) {
            System.out.print("You: ");
            String userMessage = scanner.nextLine();

            if (userMessage.equalsIgnoreCase("exit")) {
                break;
            }

            String reply = HaddajiLLM.haddaji_simple_llm(userMessage);
            System.out.println("AI: " + reply + "\n");
        }

        HaddajiLLM.close();
        System.out.println("👋 Chatbot closed.");

    }
}