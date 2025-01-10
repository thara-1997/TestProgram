package TestSuites;

import Pages.HomePage;
import org.testng.annotations.Test;

public class TC_HomePage extends BaseClass{

    @Test
    public void verifyCourseTileSelection(){
        HomePage homePage = new HomePage(driver);
        homePage.clickCourseTile();
        homePage.clickButtonEnrollNow();

    }
}
