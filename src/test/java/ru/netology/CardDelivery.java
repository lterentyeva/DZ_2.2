package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class CardDelivery {


    public String nextDate(int days) {
        LocalDate parsedDate = LocalDate.now();
        LocalDate addedDate = parsedDate.plusDays(days);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return addedDate.format(formatter);
    }


    @Test
    void shouldSuccessfulSending() {
        String mittingData = nextDate(5);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("input[placeholder=\"Город\"]").val("Санкт-Петербург");
        $("input[placeholder=\"Дата встречи\"]").doubleClick().sendKeys(mittingData);
        $("input[name=\"name\"]").val("Иванов Иван");
        $("input[name=\"phone\"]").val("+79111234567");
        $("[data-test-id=agreement] span").click();
        $x("//span[text()=\"Забронировать\"]").click();
        $x("//*[contains(text(),\"Встреча успешно забронирована на \")]").should(visible, Duration.ofSeconds(15));
    }
}
