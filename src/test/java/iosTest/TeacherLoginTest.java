package iosTest;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.IsElementPresent;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class TeacherLoginTest {
    IOSDriver  driverios2;
    InitializeDriver initialize;

    @BeforeMethod
    public void setUp() throws Exception {
        initialize = new InitializeDriver();
        driverios2 = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize("10.2.1", "iPad mini3", "a00768ab7e56d822d32b50bd7d262f43d044db1b"));
    }

    @Test
    public void pushTest() throws Exception {

        //学生账号进行登录
        int width2 = driverios2.manage().window().getSize().width;
        int height2 = driverios2.manage().window().getSize().height;
        System.out.println(width2);
        System.out.println(height2);
        for (int i = 0; i < 3; i++) {
            driverios2.swipe(width2 * 6 / 7, height2 / 2, width2 * 2 / 7, 0, 1000);
        }
        System.out.println("滑动成功");

        //点击登录按钮
        driverios2.findElement(By.className("UIAButton")).click();
        Thread.sleep(2000);
        System.out.println("点击立即登录按钮成功");

        //输入账号和密码
        driverios2.findElement(By.className("UIATextField")).sendKeys("AXPC11@ett.com");
        driverios2.tap(1, width2 * 2 / 3, height2 * 1 / 5, 500);
        //driverios.hideKeyboard();
        //driverios.findElementByAccessibilityId("隐藏键盘").click();
        driverios2.findElement(By.className("UIASecureTextField")).sendKeys("a11111");
        driverios2.tap(1, width2 * 2 / 3, height2 * 1 / 5, 500);
        driverios2.findElement(By.id("登录")).click();
        System.out.println("登录成功");

        //学生账号进行登录
        while(true) {
            IsElementPresent isElementPresent = new IsElementPresent();
            if(isElementPresent.isElementPresent(By.id("飞飞"),driverios2)) {
                driverios2.findElement(By.id("飞飞")).click();
                break;
            }else{
                Thread.sleep(2000);
            }
        }
        driverios2.findElement(By.id("进入课堂")).click();

        for(int i = 1; i <1000; i++) {
            while (true) {
                driverios2.tap(1, width2 / 2, height2 / 2, 500); //fingers 手指数量
                //System.out.println("点击屏幕成功");
                IsElementPresent isElementPresent = new IsElementPresent();
                Boolean isprensent =isElementPresent.isElementPresent(By.id("返回"),driverios2);
                //System.out.println(isprensent);
                if (isprensent) {
                    driverios2.findElement(By.id("返回")).click();
                    IsElementPresent isElementPresent1 = new IsElementPresent();
                    if(isElementPresent.isElementPresent(By.id("我的课程"),driverios2)){
                        System.out.println("第"+i+"次返回");
                        System.out.println("点击返回成功");
                    }
                    break;
                } else {
                    Thread.sleep(1000);
                }
            }
        }
    }



    @AfterMethod
    public void tearDown() {
        //driverios2.quit();
    }
}
