package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TC002_TextBox extends BaseClass {
    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void TC002_TextBox(){
        this.textBoxPage=new TextBoxPage(driver);
    }

    @Test
    public void TextBoxTest(){
        textBoxPage.TextBox();

    }
}
