
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    public static void main(String[] args) throws InterruptedException {
        // CREATE NEW OBJECT
        SampleTest sampleTest = new SampleTest();
        sampleTest.invalidCredentialsTest();
        sampleTest.loginValidationTest();


    }

    // WE HAVE CREATED TWO METHOD BELOW
    public void invalidCredentialsTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println("LOGIN INVALID CREDENTIALS");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//button[@type='submit']")).click();

        if (driver.findElement(By.xpath("//p [text()='Invalid credentials']")).isDisplayed()) {
            System.out.println("Invalidate Case is Passed");
        } else {
            System.out.println("Invalidate Case is Failed");
        }
        driver.close();
    }

    public void loginValidationTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        System.out.println("LOGIN TEST");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();
        Thread.sleep(2000);

        if (driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed()) {
            System.out.println("Login - Passed");
        } else {
            System.out.println("Login - Failed");
        }
        driver.close();

    }
}


//WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        System.out.println("LOGIN TEST");
//        driver.get("https://opensource-demo.orangehrmlive.com/");
//        WebElement usernameInput = waitForElement( driver, "//input[@name='username']");