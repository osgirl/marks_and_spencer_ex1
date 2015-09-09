package uk.co.ms.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.FluentWebElements;
import org.seleniumhq.selenium.fluent.Period;

/**
 * This page object represents the formal shirts page (containing various shirts) for the Marks and Spencer website.
 *
 * @author Carl Jokl
 * @since 08/09/15.
 */
public class FormalShirtsPage extends AbstractPage {

    private static final String PAGE_URL = "http://www.marksandspencer.com/l/men/formal-shirts/";

    /**
     * Create an instance of the formal shirts page for the site.
     *
     * @param driver The Selenium WebDriver used to drive the page in the browser.
     */
    public FormalShirtsPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public FormalShirtsPage open() {
        getWebDriver().get(PAGE_URL);
        within(Period.secs(5)).div(By.id("main-nav")).isDisplayed();
        return this;
    }

    public ShirtPage clickOnShirt() {
        within(Period.secs(8)).form(By.id("filter-listings"));
        final FluentWebElement page = within(Period.secs(5)).div(By.id("product-listing-page"));
        page.ifInvisibleWaitUpTo(Period.secs(5));
        final FluentWebElement listing = page.div(By.id("product-listing"));
        final FluentWebElement gridView = listing.ol();
        final FluentWebElement firstItem = gridView.li();
        firstItem.link(By.className("prodAnchor")).click();
        return new ShirtPage(delegate);
    }
}
