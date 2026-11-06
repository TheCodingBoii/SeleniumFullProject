package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropDownButton;

public class TC004_Dropdown extends BaseClass {

    private DropDownButton dropDownButton;

    @BeforeMethod
    public void TC004_Dropdown1(){
         this.dropDownButton = new DropDownButton(driver);
    }

    @Test
    public void dropdownTest(){
        dropDownButton.dropdownActions();
    }
}
