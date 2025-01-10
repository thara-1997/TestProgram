package TestSuites;

import Pages.RegisterPage;
import org.testng.annotations.Test;

public class TC_RegisterPage extends BaseClass {

    @Test
    public void verifySuccessfulPersonalInformationAdding(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();
        registerPage.clickAcceptCookie();
        registerPage.setFirstNameFiled("Jessica");
        registerPage.setLastNameFiled("Amy");
        registerPage.setEmailFiled("jessica@gmail.com");
        registerPage.selectDropdownValue("Albania");
        registerPage.setCompanyFiled("Workbay");
        registerPage.clickNextButton();
        registerPage.validateSuccessfulPersonalDataAddition();
    }
    @Test
    public void verifyUnsuccessfulPersonalInformationAdding(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegisterButton();
        registerPage.clickAcceptCookie();
        registerPage.setFirstNameFiled("Jessica");
        registerPage.setLastNameFiled("Amy");
        registerPage.setEmailFiled("jessica");
        registerPage.selectDropdownValue("Albania");
        registerPage.setCompanyFiled("Workbay");
        registerPage.clickNextButton();
        registerPage.validateWorkEmailField();
    }


}
