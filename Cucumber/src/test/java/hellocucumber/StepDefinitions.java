package hellocucumber;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    private static PrestaShopActuator prestaShopUser;
    private static PrestaShopActuatorAdmin prestaShopManager;
    private WebDriver driver;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\keren\\Desktop\\תרגולים\\DRIVER\\chromedriver-win64\\chromedriver.exe";

    public void PrestaShopInitUser() {
        System.out.println("--------------- INITIALIZING PRESTASHOP TEST - USER SESSION ---------------");
        driver = new ChromeDriver();
        prestaShopUser = new PrestaShopActuator(driver);
        prestaShopUser.initSessionAsUser(webDriver, path);
    }

    public void PrestaShopInitAdmin() {
        System.out.println("--------------- INITIALIZING PRESTASHOP TEST - ADMIN SESSION ---------------");
        System.setProperty(webDriver, path);
        driver = new ChromeDriver();
        prestaShopManager = new PrestaShopActuatorAdmin(driver);
        prestaShopManager.initSessionAsAdmin();
    }

    @Given("the product \"Mug The best is yet to come\" is available with a stock of more than 2")
    public void productIsAvailable() {
        PrestaShopInitAdmin();
        System.out.println("Verifying product availability...");
        prestaShopManager.loginAsAdmin();
        prestaShopManager.setProductStock("Mug The best is yet to come", 3); // Setting stock to more than 2
        driver.quit();
    }

    @And("a customer adds 2 \"Mug The best is yet to come\" items to the cart")
    public void customerAddsItemsToCart() {
        PrestaShopInitUser();
        System.out.println("Customer adding items to the cart...");
        prestaShopUser.loginAsUser();
        prestaShopUser.addProductToCart("Mug The best is yet to come", 2); // Adding 2 items
    }

    @When("the customer proceeds to checkout")
    public void customerProceedsToCheckout() {
        System.out.println("Customer proceeding to checkout...");
        prestaShopUser.proceedToCheckout();
    }

    @Then("the checkout process should succeed")
    public void checkoutProcessShouldSucceed() {
        System.out.println("Verifying if the checkout process succeeded...");
        boolean isCheckoutSuccessful = prestaShopUser.verifyCheckoutSuccess();
        assertTrue(isCheckoutSuccessful, "Checkout process did not succeed.");
    }

    @And("the customer should see a confirmation message \"Order placed successfully \"")
    public void customerShouldSeeConfirmationMessage() {
        System.out.println("Verifying confirmation message...");
        String confirmationMessage = prestaShopUser.getConfirmationMessage();
        assertTrue(confirmationMessage.contains("Order placed successfully"), "Expected confirmation message not displayed.");
        driver.quit();
    }



}
