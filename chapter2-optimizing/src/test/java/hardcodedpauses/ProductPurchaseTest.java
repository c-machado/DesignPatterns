package hardcodedpauses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
//        var addToCartFalcon9 = driver.findElement(By.cssSelector("a[href='?add-to-cart=28']"));
        var addToCartFalcon9 = driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        Thread.sleep(5000);
        var viewCart = driver.findElement(By.cssSelector(".added_to_cart"));
//        var viewCartButton = driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCart.click();
        var couponCodeTextField = driver.findElement(By.id("coupon_code"));
        couponCodeTextField.clear();
        couponCodeTextField.sendKeys("happybirthday");
        var applyCouponButton = driver.findElement(By.cssSelector("[name='apply_coupon']"));
//        var applyCouponButton = driver.findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        Thread.sleep(5000);
        var messageAlert = driver.findElement(By.cssSelector(".woocommerce-message"));
//        var messageAlert = driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");
        var quantityBox = driver.findElement(By.cssSelector(".quantity input"));
//        var quantityBox = driver.findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.clear();
        quantityBox.sendKeys("2");
        Thread.sleep(5000);
        var updateCar = driver.findElement(By.cssSelector("[name='update_cart']"));
//        var updateCart = driver.findElement(By.cssSelector("[value*='Update cart']"));
        updateCar.click();
        Thread.sleep(4000);
        var totalPrice = driver.findElement(By.cssSelector("[data-title='Total'] " +
                "span.woocommerce-Price-amount"));
//        var totalSpan = driver.findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals("114.00€", totalPrice.getText());
        Thread.sleep(5000);
        var checkoutCta = driver.findElement(By.cssSelector(".checkout-button"));
//        var proceedToCheckout = driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        checkoutCta.click();
        var firstName = driver.findElement(By.id("billing_first_name"));
        firstName.sendKeys("Carolina");
        var lastName = driver.findElement(By.id("billing_last_name"));
        lastName.sendKeys("Machado");
        Select billingCountry = new Select (driver.findElement(By.id("billing_country")));
        billingCountry.selectByValue("CO");
        /*var billingCountryWrapper = driver.findElement(By.id("select2-billing_country-container"));
        billingCountryWrapper.click();
        var billingCountryFilter = driver.findElement(By.className("select2-search__field"));
        billingCountryFilter.sendKeys("Germany");
        var germanyOption = driver.findElement(By.xpath("//*[contains(text(),'Germany')]"));
        germanyOption.click();*/
        Thread.sleep(5000);
        var streetAddress = driver.findElement(By.id("billing_address_1"));
        streetAddress.sendKeys("Cra 7f # 145-12");
        var city = driver.findElement(By.id("billing_city"));
        city.sendKeys("Bogotá");
        var country = driver.findElement(By.id("billing_state"));
        country.sendKeys("Bogotá");
        var phone = driver.findElement(By.id("billing_phone"));
        phone.sendKeys("3002114915");
        var email = driver.findElement(By.id("billing_email"));
        email.sendKeys("info@berlinspaceflowers.com");
        purchaseEmail = "info@berlinspaceflowers.com";
        Thread.sleep(5000);
        var placeOrder = driver.findElement(By.id("place_order"));
        placeOrder.click();
        Thread.sleep(5000);
        var orderReceived = driver.findElement(By.cssSelector(".entry-title"));
        Assert.assertEquals(orderReceived.getText(), "Order received");
    }
    @Test(priority = 2)
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
    @Test(priority = 3)
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
}
