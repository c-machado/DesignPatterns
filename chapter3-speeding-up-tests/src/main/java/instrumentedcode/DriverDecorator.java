package instrumentedcode;

import org.openqa.selenium.By;

import java.util.List;

//Concrete Decorator of driver component

// It inherits Driver class and holds it as a protected variable, using composition


public class DriverDecorator extends Driver{
    protected final Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    //We again override all actions and call the wrapped driver instance.

    @Override
    public void start(Browser browser) {

    }

    @Override
    public void quit() {

    }

    @Override
    public void goToUrl(String url) {

    }

    @Override
    public Element findElement(By locator) {
        return null;
    }

    @Override
    public List<Element> findElements(By locator) {
        return null;
    }
}
