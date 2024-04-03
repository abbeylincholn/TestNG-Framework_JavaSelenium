import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    // below is to close all tabs even if failed and pass (before/after method)
    // beforemethod means before every test is done u have to call the driver
    public static WebDriver driver;

    public WebElement waitForElement (String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public void initialise(){
       WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();

//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();
        System.out.println("LOGIN CREDENTIALS");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        WebElement usernameInput = waitForElement("//input[@name='username']");
    }

    @BeforeMethod
    public void setup(){
        initialise();
    }

   @AfterMethod
    public void teardown(){driver.quit();
    }
}
