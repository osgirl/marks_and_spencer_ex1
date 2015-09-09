package uk.co.ms.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentBy;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;
import org.seleniumhq.selenium.fluent.Period;

/**
 * This page object represents the your bag showing all the items to be purchased from Marks and Spencer website.
 *
 * @author Carl Jokl
 * @since 08/09/15.
 */
public class YourBagPage extends AbstractPage {

    private static final String PAGE_URL = "http://www.marksandspencer.com/pure-cotton-slim-fit-geometric-print-shirt/p/p22395074";

    /**
     * Create an instance of the "Your Bag" page for the site.
     *
     * @param driver The Selenium WebDriver used to drive the page in the browser.
     */
    public YourBagPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public YourBagPage open() {
        getWebDriver().get(PAGE_URL);
        within(Period.secs(5)).div(By.id("main-nav")).isDisplayed();
        return this;
    }

    /**
     * Verify the item with the specified name is in the bag.
     *
     * @param itemName The name of the item to be verified is in the bag.
     */
    public void verifyInBasket(String itemName) {
        FluentWebElement itemList = within(Period.secs(5)).div(By.className("order-details-wrapper")).table();
        itemList.link(FluentBy.partialLinkText(itemName));
    }
}
