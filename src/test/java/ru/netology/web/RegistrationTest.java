package ru.netology.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationTest {
    LocalDate currentDate = LocalDate.now().plusDays(3);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedCurrentDate = currentDate.format(formatter);


    @Test
    void formRegistrationTest()  {
        open("http://localhost:9999/");
        $("[data-test-id=city] input").setValue("Москва");
        $(By.xpath("//input[@placeholder='Дата встречи']")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        $(By.xpath("//input[@placeholder='Дата встречи']")).setValue(formattedCurrentDate);
        $("[data-test-id=name] input").setValue("Алексей Яшин");
        $("[data-test-id=phone] input").setValue("+79123456789");
        $("[data-test-id=agreement]").click();
        $(".button").shouldHave(text("Забронировать")).click();
        $("[data-test-id=notification]").should(visible, Duration.ofSeconds(15));
    }


}

