package appium;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.AlertPresent;
import util.IsElementPresent;

import java.util.List;
import java.util.Set;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class DeleteTask {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "/Users/mff/Desktop/workspace/chromedriver");
        driver = new ChromeDriver();
    }

    //@Test(description = "注册", dataProvider = "SeleniumTest", dataProviderClass = DataProvid.class)
    @Test
    //public void testRegister(String username, String pwd, String realname, String classNum) throws Exception {
    public void testRegister() throws Exception {
        driver.get("http://school.etiantian.com/dl910sxta/");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("爱学派B");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("1111");
        driver.findElement(By.linkText("登　录")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("我的课程")).click();
        Thread.sleep(50000);
        driver.findElement(By.linkText("爱学派测试课程--归档")).click();
        Thread.sleep(3000);

        Actions action = new Actions(driver);

        for (int i = 0; i < 54; i++) {
            Thread.sleep(5000);
            List<WebElement> list1 = driver.findElement(By.id("J_Tasklist")).findElements(By.className("one"));
            WebElement we = list1.get(0);
            action.moveToElement(we).perform();
            Thread.sleep(5000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement logout = we.findElement(By.className("ico09"));
            js.executeScript("arguments[0].click();", logout);
            driver.switchTo().alert().accept();
            Thread.sleep(5000);
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
