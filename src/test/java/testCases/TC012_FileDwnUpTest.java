package testCases;

import base.BaseClass;
import pages.FileDwnUplodPage;

public class TC012_FileDwnUpTest extends BaseClass {
    FileDwnUplodPage fileDwnUplodPage;

    public void preFileUpDwn(){
        this.fileDwnUplodPage = new FileDwnUplodPage(driver);
    }

    public void fileTest(){

        fileDwnUplodPage.dwnUploadAction();
    }
}
