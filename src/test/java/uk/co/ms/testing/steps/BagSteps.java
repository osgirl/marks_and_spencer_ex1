package uk.co.ms.testing.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.ms.testing.driver.DriverFactory;
import uk.co.ms.testing.pages.AbstractPage;
import uk.co.ms.testing.pages.PageFactory;
import uk.co.ms.testing.pages.StartPage;
import uk.co.ms.testing.pages.YourBagPage;

/**
 * This class provides the glue / test step implementation for the Cucumber Tes Stories.
 * @author Carl Jokl
 * @since 08/09/15.
 */
public class BagSteps {

    private final PageFactory pageFactory = new PageFactory(DriverFactory.createDriver());
    private AbstractPage currentPage;

    @Before
    public void navigateToStart() {
        currentPage = pageFactory.startPage().open();
    }

    @After
    public void closeBrowser() {
        if (currentPage != null) {
            currentPage.getWebDriver().close();
            currentPage = null;
        }
    }

    @Given("I have added a (\\w+) to my bag")
    public void addToBasket(final String item) {
        System.out.printf("Adding: %s to bag\n", item);
        if (currentPage instanceof StartPage) {
            final StartPage startPage = (StartPage) currentPage;
            startPage.clickOnMenswear().clickOnFormalShirts().clickOnShirt().addToBasket();
        }
    }

    @When("I view the contents of my bag")
    public void viewContentsOfMyBag() {
        System.out.printf("Viewing contents of bag\n");
        currentPage.viewBasket();
    }

    @Then("I can see the contents of the bag include a (\\w+)")
    public void contentsOfBagInclude(final String item) {
        System.out.printf("Contents of bad include: %s\n", item);
        if (currentPage instanceof YourBagPage) {
            ((YourBagPage) currentPage).verifyInBasket(item);
        }
    }
}
