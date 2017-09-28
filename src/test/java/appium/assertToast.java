package appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * Created by mff on 2017/9/25.
 */
public class assertToast {
    AndroidDriver driver;


    public void setDriver(AndroidDriver driver) {
        this.driver = driver;
    }

    public void assertToasstAndroid(String message, By by) {
        final AndroidDriverWait wait = new AndroidDriverWait(driver, 10);
        Assert.assertNotNull (wait.until(
           ExpectedConditions.presenceOfElementLocated(by)));

}
}
