package uk.co.ms.testing.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * This is a static factory used to create instances of a Selenium WebDriver based on the current
 * WebDriver type stored in configuration.
 *
 * @author Carl Jokl
 * @since @since 08/09/15
 */
public class DriverFactory {

    /**
     * Default WebDriver to use if no other type is specified.
     */
    public static final String DEFAULT_DRIVER_NAME = "firefox";

    /**
     * Create a new Selenium WebDriver using the currently configured driver.
     *
     * @return A Selenium WebDriver based on the currently configured driver type.
     */
    public static WebDriver createDriver() {
        return createDriver(System.getProperty("webdriver", System.getenv("webdriver")));
    }

    /**
     * Create a Selenium WebDriver of the type that corresponds with the specified name.
     *
     * @param name The name of the Selenium WebDriver to be instantiated.
     * @return An instance of the Selenium WebDriver for the specified driver type.
     */
    public static WebDriver createDriver(String name) {
        if (name == null) {
            name = DEFAULT_DRIVER_NAME;
        }
        else {
            name = name.trim().toLowerCase();
            if (name.isEmpty()) {
                name = DEFAULT_DRIVER_NAME;
            }
        }
        if ("firefox".equals(name)) {
            return new FirefoxDriver();
        }
        else if ("chrome".equals(name)) {
            return new ChromeDriver();
        }
        else if ("ie".equals(name) || "iexplorer".equals(name) || "internetexplorer".equals(name)) {
            return new InternetExplorerDriver();
        }
        else {
            throw new IllegalArgumentException(String.format("The driver type %s is not recognised!", name));
        }
    }
}
