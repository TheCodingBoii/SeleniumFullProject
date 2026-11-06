package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ButtonPage;
import pages.RadioButton;

public class TC005_RadioButton extends BaseClass {
    private RadioButton buttonPage;

    @BeforeMethod
    public void preCondition(){
        this.buttonPage=new RadioButton(driver);
    }

    @Test
    public void radioButtonTest(){
        buttonPage.radiobuttonAction();

    }
}
