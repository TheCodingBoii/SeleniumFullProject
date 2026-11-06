package testCases;

import base.BaseClass;
import pages.BrokenImageAndCalander;

public class TC013_ImageCalanderHandle extends BaseClass {
    BrokenImageAndCalander brokenImageAndCalander;

    public void imageCalanderHandle(){
        this.brokenImageAndCalander= new BrokenImageAndCalander(driver);
    }

    public void ImageCalandertest(){

        brokenImageAndCalander.findBrokenImageTest();
        brokenImageAndCalander.findBrokenImageTestTwo();
        brokenImageAndCalander.selectFutureDate("2028","05","14");
        brokenImageAndCalander.selectPastDate("2024","03","10");
    }
}
