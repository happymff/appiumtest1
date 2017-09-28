package AiXuePaiTestForTestng;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.*;
import util.Initialize;

import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class MonkeyTest {
    AndroidDriver driver;
    Initialize initialize= new Initialize();
    LoginPage loginPage;

    @BeforeMethod
    public  void setUp() throws  Exception {

       //initialize = new Initialize();
        // initializing driver object
       // DesiredCapabilities caps =initialize.driverInitialize();
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), initialize.driverInitialize());
// initializing explicit wait object
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Parameters({"username","pwd"})
    @Test
    //@Test(description = "登陆成功",dataProvider = "LoginSucess",dataProviderClass = DataProvid.class)
    public void monkeyTest(String username, String pwd) throws Exception {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        Random random1 = new Random();
        int x = random1.nextInt(width);
        int y = random1.nextInt(height);
        loginPage = new LoginPage(username,pwd,driver);
        Thread.sleep(2000);
        loginPage.loginSuccess();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
       for (int i =0; i <100; i++){

       }
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
