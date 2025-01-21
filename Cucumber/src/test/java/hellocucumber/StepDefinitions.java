package hellocucumber;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {
    private static PrestaShopActuator prestaShopUser;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\nofar\\OneDrive - post.bgu.ac.il\\semester E\\QA\\tasks\\task4\\2025-mbt-e\\Selenium\\chromedriver-win64\\chromedriver.exe";

    public void PrestaShopInitUser() {
        System.out.println("--------------- INITIALIZING PRESTASHOP TEST - USER SESSION ---------------");
        prestaShopUser = new PrestaShopActuator();
        prestaShopUser.initSessionAsUser(webDriver, path);
    }

    @Given("The customer is connected to prestashop")
    public void userLoggedIn() {
        System.out.println("Customer is in userLoggedIn...");
        PrestaShopInitUser(); //open presta shop as user
        System.out.println("Customer is connected to prestashop...");
    }

    @And("The customer added {string} with quantity of 2 to cart")
    public void customerAddsItemsToCart(String productName) {
        System.out.println("Customer adding items to the cart...");
        prestaShopUser.addProductToCart(productName, 2); // Adding 2 items
    }

    @When("the customer proceeds to checkout")
    public void customerProceedsToCheckout() {
        System.out.println("Customer proceeding to checkout...");
        prestaShopUser.proceedToCheckout();
    }

    @Then("the checkout process should succeed")
    public void checkoutProcessShouldSucceed() {
        System.out.println("Verifying if the checkout process succeeded...");
        assertTrue(prestaShopUser.checkoutSucceeded());
    }

}
