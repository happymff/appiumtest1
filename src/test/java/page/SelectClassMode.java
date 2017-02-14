package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by mengfeifei on 2017/1/6.
 */
public class SelectClassMode {
    AndroidDriver driver ;

    public SelectClassMode(AndroidDriver driver){
        this.driver = driver;
    }
    public void selectClass(){
        List<WebElement> ae3 = driver.findElement(By.id("com.etiantian.pclass:id/lacc_rlv")).findElements(By.className("android.widget.LinearLayout"));
        System.out.print(ae3.size());
        if(ae3.size()==8) {
            TouchAction clickClass = new TouchAction(driver);
            clickClass.press(ae3.get(ae3.size()-3).findElement(By.className("android.widget.RelativeLayout"))).release().perform();
        }else if (ae3.size()>6) {
            TouchAction clickClass1 = new TouchAction(driver);
            clickClass1.press(ae3.get(ae3.size() - 2).findElement(By.className("android.widget.RelativeLayout"))).release().perform();
        }
        TouchAction clickClass2 = new TouchAction(driver);
        clickClass2.press(ae3.get(ae3.size()-1).findElement(By.className("android.widget.RelativeLayout"))).release().perform();
    }
    public void selectClassMode(String mode){
       if ("Shangke".equalsIgnoreCase(mode)){
           driver.findElement(By.id("com.etiantian.pclass:id/lacc_btn_enter")).click();
       } else{
           driver.findElement(By.id("com.etiantian.pclass:id/lacc_btn_ready")).click();
       }

    }
}
