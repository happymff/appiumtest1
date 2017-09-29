package AiXuepai;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;
import util.DriverInitialize;
import DataProvider.DataProvid;
import util.Initialize;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class LoginTest {
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
    @Test(description = "登陆成功",dataProvider = "LoginSucess",dataProviderClass = DataProvid.class)
    public void loginTest(String username, String pwd) throws Exception {
        Thread.sleep(2000);
        loginPage = new LoginPage(username,pwd,driver);
        loginPage.loginSuccess();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        String selectClass = driver.findElement(By.className("android.widget.TextView")).getText();
        //判断进入选择班级页面，即登陆成功
        Assert.assertEquals("选择班级", selectClass);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}