import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class BaseTestAuth extends BaseTest{

    public void performLogin(){

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();
        WebElement dashboardElement = waitForElement("//h6[text()='Dashboard']");
    }

    @BeforeMethod
    public void setup(){
        initialise();
        performLogin(); }
}
