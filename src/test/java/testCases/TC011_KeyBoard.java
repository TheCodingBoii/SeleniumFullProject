package testCases;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.KeyBoardActionPage;

import java.util.List;

public class TC011_KeyBoard extends BaseClass {
    KeyBoardActionPage keyboardAction;

    public void preKeyBoard(){
        this.keyboardAction =new KeyBoardActionPage(driver);
    }

    public void KeyboardTest() throws InterruptedException {


        keyboardAction.KeyBoardAction();
    }


}
