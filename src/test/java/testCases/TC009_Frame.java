package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FramePage;

public class TC009_Frame extends BaseClass {
    FramePage framePage;

    @BeforeMethod
    public void frameBefore(){
        this.framePage =new FramePage(driver);
    }

    @Test
    public void FrameTest(){

        framePage.frameAction();

    }
}
