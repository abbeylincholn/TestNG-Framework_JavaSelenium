import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIM extends BaseTestAuth {
    @Test
    public void configuration(){

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        WebElement PIMElement = waitForElement("//h6[text()='PIM']");
        driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")).click();
        WebElement ConfElement = waitForElement("//span[contains(text(),'Configuration')]");
        Assert.assertTrue(ConfElement.isDisplayed(),"PIM pass");
    }

    @Test
    public void EmployeeInfo() {


        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        WebElement employeeElement = waitForElement("//a[text()='Employee List']");

        driver.findElement(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")).click();

        WebElement optionElement = waitForElement("//div[@role='option']//span[contains(text(),'Full-Time Permanent')]");
        optionElement.click();

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        WebElement selectPerm = waitForElement("//span[text()=' (5) Records Found']");

        Assert.assertTrue(selectPerm.isDisplayed(), "(5) Records Found");














    }
}
