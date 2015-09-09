package uk.co.ms.testing.pages;

import org.openqa.selenium.WebDriver;

/**
 * This class is a factory used to create each of the page objects (using the page model) and
 * inject into them the Selenium WebDriver and any other required test data.
 *
 * @author Carl Jokl
 * @since 08/09/15
 */
public class PageFactory {

    private final WebDriver driver;

    /**
     * Create an instance of the Page factory to create the various page objects
     * for each web page interacted with as part of the tests.
     *
     * @param driver The Selenium WebDriver used to drive the browser for testing.
     */
    public PageFactory(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Create a start page model.
     *
     * @return A Start Page model.
     */
    public StartPage startPage() {
        return new StartPage(driver);
    }
}
