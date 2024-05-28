package POM;

import Actions.UI;

public class HomePage {

    String homeUrl="https://www.levelset.com/";
    String getPaid = "//a[@class=\"btn btn-info btn-outline mob-dropdown-btn\"]";
    String otherDocElement ="//ul[@class=\"d-flex\"]//a";
    UI uiAction=new UI();


    public void navigateToHome(){
        uiAction.navigation( homeUrl,UI.Locator.Xpath,getPaid);
    }

    public void pressOtherDocument(){
        uiAction.doubleClick(UI.Locator.Xpath,getPaid,UI.Locator.Xpath,String.format(new Document().docNameExampleElement,"File a Lien"));
    }

}
