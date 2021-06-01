package pages;

import java.io.IOException;
import java.net.URISyntaxException;

import static locators.InGameLocator.*;
import static utils.ActionUtil.*;


public class InGamePage {
    public boolean isOnPage() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(BUTTON_SETTINGS), 240).isDisplayed();
    }

    public boolean doneResult() throws IOException, URISyntaxException {
        waitABit(2 * 45 * 1000);
        System.out.println("Done Waiting...\n");
        return waitElement(getImageLocator(TEXT_RESULT), 120).isDisplayed();
    }

    public void tapResultsText() throws IOException, URISyntaxException {
        waitABit(2 * 45 * 1000);
        System.out.println("Done Waiting...\n");
        tapElement(getImageLocator(TEXT_RESULT));
    }
}
