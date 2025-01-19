package hellocucumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrestaShopActuatorAdmin {
    private WebDriver driver;

    public PrestaShopActuatorAdmin(WebDriver driver) {
        this.driver = driver;
    }

    public void initSessionAsAdmin() {
        System.out.println("Initializing admin session...");
        driver.get("http://localhost/prestashop/admin");
    }

    public void loginAsAdmin() {
        System.out.println("Logging in as admin...");
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).sendKeys("adminpassword123");
        driver.findElement(By.id("submit-login")).click();
    }

    public void setProductStock(String productName, int stock) {
        System.out.println("Setting product stock...");
        driver.findElement(By.id("menu-catalog")).click();
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.xpath("//td[contains(text(),'" + productName + "')]/..//a[contains(text(),'Edit')]")).click();
        driver.findElement(By.id("form_step1_qty_0")).clear();
        driver.findElement(By.id("form_step1_qty_0")).sendKeys(String.valueOf(stock));
        driver.findElement(By.id("submit")).click();
    }
}
