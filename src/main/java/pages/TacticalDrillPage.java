package pages;

import java.io.IOException;

import static locators.TacticalDrillLocator.*;
import static utils.ActionUtil.*;

public class TacticalDrillPage {
    public boolean isOnPage() throws IOException {
        return waitImageElement(getElementByImage(BUTTON_LS_5), 10).isDisplayed();
    }

    public boolean showEmptySanity() throws IOException {
        return waitImageElement(getElementByImage(IMG_SANITY_BRAIN), 10).isDisplayed();
    }

    public void tapLS5Button() throws IOException {
        tapElement(getElementByImage(BUTTON_LS_5));
    }

    public void tapStartButton() throws IOException {
        tapElement(getElementByImage(BUTTON_START));
    }
}
