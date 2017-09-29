package util;

/**
 * Created by mff on 2017/9/29.
 */
import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author 沙陌 qq2879897713
 *
 */
public class InitDriver {

    /**
     * 获取所有共用的caps参数
     * @param udid
     * @return
     */
    public static DesiredCapabilities getCommonCaps(String udid){
        DesiredCapabilities caps = new DesiredCapabilities();
        // deviceName表示要执行的测试设备名字,这个参数在安卓上可以随便写
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "xxxxxx");
        // driver的session超时时间，默认是60秒
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "600");
        // automationName表示appium使用的测试引擎，默认是Appium，其实就是uiautomator
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        // unicodeKeyboard设置为true表示我们要使用appium自带的输入法，用来支持中文和隐藏键盘，并且将其设置为默认输入法
        caps.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        // 在执行测试完成之后，将手机的输入法从appium自带的还原成我手机默认的输入法
        caps.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        //表示不重签名app在设置为true的情况下
        caps.setCapability(AndroidMobileCapabilityType.NO_SIGN, true);

        caps.setCapability(MobileCapabilityType.UDID, udid);
        return caps;
    }
    /**
     * 以安装apk的形式创建driver
     * @param udid
     * @param appPath
     * @return
     * @throws Exception
     */
    public static AndroidDriver getDriver(String udid,String appPath) throws Exception {

        File app = new File(appPath);
        DesiredCapabilities caps = getCommonCaps(udid);
        // app参数表示你要测试的apk路径
        caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }
    /**
     * 测试已经安装在手机上的app,并且是不重置应用数据
     * @param udid
     * @param appPackage
     * @param appActivity
     * @return
     * @throws Exception
     */
    public static AndroidDriver getDriverWithInstallerNoRest(String udid,String appPackage, String appActivity) throws Exception {

        DesiredCapabilities caps = getCommonCaps(udid);
        //appPackage和appActivity表示你要启动的应用的包名和起始activity
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        //不重置应用数据
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }
    /**
     * 测试已安装的应用，并且重置该应用数据
     * @param udid
     * @param appPackage
     * @param appActivity
     * @return
     * @throws Exception
     */
    public static AndroidDriver getDriverWithInstallerRest(String udid,String appPackage, String appActivity) throws Exception {
        DesiredCapabilities caps = getCommonCaps(udid);
        //appPackage和appActivity表示你要启动的应用的包名和起始activity
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }
    /**
     * 错误：起始activity从未启动，当前是xxxactivity
     * activity:xxx never start,current activity is:xxxxx
     */
    public static AndroidDriver getDriverWithInstallerRest(String udid,String appPackage, String appActivity,String appWaitActivity) throws Exception {
        DesiredCapabilities caps = getCommonCaps(udid);
        //appPackage和appActivity表示你要启动的应用的包名和起始activity
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        //当你的起始activity和真正启动后的activity不一致的时候，请把启动后的activity放在这里
        caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, appWaitActivity);
        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        return driver;
    }

}