package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class CardDelivery {

    @Test
    void shouldSuccessfulSending() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
    }
}
