package pages;

import java.io.IOException;
import java.net.URISyntaxException;

import static locators.RosterLocator.BUTTON_MISSION_START;
import static utils.ActionUtil.*;

public class RosterPage {
    public boolean isOnPage() throws IOException {
        return waitImageElement(getElementByImage(BUTTON_MISSION_START), 10).isDisplayed();
    }

    public void tapMissionStartButton() throws IOException {
        tapElement(getElementByImage(BUTTON_MISSION_START));
    }
}
