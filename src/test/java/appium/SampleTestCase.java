package appium;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SampleTestCase extends AppiumDriverBase {
    //Test Annotation changes any java function to TestNG test case
    @Test
    public void sampeTest() throws Exception {
        String message = "网络已断开";

        final AndroidDriverWait wait = new AndroidDriverWait(driver, 10);
        Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'" + message + "')]"))));


        WebElement showClose = new AndroidDriverWait(driver, 60)
                .until(new ExpectedCondition<WebElement>() {
                    public WebElement apply(AndroidDriver d) {
                        return d.findElement(By
                                .id("Contact Manager"));
                    }

                });
        WebElement ae = new AndroidDriverWait(driver, 60).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(AndroidDriver driver) {
                return driver.findElement(By.id("Contact Manager"));
            }
        });

        wait1.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(AndroidDriver driver) {
                return driver.findElement(By.id("Contact Manager"));
            }
        });
        driver.findElement(By.name("Contact Manager")).click();
        driver.findElement(By.name("Add Contact")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("liming");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("123456789");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).clear();
        driver.findElement(By.id("com.example .android.contactmanager:id/contactEmailEditText")).sendKeys("liming@126.com");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();
        driver.findElement(By.id("android:id/button1h")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton")).click();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("liming");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactPhoneEditText")).sendKeys("123456789");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).clear();
        driver.findElement(By.id("com.example.android.contactmanager:id/contactEmailEditText")).sendKeys("liming@126.com");
        driver.findElement(By.id("com.example.android.contactmanager:id/contactSaveButton")).click();

        //click on 'Accessibility Node Querying' link
        // wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Accessibility Node Querying")));
        // driver.findElement(MobileBy.AccessibilityId("Accessibility Node Querying")).click();
//back
        //   driver.navigate().back();
//back
        // driver.navigate().back();
    }
}