import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void invalidCredentialsTest() {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
        driver.findElement(By.xpath("//button")).click();
        WebElement invalidCredentialsElement = waitForElement("//p[text()='Invalid credentials']");

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
    public void loginWithValidCredentialsTest() {

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();
        WebElement dashboardElement = waitForElement("//h6[text()='Dashboard']");

     /*   if (dashboardElement.isDisplayed()) {
            System.out.println("Login - Passed");
        } else {
            System.out.println("Login - Failed");
        }  */       // if and else is not needed before assert has taken care of.

        Assert.assertTrue(dashboardElement.isDisplayed(),"Login successful");
       // driver.close();
    }
}


