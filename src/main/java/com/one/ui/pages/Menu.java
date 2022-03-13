package com.one.ui.pages;

import com.one.framework.Browser;

import static com.one.locators.LinkText.LOGOUT;
import static com.one.locators.XPathSelector.CLOSE_MENU_BUTTON;
import static com.one.locators.XPathSelector.SORT_SELECTOR;
import org.openqa.selenium.support.ui.Select;

public class Menu {

    private Browser browser;

    public Menu(Browser browser) {
        this.browser = browser;
    }

    public boolean isLogoutVisible() {
        return browser.elementIsDisplayed(LOGOUT);
    }

    public void  closeMenu() {
        browser.click(CLOSE_MENU_BUTTON);
    }

    public void  clickLogout() {
        browser.click(LOGOUT);
    }
    public void clickAndSelectOption(String option){
        Select drpSort=new Select(browser.findElement(SORT_SELECTOR));
        drpSort.selectByVisibleText(option);
    }

}
