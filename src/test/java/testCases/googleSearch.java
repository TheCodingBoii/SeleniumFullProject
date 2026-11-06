package testCases;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FirstPage;

public class googleSearch extends BaseClass {

    private FirstPage firstpage;

    @BeforeMethod
    public void googleSearc(){
        this.firstpage =new FirstPage(getDriver());


    }

    @Test
    public void firstSearch(){
         firstpage.googleSearch("Colombo");
    }
}
