package uk.co.ms.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.seleniumhq.selenium.fluent.FluentBy;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.seleniumhq.selenium.fluent.Period;

/**
 * This page object represents the shirt page showing a single shirt for the Marks and Spencer website.
 *
 * @author Carl Jokl
 * @since 08/09/15.
 */
public class ShirtPage extends AbstractPage {

    private static final String PAGE_URL = "http://www.marksandspencer.com/pure-cotton-slim-fit-geometric-print-shirt/p/p22395074";

    /**
     * Create an instance of the individual shirt page for the site.
     *
     * @param driver The Selenium WebDriver used to drive the page in the browser.
     */
    public ShirtPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    public ShirtPage open() {
        getWebDriver().get(PAGE_URL);
        within(Period.secs(5)).div(By.id("main-nav")).isDisplayed();
        return this;
    }

    public ShirtPage addToBasket() {
        FluentWebElement purchaseJourney = within(Period.secs(8)).ul(FluentBy.className("inStockSwatch"));
        FluentWebElement sizeTable = purchaseJourney.div(By.className("size-table-wrapper")).table();
        //FluentWebElement colour = purchaseJourney.input(By.name("colour"));
        //colour.ifInvisibleWaitUpTo(Period.secs(5));
        //colour.click();
        FluentWebElement size = sizeTable.input(By.id("15DUMMY"));
        if (!size.isSelected().value()) {
            size.click();
            //Short delay to make sure selection is successful.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        purchaseJourney.input(FluentBy.attribute("type", "submit")).submit();
        return this;
    }
}
