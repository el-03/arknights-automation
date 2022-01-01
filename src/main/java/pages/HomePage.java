package pages;

import java.io.IOException;

import static locators.HomeLocator.*;
import static utils.ActionUtil.*;
import static utils.ActionUtil.getElementByImage;

public class HomePage {
    public boolean isOnPage() throws IOException {
        return waitImageElement(getElementByImage(TEXT_TERMINAL), 30).isDisplayed();
    }

    public void tapTerminalText() throws IOException {
        tapElement(getElementByImage(TEXT_TERMINAL));
    }

}
