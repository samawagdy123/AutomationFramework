package POM;

import Actions.UI;

public class Document {
    UI uiAction=new UI();
    String docNameExampleElement = "//div[@class='left' and contains(text(), 'File a Lien')]";

    public void checkDocPageLoaded(){
        uiAction.checkPageLoaded(UI.Locator.Xpath,docNameExampleElement);
    }
}
