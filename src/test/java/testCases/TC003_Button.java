package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ButtonPage;

public class TC003_Button extends BaseClass {

    private ButtonPage buttonPage;

    @BeforeMethod
    public void TC003_Button1(){
        this.buttonPage =new ButtonPage(driver);
    }

    @Test
    public void buttonTest(){

        buttonPage.buttonActions();


    }
}


