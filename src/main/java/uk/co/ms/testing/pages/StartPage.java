package uk.co.ms.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.Period;

/**
 * This page object represents the start landing page for the Marks and Spencer website.
 *
 * @author Carl Jokl
 * @since 08/09/15.
 */
public class StartPage extends AbstractPage {

    private static final String PAGE_URL = "http://www.marksandspencer.com";

    /**
     * Create an instance of the start landing page for the site.
     *
     * @param driver The Selenium WebDriver used to drive the page in the browser.
     */
    public StartPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public StartPage open() {
        getWebDriver().get(PAGE_URL);
        within(Period.secs(5)).div(By.id("main-nav")).isDisplayed();
        return this;
    }

    public MenswearPage clickOnMenswear() {
        within(Period.secs(2)).link(By.id("SC_Level_1_586")).click();
        return new MenswearPage(delegate);
    }
}
