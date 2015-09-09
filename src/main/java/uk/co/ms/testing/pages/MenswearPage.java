package uk.co.ms.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.Period;

/**
 * This page object represents the menswear page (containing shirts) for the Marks and Spencer website.
 *
 * @author Carl Jokl
 * @since 08/09/15.
 */
public class MenswearPage extends AbstractPage {

    private static final String PAGE_URL = "http://www.marksandspencer.com/c/men";

    /**
     * Create an instance of the menswear page for the site.
     *
     * @param driver The Selenium WebDriver used to drive the page in the browser.
     */
    public MenswearPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public MenswearPage open() {
        getWebDriver().get(PAGE_URL);
        within(Period.secs(5)).div(By.id("main-nav")).isDisplayed();
        return this;
    }

    public FormalShirtsPage clickOnFormalShirts() {
        within(Period.secs(2)).link(By.linkText("Formal Shirts")).click();
        return new FormalShirtsPage(delegate);
    }
}
