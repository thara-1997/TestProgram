package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RegisterPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public By registerButton = By.xpath("//a[@class='badge'][@href='https://nexus.hexagon.com/home/register/']");
    public By firstNameFiled = By.id("filled-firstName");
    public By lastNameFiled = By.id("filled-lastName");
    public By emailFiled = By.id("filled-email");

    //public By countryFiled = By.id(":Raakqkvf9vakva:");
    public By countryFiled = By.xpath("//div[@role='combobox']");

    public By companyFiled = By.id("filled-companyName");
    public By nextButton = By.id("submit-btn");

    public By emailValidationMessage = By.id("filled-email-helper-text");
    public By successfulPersonalDataAddTitle = By.cssSelector("h4.MuiTypography-root.MuiTypography-h4.font-semibold.mui-1y2wese");


    public By acceptCookie = By.id("onetrust-accept-btn-handler");
    public By option(String optionText) {
        return By.xpath("//li[text()='" + optionText + "']"); // Replace with correct XPath for options
   }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();

    }
    public void clickAcceptCookie(){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookie));
        driver.findElement(acceptCookie).click();
        //delayTimer();
    }

    public void setFirstNameFiled(String firstName){

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       // wait.until(ExpectedConditions.elementToBeClickable(firstNameFiled));

        driver.findElement(firstNameFiled).sendKeys(firstName);
    }

    public void setLastNameFiled(String lastName){
        driver.findElement(lastNameFiled).sendKeys(lastName);
    }

    public void setEmailFiled(String email){
        driver.findElement(emailFiled).sendKeys(email);
        //driver.findElement(acceptCookie).click();
    }

   // public void delayTimer (){
     //   try {
    //        Thread.sleep(5000); // Pause for 2 seconds
    //    } catch (InterruptedException e) {
   //         e.printStackTrace();
  //      }
   // }

    //public void selectCountry(){
        //Select country = new Select(driver.findElement(countryFiled));
        //country.selectByVisibleText("Albania");

        //List<WebElement> countryList = driver.findElements(countryFiled);
        //for(WebElement country: countryList) {
        //    if (country.getText().trim().equals(countryName)) {
         //       country.click();
        //    }
       // }


    //}

    // Method to select a value from the dropdown
    public void selectDropdownValue(String value) {
        // Wait for and click the dropdown
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(countryFiled));
        try {
            dropdownElement.click();
        } catch (Exception e) {
            // Fallback to JavaScript click if normal click fails
            System.out.println("Fuck:- " +e);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", dropdownElement);
        }
        // Wait for and click the desired option
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(option(value)));
        try {
            optionElement.click();
        } catch (Exception e) {
            // Fallback to JavaScript click if normal click fails
            System.out.println("Fuck:- " +e);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", optionElement);
        }
    }

    public void setCompanyFiled(String company){driver.findElement(companyFiled).sendKeys(company);}

    public void clickNextButton(){driver.findElement(nextButton).click();}

    public void validateWorkEmailField(){
      if (driver.findElement(emailValidationMessage).isDisplayed()){
          System.out.println("Please enter a valid email address");
      }
    }

    public void validateSuccessfulPersonalDataAddition(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulPersonalDataAddTitle));
        if(driver.findElement(successfulPersonalDataAddTitle).isDisplayed()){
            System.out.println("Set Password");
        }

    }




}
