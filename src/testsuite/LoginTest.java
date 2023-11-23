package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    static String baseUrl ="https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        //click on sign in link
        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(3000);

        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("bindassHeel@gmail.com");
        Thread.sleep(3000);

        // Enter valid password
        driver.findElement(By.id("pass")).sendKeys("Heelbindass123!");
        Thread.sleep(3000);

        // click on sign in button
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);

        //verify the Text
        String expectedText = "Welcome, Heelenas Bindaass1!";
        String actualText = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() throws InterruptedException {

        // click on sign in link
        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(3000);

        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("bindassHeel@gmail.com");
        Thread.sleep(3000);

        // Enter invalid password
        driver.findElement(By.id("pass")).sendKeys("Heelbindass!");
        Thread.sleep(3000);

        // click on sign in button
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);

        //verify the Text
        String expectedText1 = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualText1 = driver.findElement(By.xpath("//div[.='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expectedText1, actualText1);
    }
    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {

        //click on sign in link
        driver.findElement(By.partialLinkText("Sign ")).click();
        Thread.sleep(3000);

        //Enter valid Email
        driver.findElement(By.id("email")).sendKeys("bindassHeel@gmail.com");
        Thread.sleep(3000);

        // Enter valid password
        driver.findElement(By.id("pass")).sendKeys("Heelbindass123!");
        Thread.sleep(3000);

        // click on sign in button
        driver.findElement(By.id("send2")).click();
        Thread.sleep(3000);

        //verify the Text
        String expectedText = "Welcome, Heelenas Bindaass1!";
        String actualText = driver.findElement(By.xpath("(//span[@class='logged-in'])[1]")).getText();
        Assert.assertEquals(expectedText, actualText);

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


    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
