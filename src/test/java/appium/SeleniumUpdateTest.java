package appium;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class SeleniumUpdateTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/mff/Downloads/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
//        设置为 headless 模式 （必须）
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
//        设置浏览器窗口打开大小  （非必须）
        chromeOptions.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void test() throws Exception {
        driver.get("http://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
        String strings ="[{\"1\":\"one\",\"2\":\"two\"}]";
        JSONArray jsonArray =JSONArray.fromObject(strings);
        System.out.println(jsonArray);
    }


    @AfterMethod
    public void tearDown() {
       // driver.quit();
    }
}
