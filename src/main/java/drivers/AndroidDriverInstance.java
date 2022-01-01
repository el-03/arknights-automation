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
    public static boolean takeScreenShot;
    public static int runningTime;

    public static void initialize(ConfigConstructor config) {
        String appiumUrl = "http://127.0.0.1:4723/wd/hub/";
        runningTime = config.getStageRunningTime();

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UIAutomator2");
        caps.setCapability("deviceName", config.getDeviceName());
        caps.setCapability("udid", config.getUdid());
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("takeScreenshot", Boolean.parseBoolean(config.getTakeScreenshot()));
        caps.setCapability("noReset", true);
        caps.setCapability("newCommandTimeout", runningTime + 10);
        caps.setCapability("appPackage", "com.YoStarEN.Arknights");
        caps.setCapability("appActivity", "com.u8.sdk.U8UnityContext");


        try {
            androidDriver = new AndroidDriver<>(new URL(appiumUrl), caps);
            androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            androidDriver.setSetting("imageMatchThreshold", config.getThresholdValue());
            isAndroid = true;
            if (Boolean.parseBoolean(config.getTakeScreenshot())) {
                takeScreenShot = true;
                String getDateTime = java.time.LocalDateTime.now().toString();
                File file = new File(System.getProperty("user.dir") + File.separator + "screenShot");
                if (!file.exists()) {
                    boolean successToCreate = file.mkdir();
                    System.out.println("Creating dir.");
                    if (!successToCreate) {
                        System.out.println("Failed to create the dir.");
                    }
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
