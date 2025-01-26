package hellocucumber;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PrestaShopActuator {
    private WebDriver driver;
    private static WebDriverWait wait;

    public void initSessionAsUser(String webDriver, String path) {
        System.out.println("Customer is in initSessionAsUser...");
        // webDriver = "webdriver.chrome.driver"
        System.setProperty(webDriver, path);
        // new chrome driver object
        System.out.println("Im here!!!!!...");
        this.driver = new ChromeDriver();
        System.out.println("Im here...");

        driver.get("http://localhost:8080");
        System.out.println("Driver got http://localhost:8080...");
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.manage().window().maximize();
    }

    public void addProductToCart(String productName, int quantity) {
        System.out.println("Adding product to cart...");
        WebElement searchBox = driver.findElement(By.xpath("//form[1]/input[2]"));
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(300);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//picture[1]/img[1]")).click(); //click on the first product

        driver.findElement(By.xpath("//span[3]/button[1]/i[1]")).click(); //click on the add to cart button

        driver.findElement(By.xpath("//div[1]/div[2]/button[1]")).click();

        try {
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public void proceedToCheckout() {
        System.out.println("Proceeding to checkout...");
        driver.findElement(By.xpath("//div[2]/div[1]/div[1]/a[1]")).click(); //click on the cart button
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//div[2]/div[1]/div[2]/div[1]/a[1]")).click(); //click on the checkout button

        try {
            Thread.sleep(300);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id='field-id_gender-2']")).click(); //click on the Mrs. radio button
        driver.findElement(By.xpath("//*[@id='field-firstname']")).sendKeys("Keren");
        driver.findElement(By.xpath("//*[@id='field-lastname']")).sendKeys("Gorelik");
        driver.findElement(By.xpath("//*[@id='field-email']")).sendKeys("kerengo@gmail.com");

        // Scroll down using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 620);"); // Scroll down by 620 pixels

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//div[8]/div[1]/span[1]/label[1]/input[1]")).click(); //click on the terms of service checkbox
        driver.findElement(By.xpath("//div[10]/div[1]/span[1]/label[1]/input[1]")).click(); //click on the privacy policy checkbox
        driver.findElement(By.xpath("//div[1]/form[1]/footer[1]/button[1]")).click(); //click on the continue button

        // Scroll down using JavascriptExecutor
        js.executeScript("window.scrollBy(0, 500);"); // Scroll down by 500 pixels

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id='field-address1']")).sendKeys("18 Rue de Rivoli"); //fill in the address
        driver.findElement(By.xpath("//*[@id='field-city']")).sendKeys("Paris"); //fill in the city
        driver.findElement(By.xpath("//*[@id='field-postcode']")).sendKeys("75001"); //fill in the postcode
        (new Select(driver.findElement(By.xpath("//*[@id='field-id_country']")))).selectByVisibleText("France"); //select France from the country dropdown
        driver.findElement(By.xpath("//section[2]/div[1]/div[1]/form[1]/div[1]/div[1]/footer[1]/button[1]")).click(); //click on the continue button

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[2]/form[1]/button[1]")).click(); //click on the continue button

        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//*[@id='payment-option-3']")).click(); //click on the check payment option
        driver.findElement(By.xpath("//*[@id='conditions_to_approve[terms-and-conditions]']")).click(); //click on the terms of service checkbox
        driver.findElement(By.xpath("//div[3]/div[1]/button[1]")).click(); //click on the order with an obligation to pay button


    }

    public boolean checkoutSucceeded() {
        System.out.println("Checking if checkout succeeded...");

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL: " + currentUrl);

        driver.quit();

        // Verify that the URL contains "/order-confirmation"
        return currentUrl.contains("/order-confirmation");
    }
}
