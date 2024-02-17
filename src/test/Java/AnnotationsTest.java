import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {

    @BeforeClass
    public void bClass(){
        System.out.println(" Before Class");
    }
   @BeforeMethod
    public void beforeMethod(){
        System.out.println(" Before Method");
    }

    @Test(description = "My Test One")
    public void testOne(){
        System.out.println("Test One");
        Assert.assertTrue(true);
    }


    @Test(description = "My Test Two")
    public void testTwo(){
        System.out.println("Test Two");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println(" After Method");
    }

    @AfterClass
    public void aClass(){
        System.out.println(" After Class");
    }



}
