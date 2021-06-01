package pages;

import java.io.IOException;
import java.net.URISyntaxException;

import static locators.OnBoarding.*;
import static utils.ActionUtil.*;

public class OnBoardingPage {
    public boolean isOnPage1() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(BUTTON_START_1), 120).isDisplayed();
    }

    public boolean isOnPage2() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(BUTTON_START_2), 120).isDisplayed();
    }

    public void tapStartButton1() throws IOException, URISyntaxException {
        tapElement(getImageLocator(BUTTON_START_1));
    }

    public void tapStartButton2() throws IOException, URISyntaxException {
        tapElement(getImageLocator(BUTTON_START_2));
    }
}
