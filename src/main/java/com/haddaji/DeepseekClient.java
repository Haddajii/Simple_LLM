package com.haddaji;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class DeepseekClient {
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private boolean loggedIn = false;
    private int lastMessageCount = 0;

    public DeepseekClient(Playwright playwright) {
        this.browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setExecutablePath(Paths.get("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"))
        );
        this.context = SessionManager.loadSession(playwright, browser);
        this.page = context.newPage();
    }

    public void loginIfNeeded() throws Exception {
        if (loggedIn) return;
        page.navigate("https://chat.deepseek.com/");
        page.waitForTimeout(3000);
        if (page.locator("text=Log in").count() > 0) {
            System.out.println("Please log in manually, then press Enter...");
            System.in.read();
            SessionManager.saveSession(context);
        }
        loggedIn = true;
    }

    public String sendMessage(String message) {
        Locator allBlocks = page.locator("div.ds-markdown");
        int oldCount = allBlocks.count();

        page.waitForSelector("textarea[placeholder*='Message DeepSeek']");
        page.fill("textarea[placeholder*='Message DeepSeek']", message);
        page.keyboard().press("Enter");

        Locator newBlock = allBlocks.nth(oldCount);

        while (true) {
            String text = newBlock.innerText().trim();
            boolean isStreaming = !newBlock.locator(".cursor-dot, .typing-dot, .loading-dot, .thinking-spinner").all().isEmpty();
            if (!isStreaming && !text.isEmpty()) break;
            page.waitForTimeout(2000);
        }

        Locator paragraphs = newBlock.locator("p.ds-markdown-paragraph");
        StringBuilder full = new StringBuilder();
        for (int i = 0; i < paragraphs.count(); i++) {
            full.append(paragraphs.nth(i).innerText()).append("\n");
        }

        return full.toString().trim();
    }


    public void close() {
        browser.close();
    }
}

