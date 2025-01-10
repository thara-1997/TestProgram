package TestSuites;

import Pages.CertificationPage;
import org.testng.annotations.Test;

public class TC_CertificationPage extends BaseClass{
    @Test
    public void verifySuccessfulCertPageLoading(){
        CertificationPage certificationPage = new CertificationPage(driver);
        certificationPage.clickNavigateCertification();
        certificationPage.clickCheckboxClassroomCourses();
        certificationPage.unClickCheckboxClassroomCourses();
        certificationPage.clickCertificationTile();
        certificationPage.clickCourseTileOne();
    }
}
