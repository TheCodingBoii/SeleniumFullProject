package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckBox;

public class TC006_CheckBox extends BaseClass {
    public CheckBox checkBox;

    @BeforeMethod
    public void CheckBox(){
        this.checkBox= new CheckBox(driver);


    }

    @Test
    public void CheckBoxTest(){

        checkBox.CheckBoxAction();
    }
}
