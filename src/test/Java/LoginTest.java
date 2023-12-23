

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTest {

        public WebElement waitForElement (WebDriver driver, String xpath) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return element;
        }

        // below is to close all tabs even if failed and pass (before/after method)
    public WebDriver driver;
@BeforeMethod
public void setup(){
    WebDriverManager.chromedriver().setup();
    //WebDriver driver = new ChromeDriver();
    driver = new ChromeDriver();
    System.out.println("LOGIN INVALID CREDENTIALS");
    driver.get("https://opensource-demo.orangehrmlive.com/");
    WebElement usernameInput = waitForElement( driver, "//input[@name='username']");
}

@AfterMethod
public void teardown(){
    driver.quit();
}

    @Test
    public void invalidCredentialsTest() throws InterruptedException {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
        driver.findElement(By.xpath("//button")).click();
        WebElement invalidCredentialsElement = waitForElement( driver, "//p[text()='Invalid credentials']");

        // replace if else with assertion below
     /*   if (invalidCredentialsElement.isDisplayed()) {
            System.out.println("Invalidate Case is Passed");
        } else {
            System.out.println("Invalidate Case is Failed");
        } */

        // assertion
        Assert.assertTrue(invalidCredentialsElement.isDisplayed(), "Invalid Credentials message is not displayed");
        }

    @Test
    public void loginWithValidCredentialsTest() throws InterruptedException {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();
        WebElement dashboardElement = waitForElement( driver, "//h6[text()='Dashboard']");

     /*   if (dashboardElement.isDisplayed()) {
            System.out.println("Login - Passed");
        } else {
            System.out.println("Login - Failed");
        }  */

        Assert.assertTrue(dashboardElement.isDisplayed(),"Login failed");
        driver.close();
    }
}


