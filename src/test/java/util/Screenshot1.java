package util;

/**
 * Created by mff on 2017/5/11.
 */
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Listeners;


@Listeners({ScreenshotListener1.class})
public class Screenshot1 {
    static AppiumDriver driver;
//
//    @BeforeClass
//    public void setUp() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("deviceName", "AndroidUI");
//        capabilities.setCapability("platformVersion", "1.0");
//        capabilities.setCapability("appPackage", "com.android.androidui");
//        capabilities.setCapability("appActivity", "com.android.androidui.MainActivity");
//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testExample() throws IOException {
//        WebElement spinner = driver.findElement(By.id("android:id/text1"));
//        spinner.click();
//        driver.scrollToExact("India");
//        WebElement optionindia = driver.findElement(By.name("India"));
//        optionindia.click();
//        WebElement result = optionindia;
////Check the calculated value on the edit box
//        assert result.getText().equals("France") : "Actual value is :" + result.getText() + " did not match with expected value: France";
//    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.closeApp();
//    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}