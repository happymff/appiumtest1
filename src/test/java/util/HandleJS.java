package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mff on 2017/12/15.
 */
public class HandleJS {

    public void JavaScriptClick(WebElement element, WebDriver driver) {
        try {

            if (element.isEnabled() && element.isDisplayed()) {

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);


            } else {
                System.out.println("页面上的元素无法进行点击操作");
            }


        } catch (Exception e) {
// TODO: handle exception
            e.printStackTrace();
        }
    }
}
