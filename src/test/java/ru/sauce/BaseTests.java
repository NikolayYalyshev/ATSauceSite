package ru.sauce;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTests {

    @BeforeEach
    public void option() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();

        // 1. Отключаем предложение сохранить пароль
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // 2. КРИТИЧНО: Отключаем именно проверку на утечки (то самое окно)
        prefs.put("profile.password_manager_leak_detection", false); //

        options.setExperimentalOption("prefs", prefs);

        // 3. Отключаем Safe Browsing (иногда окно лезет из-за него)
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-infobars");

        // Применяем настройки к Selenide
        Configuration.browserCapabilities = options;
    }

}
