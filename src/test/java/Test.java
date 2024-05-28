import Actions.BrowserAction;
import POM.Document;
import POM.HomePage;
import org.testng.annotations.BeforeTest;


public class Test {
    @BeforeTest
    void setup() {
        BrowserAction browserAction = new BrowserAction();
        browserAction.initBrowser(BrowserAction.BrowserType.edge);
    }



    @org.testng.annotations.Test
     void testBrowserNavigation() {
        HomePage home=new HomePage();
        home.navigateToHome();
        home.pressOtherDocument();

        Document doc=new Document();
        doc.checkDocPageLoaded();
    }
}
