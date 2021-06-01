package waitforajax;

import org.openqa.selenium.By;

//ConcreteDecorator that will create the log entries for each action
public class LogElement extends ElementDecorator {

    public LogElement(Element element) {
        super(element);
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        System.out.print(String.format("Element text = %s", element.getText()));
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        System.out.print(String.format("Element enabled = $b", element.isEnabled()));
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        System.out.print(String.format("Element displayed =%b", element.isDisplayed()));
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        System.out.print(String.format("Type text == %s", text));
        element.typeText(text);
    }

    @Override
    public void click() {
        System.out.print("Element clicked");
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        System.out.print("Element clicked");
        return element.getAttribute(attributeName);

    }
}
