package pages;

import java.io.IOException;
import java.net.URISyntaxException;

import static locators.RosterLocator.BUTTON_MISSION_START;
import static utils.ActionUtil.*;

public class RosterPage {
    public boolean isOnPage() throws IOException, URISyntaxException {
        return waitElement(getImageLocator(BUTTON_MISSION_START), 120).isDisplayed();
    }

    public void tapMissionStartButton() throws IOException, URISyntaxException {
        tapElement(getImageLocator(BUTTON_MISSION_START));
    }
}
