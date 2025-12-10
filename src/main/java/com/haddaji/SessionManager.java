package com.haddaji;

import com.microsoft.playwright.*;

import java.nio.file.*;

public class SessionManager {
    private static final String COOKIE_FILE = "haddaji_deepseek_session.json";

    public static void saveSession(BrowserContext context) {
        context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get(COOKIE_FILE)));
    }

    public static BrowserContext loadSession(Playwright playwright, Browser browser) {
        BrowserContext context;
        if (Files.exists(Paths.get(COOKIE_FILE))) {
            context = browser.newContext(
                    new Browser.NewContextOptions().setStorageStatePath(Paths.get(COOKIE_FILE))
            );
        } else {
            context = browser.newContext();
        }
        return context;
    }
}
