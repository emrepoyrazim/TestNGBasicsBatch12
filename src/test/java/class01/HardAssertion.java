package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertion {
    WebDriver driver;

    //go to syntax login
    // enter wrong crdentails
    // verify the message is "invalid Credentals"

    @BeforeMethod
    public void OpenBrowswe(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test
    public void VerfyCredentials(){
        String expectedText= "Invalid credentials 123";
        WebElement Username=driver.findElement(By.id("txtUsername"));
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(text,expectedText);
        //hardAssertion geçmezse koda devam edilmez


        //assert if username text box is dispalyed
        boolean displayed = Username.isDisplayed();
        //assertion if it is actually displayed or not
        System.out.println("helloworld");
        Assert.assertTrue(displayed);
    }

    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }

}
