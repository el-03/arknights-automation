package utils;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

import static drivers.AndroidDriverInstance.*;

public class ActionUtil {

    public static AndroidElement waitImageElement(By targetElement, int timeOutInSecond) throws IOException {
        waitABit(1000);
        WebDriverWait wait = new WebDriverWait(androidDriver, timeOutInSecond);
        AndroidElement element = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(targetElement));
        if (takeScreenShot) {
            doElementCapture(element);
        }
        return element;
    }

    public static void tapElement(By targetElement) throws IOException {
        waitABit(1000);
        AndroidElement element = androidDriver.findElement(targetElement);
        if (takeScreenShot) {
            doElementCapture(element);
        }
        element.click();
    }

    public static void doElementCapture(AndroidElement element) throws IOException {
        System.out.println("Capturing the snapshot of the element on the page");
        System.out.printf("Element position = [%s, %s] %n", element.getRect().x, element.getRect().y);

        File srcFile = androidDriver.getScreenshotAs(OutputType.FILE);
        String filePath = screenShotDirectory + File.separator;

        int imgNumber = 0;
        File file = new File(filePath + "Element-0.jpg");
        while (file.exists()) {
            imgNumber++;
            file = new File(filePath + String.format("Element-%s.jpg", imgNumber));
        }

        FileUtils.copyFile(srcFile, file);

        int elH = element.getRect().height;
        int elW = element.getRect().width;
        int elX = element.getRect().x;
        int elY = element.getRect().y;

        BufferedImage img = ImageIO.read(file);
        BufferedImage rgbImage = new BufferedImage(img.getWidth(), img.getHeight(),
                BufferedImage.TYPE_3BYTE_BGR);
        ColorConvertOp op = new ColorConvertOp(null);
        Graphics2D g2d = rgbImage.createGraphics();
        op.filter(img, rgbImage);
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(10));
        g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g2d.drawRect(elX, elY, elW, elH);

        String imgScore = element.getAttribute("score");
        System.out.printf("Image Match Score = %s %n", element.getAttribute("score"));
        g2d.drawString(imgScore.substring(0, 5), elX, elY - 10);

        g2d.dispose();

        try {
            ImageIO.write(rgbImage, "jpg", file);

        } catch (Exception e) {
            System.out.println("[ERROR] Could not save image.");
        }
    }

    public static By getElementByImage(String targetImage) throws IOException {
        File refImgFile = new File(System.getProperty("user.dir") + "/src/main/resources/imageElements/" + targetImage);
        String imageB64 = Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
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
