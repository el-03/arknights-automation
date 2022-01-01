package pages;

import java.io.IOException;

import static drivers.AndroidDriverInstance.runningTime;
import static locators.InGameLocator.BUTTON_TAKE_OVER;
import static locators.InGameLocator.TEXT_RESULT;
import static utils.ActionUtil.*;


public class InGamePage {
    public boolean isOnPage() throws IOException {
        System.out.println("3 - is on page (in game)\n");
        return waitImageElement(getElementByImage(BUTTON_TAKE_OVER), 20).isDisplayed();
    }

    public boolean doneResult() throws IOException {
        System.out.println("Waiting...");
        waitABit(runningTime * 1000);
        System.out.println("Done Waiting!");
        return waitImageElement(getElementByImage(TEXT_RESULT), 20).isDisplayed();
    }

    public void tapResultsText() throws IOException {
        tapElement(getElementByImage(TEXT_RESULT));
    }
}
