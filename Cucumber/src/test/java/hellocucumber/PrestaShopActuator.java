package hellocucumber;

import io.cucumber.java.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.time.Duration;

public class PrestaShopActuator {
    private WebDriver driver;
    private static WebDriverWait wait;

    public PrestaShopActuator(WebDriver driver) {
        this.driver = driver;
    }
    public void initSessionAsUser(String webDriver, String path) {
        // webDriver = "webdriver.chrome.driver"
        System.setProperty(webDriver, path);
        // new chrome driver object
        this.driver = new ChromeDriver();

        // new web driver wait -> waits until element are loaded (40 sec max)
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get("http://localhost/prestashop");

        // maximize the window - some web apps look different in different sizes
        driver.manage().window().setPosition(new Point(700, 5));
    }

    public void loginAsUser() {
        System.out.println("Logging in as user...");
        //TODO: Implement login functionality
        /*driver.findElement(By.id("login-link")).click();
        driver.findElement(By.id("email")).sendKeys("user@example.com");
        driver.findElement(By.id("password")).sendKeys("password123");
        driver.findElement(By.id("submit-login")).click();*/
    }

    public void addProductToCart(String productName, int quantity) {
        System.out.println("Adding product to cart...");
        //TODO: Implement add product to cart functionality
        /*
        driver.findElement(By.linkText(productName)).click();
        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys(String.valueOf(quantity));
        driver.findElement(By.id("add-to-cart-button")).click();*/
    }

    public void proceedToCheckout() {
        System.out.println("Proceeding to checkout...");
        driver.findElement(By.cssSelector("a.checkout-button")).click();
    }

    public boolean verifyCheckoutSuccess() {
        System.out.println("Verifying checkout success...");
        return driver.findElement(By.id("order-confirmation")).isDisplayed();
    }

    public String getConfirmationMessage() {
        System.out.println("Getting confirmation message...");
        return driver.findElement(By.id("order-confirmation-message")).getText();
    }
}
