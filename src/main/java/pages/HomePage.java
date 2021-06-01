package pages;

import java.io.IOException;
import java.net.URISyntaxException;

import static locators.HomeLocator.*;
import static utils.ActionUtil.*;
import static utils.ActionUtil.getImageLocator;

public class HomePage {
    public boolean isOnPage() throws IOException, URISyntaxException {
        waitABit(15 * 1000);
        return waitElement(getImageLocator(TEXT_COMBAT), 30).isDisplayed();
    }

    public void tapCombatText() throws IOException, URISyntaxException {
        tapElement(getImageLocator(TEXT_COMBAT));
    }

//    public boolean isOnPage() throws IOException, URISyntaxException {
//        return waitElement(getImageLocator(), 120).isDisplayed();
//    }
//
//    public void tapCombatText() throws IOException, URISyntaxException {
//        tapElement(getImageLocator());
//    }
}
