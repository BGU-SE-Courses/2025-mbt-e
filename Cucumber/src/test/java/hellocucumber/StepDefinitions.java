package hellocucumber;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;


public class StepDefinitions {
    private static PrestaShopActuator prestaShopUser;
    private String webDriver = "webdriver.chrome.driver";
    private String path = "C:\\Users\\nofar\\OneDrive - post.bgu.ac.il\\semester E\\QA\\tasks\\task4\\2025-mbt-e\\Selenium\\chromedriver-win64\\chromedriver.exe";
    private static PrestaShopActuatorAdmin prestaShopManager;
    private WebDriver driver;
    private String admin_path = "C:\\Users\\yuval\\OneDrive\\Desktop\\studies\\third year\\Semester A\\QS\\ass4\\chromedriver-win64\\chromedriver.exe";

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

    public void PrestaShopInitAdmin() {
        System.out.println("--------------- INITIALIZING PRESTASHOP TEST - ADMIN SESSION ---------------");
//        System.setProperty(webDriver, admin_path);
//        driver = new ChromeDriver();
        prestaShopManager = new PrestaShopActuatorAdmin(driver);
        prestaShopManager.initSessionAsAdmin();
    }

    @Given("Admin is on PrestaShop admin panel")
    public void adminIsOnPrestaShopAdminPanel() {
        System.setProperty(webDriver, admin_path);
        driver = new ChromeDriver();
        prestaShopManager = new PrestaShopActuatorAdmin(driver);
        prestaShopManager.initSessionAsAdmin();
    }

    @And("Admin is logged in with valid credentials")
    public void adminIsLoggedInWithValidCredentials() {
        prestaShopManager.loginAsAdmin();
    }

    @When("Admin navigates to the product Hummingbird notebook in the Products catalog page")
    public void adminNavigatesToTheProductHummingbirdNotebookInTheProductsCatalogPage() {
        prestaShopManager.navigateToCatalog();
        prestaShopManager.selectProduct();
    }

    @And("Admin sets maximum quantity to {int} in the Stocks tab")
    public void adminSetsMaximumQuantityInTheStocksTab(int quantity) {
        prestaShopManager.updateMaxQuantity();
    }

    @And("Product maximum quantity should be set to {int}")
    public void productMaximumQuantityShouldBeSetTo(int expectedQuantity) {
        prestaShopManager.CheckTheChanges();
    }

    @After
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

}
