package utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Base64;

import static drivers.AndroidDriverInstance.*;

public class ActionUtil {

    public static WebElement waitElement(By targetElement, int timeOutInSecond) {
        WebDriverWait wait = new WebDriverWait(androidDriver, timeOutInSecond);
        waitABit(1000);
        return wait.until(ExpectedConditions.presenceOfElementLocated(targetElement));
    }

    public static void tapElement(By targetElement) {
        AndroidElement element = androidDriver.findElement(targetElement);
        element.click();
    }

    public static void getPageScreenshot() throws IOException {
        System.out.println("Capturing the snapshot of the page");
        File srcFile = androidDriver.getScreenshotAs(OutputType.FILE);

        String filePath = screenShotDirectory + File.separator;

        int imgNumber = 0;
        File file = new File(filePath + "pageSS - 0.jpg");
        while (file.exists()) {
            imgNumber++;
            file = new File(filePath + String.format("pageSS - %s.jpg", imgNumber));
        }
        FileUtils.copyFile(srcFile, file);
    }

    public static void getElementOnPageScreenshot(By targetElement) throws IOException {

        AndroidElement element = androidDriver.findElement(targetElement);
        System.out.printf("Element position = [%s, %s] %n", element.getRect().x, element.getRect().y);

        File srcFile = androidDriver.getScreenshotAs(OutputType.FILE);

        String filePath = screenShotDirectory + File.separator;

        int imgNumber = 0;
        File file = new File(filePath + "pageSS+Element - 0.jpg");
        while (file.exists()) {
            imgNumber++;
            file = new File(filePath + String.format("pageSS+Element - %s.jpg", imgNumber));
        }

        FileUtils.copyFile(srcFile, file);

        int elH = element.getRect().height;
        int elW = element.getRect().width;
        int elX = element.getRect().x;
        int elY = element.getRect().y;

        BufferedImage img = ImageIO.read(file);
        Graphics2D g2d = img.createGraphics();
        g2d.setColor(Color.RED);
        g2d.drawRect(elX, elY, elW, elH);
        g2d.dispose();

        if (takeScreenShot) {
            System.out.println("Capturing the snapshot of the element on the page");
            try {
                ImageIO.write(img, "png", file);

            } catch (Exception e) {
                System.out.println("[ERROR] Could not save image.");
            }
        }
    }

    public static By getImageLocator(String targetImage) throws IOException {
        File refImgFile = new File(System.getProperty("user.dir") + "/src/main/resources/imageElements/" + targetImage);
        String imageB64 = Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
        if (takeScreenShot) {
            getElementOnPageScreenshot(MobileBy.image(imageB64));
        }
        return MobileBy.image(imageB64);
    }


    public static void waitABit(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
