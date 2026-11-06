package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MouseActionPage;

public class TC010_MouseAction extends BaseClass {

    MouseActionPage mouseActionPage;

    @BeforeMethod
    public void beforeMouse(){
        this.mouseActionPage = new MouseActionPage(driver);
    }

    @Test
    public void MouseActionTest(){

        mouseActionPage.MouseAction();
    }
}
