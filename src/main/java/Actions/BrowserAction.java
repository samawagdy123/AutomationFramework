package Actions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Arrays;


public class BrowserAction {
    static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public enum BrowserType  {
        chrome,
        edge,
        firefox
    }
    public enum BrowserNavigate  {
        back,
        forward,
        refresh
    }
    public enum BrowserManagement  {
        min,
        max,
        full
    }

    public void initBrowser(BrowserType browserType){
        switch (browserType) {
            case chrome:
                driver.set(new ChromeDriver());
                browserManagement(BrowserManagement.max);
                break;
            case edge:
                driver.set(new EdgeDriver());
                browserManagement(BrowserManagement.max);
                break;
            case firefox:
                driver.set(new FirefoxDriver());
               browserManagement(BrowserManagement.max);
                break;
        }
    }
  public void browserNavigation(BrowserNavigate navigate ,String...url){
        if (url.length > 1) {
            throw new IllegalArgumentException("Expected one value or no value, but received multiple values");
        } else if (url.length == 0) {
            switch (navigate) {
                case back:
                    driver.get().navigate().back();
                    break;
                case forward:
                    driver.get().navigate().forward();
                    break;
                case refresh:
                    driver.get().navigate().refresh();
                    break;
            }
        }
        else {
            driver.get().navigate().to(Arrays.toString(url));
        }
    }

    public void browserManagement(BrowserManagement browserManagement){
        switch (browserManagement) {
            case min:
                driver.get().manage().window().minimize();
                break;
            case max:
                driver.get().manage().window().maximize();
                break;
            case full:
                driver.get().manage().window().fullscreen();
                break;
        }
    }
    public static void closeDriver(){
        driver.get().quit();
    }



}
