package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CertificationPage {
    WebDriver driver;
    WebDriverWait wait;

    public By navigateCertification = By.xpath("//a[@href='/academy-public/Training/14965']");
    public By checkboxClassroomCourses = By.id("Coursetype18308");
    public By certificationTile = By.xpath("//h2[@title='ESPRIT - New User Milling for ESPRIT TNG Certification']");

    public By courseTileOne = By.xpath("//h4[@title='ESPRIT - 3+2 Milling on a 5-Axis Vertical Mill']");


    public CertificationPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickNavigateCertification(){
        driver.findElement(navigateCertification).click();
    }

    public void clickCheckboxClassroomCourses(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox= wait.until(ExpectedConditions.elementToBeClickable(checkboxClassroomCourses));
        checkbox.click();
        checkbox = driver.findElement(checkboxClassroomCourses);
        if(checkbox.isSelected()){
           System.out.println("Checkbox is Selected");
        }
        else {
           System.out.println("Checkbox is not selected");
       }
    }

    public void unClickCheckboxClassroomCourses() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxClassroomCourses));
        checkbox.click();
        checkbox = driver.findElement(checkboxClassroomCourses);
        if (checkbox.isSelected()) {
            System.out.println("Checkbox is Selected");
        } else {
            System.out.println("Checkbox is not selected");
        }
    }

    public void clickCertificationTile(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,1000)");
        driver.findElement(certificationTile).click();
    }
    public void clickCourseTileOne(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,1000)");
        driver.findElement(courseTileOne).click();
    }

}
