package pages;

import java.io.IOException;
import java.net.URISyntaxException;

import static locators.TacticalDrillLocator.*;
import static utils.ActionUtil.*;

public class TacticalDrillPage {
    public boolean isOnPage() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(BUTTON_LS_5), 30).isDisplayed();
    }

    public boolean showEmptySanity() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(TEXT_RESTORE_SANITY), 120).isDisplayed();
    }

    public void tapLS5Button() throws IOException, URISyntaxException {
        tapElement(getImageLocator(BUTTON_LS_5));
    }

    public void tapStartButton() throws IOException, URISyntaxException {
        tapElement(getImageLocator(BUTTON_START));
    }
}
