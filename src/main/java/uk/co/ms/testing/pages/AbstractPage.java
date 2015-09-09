package uk.co.ms.testing.pages;

import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentBy;
import org.seleniumhq.selenium.fluent.FluentWebDriver;

/**
 * The base page class for the testing page model containing functionality common to all pages
 * in the Marks & Spencer website.
 *
 * @author Carl Jokl
 * @since 08/09/15.
 */
public abstract class AbstractPage extends FluentWebDriver {

    /**
     * Initialise this AbstractPage by supplying a Selenium WebDriver instance for
     * the browser to be driven for testing.
     *
     * @param driver A Selenium WebDriver instance configured to drive the browser used in testing.
     */
    protected AbstractPage(final WebDriver driver) {
        super(driver);
    }

    /**
     * The implementation of this page must open the page and verify that the page has been opened correctly.
     */
    public abstract AbstractPage open();

    public AbstractPage viewBasket() {
        link(FluentBy.partialLinkText("YOUR BAG")).click();
        return new YourBagPage(delegate);
    }

    /**
     * Get hold of the internal Selenium WebDriver being driven
     * using the fluent APIs.
     *
     * @return The internal Selenium WebDriver used for testing.
     */
    public WebDriver getWebDriver() {
        return delegate;
    }
}
