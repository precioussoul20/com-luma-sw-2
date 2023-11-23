package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() throws InterruptedException {
         // click on the create an account link
        driver.findElement(By.linkText("Create an Account")).click();
        Thread.sleep(3000);

        // Verify the text
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        // click on the create an account link
        driver.findElement(By.linkText("Create an Account")).click();
        Thread.sleep(3000);

        // Enter first name
        driver.findElement(By.id("firstname")).sendKeys("Heelenas");
        Thread.sleep(3000);

        //Enter Last name
        driver.findElement(By.id("lastname")).sendKeys("Bindaass1");
        Thread.sleep(3000);

        //Enter Email
        driver.findElement(By.id("email_address")).sendKeys("bindassHeel@gmail.com");
        Thread.sleep(3000);

        // Enter password
        driver.findElement(By.xpath("(//input[@name='password'])[1]")).sendKeys("Heelbindass123!");
        Thread.sleep(3000);

        // Enter Confirm password
        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Heelbindass123!");
        Thread.sleep(3000);

        //Click on Create an account button
        driver.findElement(By.xpath("//button[.='Create an Account']")).click();
        Thread.sleep(3000);

        //Verify the text
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[.='Thank you for registering with Main Website Store.']")).getText();
        Assert.assertEquals(expectedText,actualText);

        //click on down arrow near welcome
        driver.findElement(By.xpath("(//button[@class='action switch'])[1]")).click();
        Thread.sleep(3000);

        //Click on sign out link
        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(3000);

        //Verify the text
        String expectedText1 = "You are signed out";
        String actualText1 = driver.findElement(By.xpath("//span[@class='base' and @data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedText1, actualText1);


        //


    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
