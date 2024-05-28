package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class UI {
    By element;
    WebElement webElement;
    public enum Locator  {
        Xpath,
        css,
        id,
        name,
        className,
        tagName,
        linkText
    }
    public WebDriver driver;

    public UI(){
        this.driver= BrowserAction.driver.get();
    }
    public By getSelector(Locator l, String path) {
        switch (l) {
            case id:
                return By.id(path);
            case name:
                return By.name(path);
            case className:
                return By.className(path);
            case tagName:
                return By.tagName(path);
            case linkText:
                return By.linkText(path);
            case css:
                return By.cssSelector(path);
            case Xpath:
                return By.xpath(path);
            default:
                throw new IllegalArgumentException("Invalid locator type: " + l);
        }
    }
    public void waiting(int seconds, ExpectedCondition<?> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(condition);
    }

    public void navigation(String url, Locator expectedLocatorType, String expectedPath) {
        driver.get(url);
        element = getSelector(expectedLocatorType, expectedPath);

        try{
        waiting(30, ExpectedConditions.elementToBeClickable(element));}
        catch (Exception e) {
           // System.out.println("Element not found");
        }

    }

    public void click(Locator actualLocatorType, String actualPath, Locator expectedLocatorType, String expectedPath) {
        element = getSelector(actualLocatorType, actualPath);
        webElement=driver.findElement(element);
        webElement.click();

        element = getSelector(expectedLocatorType, expectedPath);
        webElement=driver.findElement(element);

        waiting(30, ExpectedConditions.visibilityOfElementLocated(element));


    }
    public void doubleClick(Locator actualLocatorType, String actualPath, Locator expectedLocatorType, String expectedPath) {
        element = getSelector(actualLocatorType, actualPath);
        webElement=driver.findElement(element);
        webElement.click();
        webElement.click();

        element = getSelector(expectedLocatorType, expectedPath);
        waiting(30, ExpectedConditions.visibilityOfElementLocated(element));

        webElement=driver.findElement(element);


    }
    public void checkPageLoaded(Locator expectedLocatorType,String path){
        element = getSelector(expectedLocatorType, path);
        webElement=driver.findElement(element);
        waiting(30, ExpectedConditions.visibilityOfElementLocated(element));

    }






}
