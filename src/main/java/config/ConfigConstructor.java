package config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigConstructor {

    String platformName;
    String deviceName;
    String udid;
    String noReset;
    String app;
    String appPackage;
    String appActivity;
    String bundleId;
    String autoGrantPermissions;
    String implicitlyWait;
    String takeScreenshot;


    public ConfigConstructor() {

        String propFileName = System.getProperty("user.dir") + "/src/main/java/config/config.properties";
        Properties p = new Properties();
        FileReader reader = null;

        try {
            reader = new FileReader(propFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            p.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.platformName = p.getProperty("platformName");
        this.deviceName = p.getProperty("deviceName");
        this.udid = p.getProperty("udid");
        this.noReset = p.getProperty("noReset");
        this.app = p.getProperty("app");
        this.appPackage = p.getProperty("appPackage");
        this.appActivity = p.getProperty("appActivity");
        this.bundleId = p.getProperty("bundleId");
        this.autoGrantPermissions = p.getProperty("autoGrantPermissions");
        this.implicitlyWait = p.getProperty("implicitlyWait");
        this.takeScreenshot = p.getProperty("takeScreenshot");

    }

    public String getPlatformName() {
        return platformName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public String getNoReset() {
        if (noReset == null || noReset.equals("")) {
            noReset = "true";
        }
        return noReset;
    }

    public String getApp() {
        if (app == null) {
            app = "";
        }
        return app;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public String getBundleId() {
        return bundleId;
    }

    public String getAutoGrantPermissions() {
        if (autoGrantPermissions == null || autoGrantPermissions.equals("")) {
            autoGrantPermissions = "true";
        }
        return autoGrantPermissions;
    }

    public String getImplicitlyWait() {
        if (implicitlyWait == null || implicitlyWait.equals("")) {
            implicitlyWait = "15";
        }
        return implicitlyWait;
    }

    public String getTakeScreenshot() {
        if (takeScreenshot == null || takeScreenshot.equals("")) {
            takeScreenshot = "false";
        }
        return takeScreenshot;
    }
}
