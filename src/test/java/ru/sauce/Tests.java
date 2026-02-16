package ru.sauce;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends BaseTests{

    @Feature("Проверка результатов поиска")
    @DisplayName("Проверка результатов поиска c помощью PO")
    @ParameterizedTest(name = "{displayName} {arguments}")
    @MethodSource("helpers.DataProvider#providerGetRecourse")
    public void addCartTest(String login, String pass, String productName){
        open("https://www.saucedemo.com");
        $x("//input[@placeholder='Username']").setValue(login);
        $x("//input[@placeholder='Password']").setValue(pass).pressEnter();
        SelenideElement element = $$x("//div[@class='inventory_item']").findBy(text(productName));
        element.$x(".//button[contains(@class, 'btn')]").click();
        $x("//div[@id='shopping_cart_container']").click();
        $$x("//div[@data-test='inventory-item']").shouldHave(size(1));
        $x("//div[@data-test='inventory-item-name']").shouldHave(text(productName));
        //TODO work with PageObject
    }
}
