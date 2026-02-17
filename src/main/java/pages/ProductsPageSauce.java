package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPageSauce {

    private final ElementsCollection productCards = $$x("//div[@class='inventory_item']");

    private final SelenideElement cartButton = $x("//div[@id='shopping_cart_container']");

    @Step("Добавить товар '{productName}' в корзину")
    public ProductsPageSauce findProductAndAddToCart(String productName){
        SelenideElement element = productCards.findBy(text(productName));
        element.$x(".//button[contains(@class, 'btn')]").click();
        return this;
    }

    @Step("Переходим в корзину")
    public ShoppingCart goBasket(){
        cartButton.click();
        return page(ShoppingCart.class);
    }
}
