package config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigConstructor {

    private final String deviceName;
    private final String udid;
    private String takeScreenshot;
    private final double thresholdValue;
    private final int stageRunningTime;


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

        this.deviceName = p.getProperty("deviceName");
        this.udid = p.getProperty("udid");
        this.takeScreenshot = p.getProperty("takeScreenshot");
        this.thresholdValue = Double.parseDouble(p.getProperty("thresholdValue"));
        this.stageRunningTime = Integer.parseInt((p.getProperty("stageRunningTime")));
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getUdid() {
        return udid;
    }

    public String getTakeScreenshot() {
        if (takeScreenshot == null || takeScreenshot.equals("")) {
            takeScreenshot = "false";
        }
        return takeScreenshot;
    }

    public double getThresholdValue() {
        return thresholdValue;
    }

    public int getStageRunningTime() {
        return stageRunningTime;
    }
}
