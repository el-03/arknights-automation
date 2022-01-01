package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class TacticalDrillStepDefs {

    OnBoardingPage onBoardingPage = new OnBoardingPage();
    HomePage homePage = new HomePage();
    TerminalPage terminalPage = new TerminalPage();
    TacticalDrillPage tacticalDrillPage = new TacticalDrillPage();
    RosterPage rosterPage = new RosterPage();
    InGamePage inGamePage = new InGamePage();


    @Given("User is on the On-boarding-One Page")
    public void userIsOnTheOnBoardingOnePage() throws IOException {
        Assert.assertTrue(onBoardingPage.isOnPage1());
    }

    @When("User tap Start Button on the On-boarding-One Page")
    public void userTapStartButtonOnTheOnBoardingOnePage() throws IOException {
        onBoardingPage.tapStartButton1();
    }

    @When("User is on the On-boarding-Two Page")
    public void userIsOnTheOnBoardingTwoPage() throws IOException {
        Assert.assertTrue(onBoardingPage.isOnPage2());
    }

    @When("User tap Start Button on the On-boarding-Two Page")
    public void userTapStartButtonOnTheOnBoardingTwoPage() throws IOException {
        onBoardingPage.tapStartButton2();
    }

    @When("User is on the Home Page")
    public void userIsOnTheHomePage() throws IOException {
        Assert.assertTrue(homePage.isOnPage());
    }

    @When("User tap Terminal Text on the Home Page")
    public void userTapTerminalTextOnTheHomePage() throws IOException {
        homePage.tapTerminalText();
    }

    @When("User is on the Terminal Page")
    public void userIsOnTheTerminalPage() throws IOException {
        Assert.assertTrue(terminalPage.isOnPageTerminal());
    }

    @When("User tap the Supplies Menu on the Terminal Page")
    public void userTapTheSuppliesMenuOnTheTerminalPage() throws IOException {
        terminalPage.tapSuppliesIcon();
    }

    @When("User is on the Supplies Page")
    public void userIsOnTheSuppliesPage() throws IOException {
        Assert.assertTrue(terminalPage.isOnPageSupplies());
    }

    @When("User tap the Tactical Drill Menu on the Supplies Page")
    public void userTapTheTacticalDrillMenuOnTheSuppliesPage() throws IOException {
        terminalPage.tapTacticalDrillImage();
    }

    @When("user is on the Tactical Drill Page")
    public void userIsOnTheTacticalDrillPage() throws IOException {
        Assert.assertTrue(tacticalDrillPage.isOnPage());
    }

    @Then("User play the Tactical Drill LS - Five until the sanity is empty")
    public void userPlayTheTacticalDrillLSFiveUntilTheSanityIsEmpty() throws IOException {
        int iter = 0;
        while (true) {
            tacticalDrillPage.tapLS5Button();
            tacticalDrillPage.tapStartButton();
            try {
                System.out.println("\n\n\n=========================");
                System.out.println("1 - is on page (roster)");
                rosterPage.isOnPage();
            } catch (Exception e) {
                System.out.println("exc - empty sanity");
                tacticalDrillPage.showEmptySanity();
                break;
            }
            System.out.println("2 - start mission (roster)");
            rosterPage.tapMissionStartButton();
            Assert.assertTrue(inGamePage.isOnPage());
            iter++;
            System.out.printf("Iteration: %s%n", iter);
            Assert.assertTrue(inGamePage.doneResult());
            System.out.println("3 - tap results button");
            inGamePage.tapResultsText();
        }
    }
}
