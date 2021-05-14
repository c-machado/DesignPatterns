package instrumentedcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//CONCRETE COMPONENT: It derives from the abstract ELEMENT (component) class
public class WebCoreElement extends Element {
    private final WebDriver webDriver;
    private final WebElement webElement;
    private final By by;

    //One of the parameters it accepts is the WebElement, which in this case is the COMPONENT. We use composition to
    // have an instance of the native WebElement and we keep a reference to the By locator (for further implementation of the click method)
    public WebCoreElement(WebDriver webDriver, WebElement webElement, By by) {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.by = by;
    }

    @Override
    public By getBy() {
        return by;
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public Boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        Thread.sleep(500);
        webElement.clear();
        webElement.sendKeys(text);
    }

    @Override
    public void click() {
        waitToBeClickable(by);
        webElement.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    //We wait for the element to be clickable via the WebDriverWait class using the By locator reference
    private void waitToBeClickable(By by) {
        var webDriverWait = new WebDriverWait(webDriver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
