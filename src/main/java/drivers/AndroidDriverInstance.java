package drivers;

import config.ConfigConstructor;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidDriverInstance {

    public static AndroidDriver<AndroidElement> androidDriver;
    public static boolean isAndroid = false;
    public static String screenShotDirectory;
    public static boolean takeScreenShot = false;

    public static void initialize(ConfigConstructor config) {
        String appiumUrl = "http://127.0.0.1:4723/wd/hub/";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("deviceName", config.getDeviceName());
        caps.setCapability("udid", config.getUdid());
        caps.setCapability("autoGrantPermissions", Boolean.parseBoolean(config.getAutoGrantPermissions()));
        caps.setCapability("newCommandTimeout", 240);
        caps.setCapability("takeScreenshot", Boolean.parseBoolean(config.getTakeScreenshot()));
        caps.setCapability("noReset", Boolean.parseBoolean(config.getNoReset()));
        caps.setCapability("appPackage", config.getAppPackage());
        caps.setCapability("appActivity", config.getAppActivity());


        try {
            androidDriver = new AndroidDriver<>(new URL(appiumUrl), caps);
            androidDriver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getImplicitlyWait()), TimeUnit.SECONDS);
            isAndroid = true;
            if (Boolean.parseBoolean(config.getTakeScreenshot())) {
                takeScreenShot = true;
                String getDateTime = java.time.LocalDateTime.now().toString();
                File file = new File(System.getProperty("user.dir") + File.separator + "screenShot");
                if (!file.exists()) {
                    file.mkdir();
                    System.out.println("Creating dir");
                }
                screenShotDirectory = System.getProperty("user.dir") + File.separator + "screenShot" + File.separator + getDateTime;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        androidDriver.quit();
        isAndroid = false;
    }
}
