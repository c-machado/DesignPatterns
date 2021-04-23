import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductPurchaseTest {

    private WebDriver driver;
    private static String purchaseEmail;
    private static String puchaseOrderNumber;

    @BeforeMethod
    public void testInit() {
        //todo webdriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void testCleanup() {
        driver.quit();
    }

    @Test
    public void completePurchaseSuuccesfully_whenNewClient() throws InterruptedException {
        driver.navigate().to("http://demos.bellatrix.solutions/");
        //todo *
//        var addToCartFalcon9 = driver.findElement(By.cssSelector("a[href='?add-to-cart=28']"));
        var addToCartFalcon9 = driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        Thread.sleep(5000);
//        var couponCodeTextField = driver.findElement(By.id());
//        couponCodeTextField.clear();
//        couponCodeTextField.sendKeys("happybirthday");
//        var applyCouponButton = driver.findElement(By.cssSelector());
//        applyCouponButton.click();
//        Thread.sleep(5000);
//        var messageAlert = driver.findElement(By.cssSelector());
//        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

    }
}
