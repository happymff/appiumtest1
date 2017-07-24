package appium;


import org.openqa.selenium.By;
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
public class DeleteNexusRecord {
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
        driver.get("http://192.168.10.8:18080/nexus/index.html");
        //点击login按钮
       driver.findElement(By.id("head-link-r")).click();
       Thread.sleep(5000);
        //输入用户名
       driver.findElement(By.id("usernamefield")).clear();
       driver.findElement(By.id("usernamefield")).sendKeys("tester");
        //输入密码
        driver.findElement(By.id("passwordfield")).clear();
        driver.findElement(By.id("passwordfield")).sendKeys("ETT0428");
        Thread.sleep(3000);
        //点击登录按钮
        driver.findElement(By.xpath("//*[@id=\"ext-gen308\"]")).click();
        Thread.sleep(2000);
//点击Repositories
        driver.findElement(By.linkText("Repositories")).click();
        Thread.sleep(5000);
        //点击EttAppSnapshots
        driver.findElement(By.xpath("//*[@id=\"ext-comp-1038_http://192.168.10.8:18080/nexus/service/local/repositories/EttAppSnapshots_col0\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"ext-gen987\"]/li/div")).click();
//        Thread.sleep(3000);
        //*[@id="ext-gen1002"]/li[4]/div/a/span
        for (int i =0; i <20; i++) {
            Thread.sleep(3000);
            //点击com
            driver.findElement(By.xpath("//*[@class=\"x-tree-root-ct x-tree-no-lines\"]/li/ul/li[1]")).click();
            Thread.sleep(3000);
            //点击etiantian
            driver.findElement(By.xpath("//*[@class=\"x-tree-node-el x-unselectable  x-tree-node-collapsed\"]")).click();
            Thread.sleep(3000);
            //点击aixuepai
            driver.findElement(By.xpath("//*[@class=\"x-tree-node-ct\"]/li[2]/div")).click();
            Thread.sleep(3000);
            //点击ios
            driver.findElement(By.xpath("//*[@class=\"x-tree-node-ct\"]/li[2]/ul")).click();
            Thread.sleep(3000);
            //点击EPIC_Debug
            driver.findElement(By.xpath("//*[@class=\"x-tree-node-ct\"]/li[2]/ul/li/ul/li[4]/div/a/span")).click();
            Thread.sleep(3000);
            //点击1.0Snapshot
            driver.findElement(By.xpath("//*[@class=\"x-tree-node-ct\"]/li[2]/ul/li/ul/li[4]/ul")).click();
            Thread.sleep(3000);
            //driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[2]/ul/li/ul/li[1]/ul/li/ul/li[2]/ul/li/ul/li[4]/ul/li/ul/li[1]/div/a/span")).click();
            //Thread.sleep(3000);
            //点击第一条记录
            driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[2]/ul/li/ul/li[1]/ul/li/ul/li[2]/ul/li/ul/li[4]/ul/li/ul/li[1]/div/a/span")).click();
//            Actions action = new Actions(driver);
//            //action.contextClick();// 鼠标右键在当前停留的位置做单击操作
//            action.contextClick(driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[1]/div/div[2]/ul/li/ul/li[1]/ul/li/ul/li[2]/ul/li/ul/li[4]/ul/li/ul/li[1]/div/a/span")));// 鼠标右键点击指定的元素
//            action.perform();
            Thread.sleep(3000);
//            driver.findElement(By.xpath("html/body/div[21]/ul/li[3]/a")).click();
            //点击delete按钮
            driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/form/div[6]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")).click();
            Thread.sleep(5000);
            //点击Yes按钮
            driver.findElement(By.id("Yes")).click();
//            AlertPresent alertPresent1 = new AlertPresent();
//            System.out.println(alertPresent1.isAlertPresent(driver));
//            if (alertPresent1.isAlertPresent(driver))
//            {
//                alertPresent1.acceptAlert(driver,true);
//            }
        }
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}
