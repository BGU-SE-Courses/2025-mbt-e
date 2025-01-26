package hellocucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrestaShopActuatorAdmin {
    private WebDriver driver;
    private WebDriverWait wait;

    public PrestaShopActuatorAdmin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);  // Using seconds directly
    }

    public void initSessionAsAdmin() {
        System.out.println("Initializing admin session...");
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/admina");
    }

    public void loginAsAdmin() {
        System.out.println("Logging in as admin...");
        // locate the username input box and enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='email']"))).sendKeys("demo@prestashop.com");
        // locate the password input box and enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='passwd']"))).sendKeys("prestashop_demo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[3]/button[1]"))).click();
        // Wait for dashboard to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div/h1")));
    }

    public void navigateToCatalog() {
        System.out.println("Navigating to catalog...");
        // Wait for and click the Catalog menu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"subtab-AdminCatalog\"]"))).click();
        // Wait for and click Products submenu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"subtab-AdminProducts\"]"))).click();
        // Wait for products page to load
        wait.until(ExpectedConditions.titleContains("Products"));
    }

    public void selectProduct() {
        System.out.println("Selecting product...");
        // Click edit on the first product in the list
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[1]/td[9]/a[1]"))).click();
        // Wait for product edit page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[1]/div[1]/div[1]/label[1]")));
    }

    public void updateMaxQuantity() {
        System.out.println("Setting maximum quantity to 1");
        // check the current quantity
        String curr_stock_str = driver.findElement(By.xpath("//div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]")).getText();
        int curr_stock = Integer.parseInt(curr_stock_str);
        int new_stock = -curr_stock + 1;
        // update the quantity to remove
        WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product_stock_quantities_delta_quantity_delta']")));
        quantityInput.clear();  // Clear the input field first
        quantityInput.sendKeys(String.valueOf(new_stock));  // Then send the new value
        // click on save
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='product_footer_save']"))).click();
        // wait for the success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[1]/div[3]")));
    }

    public void CheckTheChanges(){
        // Wait for and click Products submenu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"subtab-AdminProducts\"]"))).click();
        // check the current quantity'
        String curr_stock_str =  driver.findElement(By.xpath("//tr[1]/td[9]/a[1]")).getText();
        int curr_stock = Integer.parseInt(curr_stock_str);
        // Check if current stock equals 1
        if (curr_stock != 1) {
            throw new RuntimeException("Stock quantity " + curr_stock + " is not equal to 1");
        }
    }
}