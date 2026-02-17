package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class PageLogopassSauce {
    private final SelenideElement loginField = $x("//input[@placeholder='Username']");

    private final SelenideElement passwordField = $x("//input[@placeholder='Password']");

    @Step("Ввожу логин: {login} и пароль: {pass}")
    public ProductsPageSauce enterLogopass (String login, String pass){
       loginField.setValue(login);
        passwordField.setValue(pass).pressEnter();
        return page(ProductsPageSauce.class);
    }

}
