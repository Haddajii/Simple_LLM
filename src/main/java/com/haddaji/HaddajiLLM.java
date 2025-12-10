package com.haddaji;

import com.microsoft.playwright.*;

public class HaddajiLLM {
    private static DeepseekClient client;

    static {
        Playwright playwright = Playwright.create();
        client = new DeepseekClient(playwright);
    }

    public static String haddaji_simple_llm(String userInput) throws Exception {
        client.loginIfNeeded();
        return client.sendMessage(userInput);
    }

    public static void close() {
        client.close();
    }
}
