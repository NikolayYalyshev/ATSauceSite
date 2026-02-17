package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$x;

public class ShoppingCart {

    private final ElementsCollection addItemsToCart = $$x("//div[@data-test='inventory-item']");

    private final ElementsCollection productName = $$x("//div[@data-test='inventory-item-name']");


    public ShoppingCart checkOneItemAddedCart() {
        addItemsToCart.shouldHave(size(1));
        return this;
    }

    public ShoppingCart checkProductNameMatchesAdded(String name) {
        productName.shouldHave(itemWithText(name));
        return this;
    }
}
