package pages;

import java.io.IOException;
import java.net.URISyntaxException;

import static locators.CombatLocator.*;
import static utils.ActionUtil.*;

public class CombatPage {

    public boolean isOnPageMain() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(IMG_SUPPLIES), 120).isDisplayed();
    }

    public boolean isOnPageSupplies() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(IMG_TACTICAL_DRILL), 120).isDisplayed();
    }

    public void tapSuppliesImage() throws IOException, URISyntaxException {
        tapElement(getImageLocator(IMG_SUPPLIES));
    }

    public void tapTacticalDrillImage() throws IOException, URISyntaxException {
        tapElement(getImageLocator(IMG_TACTICAL_DRILL));
    }
}
