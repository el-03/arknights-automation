package pages;

import java.io.IOException;

import static locators.OnBoarding.*;
import static utils.ActionUtil.*;

public class OnBoardingPage {
    public boolean isOnPage1() throws IOException {
        return waitImageElement(getElementByImage(BUTTON_START_1), 60).isDisplayed();
    }

    public boolean isOnPage2() throws IOException {
        return waitImageElement(getElementByImage(BUTTON_START_2), 60).isDisplayed();
    }

    public void tapStartButton1() throws IOException {
        tapElement(getElementByImage(BUTTON_START_1));
    }

    public void tapStartButton2() throws IOException {
        tapElement(getElementByImage(BUTTON_START_2));
    }
}
