package appium;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class AppiumDriverBase {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    protected AndroidDriverWait wait1;

    // before Test Annotation makes a java function to run every time before a TestNG test case
    @BeforeTest
    protected void createAppiumDriver() throws
            MalformedURLException, InterruptedException {
// setting up desired capability
        DesiredCapabilities caps = new
                DesiredCapabilities();
        caps.setCapability("platform", "ANDROID");
        caps.setCapability("platformVersion", "5.0.1");
        caps.setCapability("deviceName", "IVZHA6EE99999999");
        caps.setCapability("browserName", "");
// relative path to apk file
        final File classpathRoot = new File(System.getProperty("user.dir"));
        final File appDir = new File(classpathRoot,"src/test/resource/apps/");
        final File app = new File(appDir, "app-aixuepai.apk");
        //设置输入法
        caps.setCapability("unicodeKeyboard", "True");
        //隐藏键盘
        caps.setCapability("resetKeyboard", "True");
        caps.setCapability("app", app.getAbsolutePath());
         caps.setCapability("appPackage", "com.etiantian.pclass");
// initializing driver object
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
// initializing explicit wait object


        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        wait1 = new AndroidDriverWait(driver,10);
    }
    // After Test Annotation makes a java function to run every time after a TestNG test case
    @AfterTest
    public void afterTest() {
       // quit the driver
        //driver.quit();

    }

}