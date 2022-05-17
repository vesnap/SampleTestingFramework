package com.one;
import com.one.framework.Browser;
import com.one.framework.WebDriverConfig;
import com.one.ui.pages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.*;

import javax.inject.Inject;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@ContextConfiguration(classes = {Cart.class, WebDriverConfig.class, Browser.class, LoginForm.class})
public class AddToCardTest {
    @Autowired
    private Cart cart;
    @Inject
    private Browser browser;
    @Autowired
    private LoginForm loginForm;

    @Test(groups = "valid")
    public void addToCart() {
        cart.addItem(browser);
        cart.clickOnCart(browser);
        assertTrue(cart.isProductPresent(), "Product label not displayed");
        assertTrue(cart.getProductLabel().matches("PRODUCTS"));
    }

    @Test(groups = "remove")
    public void removeFromCart() {
        cart.removeProduct(browser);
        cart.clickOnCart(browser);
        assertFalse(cart.isProductPresent(), "Product label displayed");
    }
    @BeforeClass(alwaysRun = true)
    @Parameters({"username", "password"})
    public void beforeTestMethod(String username, String password) {
        cart = new Cart(browser);
        loginForm.loginAs(username, password);
    }
}
