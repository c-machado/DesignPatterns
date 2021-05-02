package webdriverwait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductPurchaseTest {
    private WebDriver driver;
    private static String purchaseEmail;
    private static String purchaseOrderNumber;

    @BeforeMethod
    // this  will be started for every test and closed after its completition
    public void testInit() {
        //to download the correct version of the selected browser's driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void testCleanup() {
        driver.quit();
    }

    @Test(priority = 1)
    public void completePurchaseSuuccesfully_whenNewClient() throws InterruptedException {
        driver.navigate().to("http://demos.bellatrix.solutions/");
        //todo *

        waitToBeClickable(By.cssSelector("[data-product_id*='28']"));
        var addToCartFalcon9 = waitAndFindElement(By.cssSelector("a[href='?add-to-cart=28']"));
        addToCartFalcon9.click();

        var viewCart = waitAndFindElement(By.cssSelector(".added_to_cart"));
        viewCart.click();

        var couponCodeTextField = waitAndFindElement(By.id("coupon_code"));
        couponCodeTextField.clear();
        couponCodeTextField.sendKeys("happybirthday");

        waitToBeClickable(By.cssSelector("[name='apply_coupon']"));
        var applyCouponButton = waitAndFindElement(By.cssSelector("[name='apply_coupon']"));
        applyCouponButton.click();
        Thread.sleep(4000);

        var messageAlert = waitAndFindElement(By.cssSelector(".woocommerce-message"));
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = waitAndFindElement(By.cssSelector(".quantity input"));
        quantityBox.clear();
        quantityBox.sendKeys("2");

        var updateCar = driver.findElement(By.cssSelector("[name='update_cart']"));
        updateCar.click();
        Thread.sleep(5000);

        var totalPrice = waitAndFindElement(By.cssSelector("[data-title='Total'] " +
                "span.woocommerce-Price-amount"));
        Assert.assertEquals("114.00€", totalPrice.getText());

        var checkoutCta = driver.findElement(By.cssSelector(".checkout-button"));
        checkoutCta.click();

        var firstName = driver.findElement(By.id("billing_first_name"));
        firstName.sendKeys("Carolina");

        var lastName = driver.findElement(By.id("billing_last_name"));
        lastName.sendKeys("Machado");
        Select billingCountry = new Select (driver.findElement(By.id("billing_country")));
        billingCountry.selectByValue("CO");
        Thread.sleep(5000);

        var streetAddress = driver.findElement(By.id("billing_address_1"));
        streetAddress.sendKeys("Cra 7f # 145-12");

        var city = driver.findElement(By.id("billing_city"));
        city.sendKeys("Bogotá");

        var country = driver.findElement(By.id("billing_state"));
        country.sendKeys("Bogotá");

        var phone = driver.findElement(By.id("billing_phone"));
        phone.sendKeys("3002114915");

        var email = waitAndFindElement(By.id("billing_email"));
        email.sendKeys("info@yahoo.es");
        purchaseEmail = "info@yahoo.es";

        var placeOrder = waitAndFindElement(By.id("place_order"));
        placeOrder.click();

        var orderReceived = driver.findElement(By.cssSelector(".entry-title"));
        Assert.assertEquals(orderReceived.getText(), "Checkout");
    }
//    @Test(priority = 2)
    public void completePurchaseSuccessfullyWithExistingUser() throws InterruptedException {
        driver.navigate().to("http://demos.bellatrix.solutions/");
        var addToCartFalcon9 = driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        Thread.sleep(5000);
        var viewCart = driver.findElement(By.cssSelector(".added_to_cart"));
        viewCart.click();
        var couponCodeTextField = driver.findElement(By.id("coupon_code"));
        couponCodeTextField.clear();
        couponCodeTextField.sendKeys("happybirthday");
        var applyCouponButton = driver.findElement(By.cssSelector("[name='apply_coupon']"));
        applyCouponButton.click();
        Thread.sleep(5000);
        var messageAlert = driver.findElement(By.cssSelector(".woocommerce-message"));
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");
        var quantityBox = driver.findElement(By.cssSelector(".quantity input"));
        quantityBox.clear();
        quantityBox.sendKeys("2");
        Thread.sleep(5000);
        var updateCar = driver.findElement(By.cssSelector("[name='update_cart']"));
        updateCar.click();
        Thread.sleep(4000);
        var totalPrice = driver.findElement(By.cssSelector("[data-title='Total'] " +
                "span.woocommerce-Price-amount"));
        Assert.assertEquals("114.00€", totalPrice.getText());
        Thread.sleep(5000);
        var checkoutCta = driver.findElement(By.cssSelector(".checkout-button"));
        checkoutCta.click();
        var showLogin = driver.findElement(By.cssSelector(".showlogin"));
        showLogin.click();
        var username = driver.findElement(By.id("username"));
        username.sendKeys(purchaseEmail);
        var password = driver.findElement(By.id("password"));
        password.sendKeys(GetUserPasswordFromDb(purchaseEmail));
        var loginCta = driver.findElement(By.cssSelector("button[name='login']"));
        loginCta.click();
        Thread.sleep(5000);
        var placeOrder = driver.findElement(By.id("place_order"));
        placeOrder.click();
        Thread.sleep(5000);
        var orderReceived = driver.findElement(By.cssSelector(".entry-title"));
        Assert.assertEquals(orderReceived.getText(), "Order received");
        var orderNumber = driver.findElement(By.cssSelector("li.woocommerce-order-overview__order"));
        purchaseOrderNumber = orderNumber.getText();
    }
//    @Test(priority = 3)
    public void correctOrderDataDisplayed_whenNavigateToMyOrderSection() throws InterruptedException {
        driver.navigate().to("http://demos.bellatrix.solutions/");
        var myAccountLink = driver.findElement(By.linkText("My account"));
        myAccountLink.click();
        var username = driver.findElement(By.id("username"));
        username.sendKeys(purchaseEmail);
        var password = driver.findElement(By.id("password"));
        password.sendKeys(GetUserPasswordFromDb(purchaseEmail));
        var loginCta = driver.findElement(By.cssSelector("button[name='login']"));
        loginCta.click();
        Thread.sleep(5000);
        var orders = driver.findElement(By.linkText("Orders"));
        orders.click();

        Thread.sleep(5000);
        //todo
        var viewButtons = driver.findElements(By.linkText("View"));
        viewButtons.get(0).click();
        Thread.sleep(5000);

        var orderName = driver.findElement(By.xpath("//h1"));
        String expectedMessage = String.format("ORDER NUMBER #%s", purchaseOrderNumber);
        Assert.assertEquals(expectedMessage, orderName.getText());


    }
    private String GetUserPasswordFromDb(String userName)
    {
        return "@purISQzt%%DYBnLCIhaoG6$";
    }

    private void waitToBeClickable(By by) {
        var webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement waitAndFindElement(By by) {
        var webDriverWait = new WebDriverWait(driver, 30);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private List<WebElement> waitAndFindElements(By by) {
        var webDriverWait = new WebDriverWait(driver, 30);
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

}
