package pages;

import java.io.IOException;

import static locators.TerminalLocator.*;
import static utils.ActionUtil.*;

public class TerminalPage {

    public boolean isOnPageTerminal() throws IOException
    {
        return waitImageElement(getElementByImage(ICON_TERMINAL_ACTIVE), 10).isDisplayed();
    }

    public boolean isOnPageSupplies() throws IOException {
        return waitImageElement(getElementByImage(IMG_TACTICAL_DRILL), 10).isDisplayed();
    }

    public void tapSuppliesIcon() throws IOException {
        tapElement(getElementByImage(ICON_SUPPLIES_INACTIVE));
    }

    public void tapTacticalDrillImage() throws IOException {
        tapElement(getElementByImage(IMG_TACTICAL_DRILL));
    }
}
