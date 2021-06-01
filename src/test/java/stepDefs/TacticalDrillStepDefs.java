package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utils.ActionUtil;

import java.io.IOException;
import java.net.URISyntaxException;

public class TacticalDrillStepDefs {

    OnBoardingPage onBoardingPage = new OnBoardingPage();
    HomePage homePage = new HomePage();
    CombatPage combatPage = new CombatPage();
    TacticalDrillPage tacticalDrillPage = new TacticalDrillPage();
    RosterPage rosterPage = new RosterPage();
    InGamePage inGamePage = new InGamePage();


    @Given("User is on the On-boarding-One Page")
    public void userIsOnTheOnBoardingOnePage() throws IOException, URISyntaxException {
        Assert.assertTrue(onBoardingPage.isOnPage1());
    }

    @When("User tap Start Button on the On-boarding-One Page")
    public void userTapStartButtonOnTheOnBoardingOnePage() throws IOException, URISyntaxException {
        onBoardingPage.tapStartButton1();
    }

    @When("User is on the On-boarding-Two Page")
    public void userIsOnTheOnBoardingTwoPage() throws IOException, URISyntaxException {
        Assert.assertTrue(onBoardingPage.isOnPage2());
    }

    @When("User tap Start Button on the On-boarding-Two Page")
    public void userTapStartButtonOnTheOnBoardingTwoPage() throws IOException, URISyntaxException {
        onBoardingPage.tapStartButton2();
    }

    @When("User is on the Home Page")
    public void userIsOnTheHomePage() throws IOException, URISyntaxException {
        Assert.assertTrue(homePage.isOnPage());
    }


    @When("User tap Combat Text on the Home Page")
    public void userTapCombatTextOnTheHomePage() throws IOException, URISyntaxException {
        homePage.tapCombatText();
    }

    @When("User is on the Combat Page")
    public void userIsOnTheCombatPage() throws IOException, URISyntaxException {
        Assert.assertTrue(combatPage.isOnPageMain());
    }

    @When("User tap the Supplies Menu on the Combat Page")
    public void userTapTheSuppliesMenuOnTheCombatPage() throws IOException, URISyntaxException {
        combatPage.tapSuppliesImage();
    }

    @When("User tap the Tactical Drill Menu on the Combat Page")
    public void userTapTheTacticalDrillMenuOnTheCombatPage() throws IOException, URISyntaxException {
        combatPage.tapTacticalDrillImage();
    }

    @When("user is on the Tactical Drill Page")
    public void userIsOnTheTacticalDrillPage() throws IOException, URISyntaxException {
        Assert.assertTrue(tacticalDrillPage.isOnPage());
    }

    @Then("User play the Tactical Drill LS - Five until the sanity is empty")
    public void userPlayTheTacticalDrillLSFiveUntilTheSanityIsEmpty() throws IOException, URISyntaxException {
        boolean sanityIsEmpty = false;
        int iter = 0;
        do {
            tacticalDrillPage.tapLS5Button();
            tacticalDrillPage.tapStartButton();
            try {
                System.out.println("1 - is on page (roster)");
                rosterPage.isOnPage();
            } catch (Exception e) {
                System.out.println("exc - empty sanity");
                tacticalDrillPage.showEmptySanity();
                sanityIsEmpty = true;
                break;
            }
            System.out.println("2 - start mission (roster)");
            rosterPage.tapMissionStartButton();
            Assert.assertTrue(inGamePage.isOnPage());
            iter++;
            System.out.printf("Iteration: %s%n", iter);
//            Assert.assertTrue(inGamePage.doneResult());
            System.out.println("3 - tap result");
            inGamePage.tapResultsText();
        } while (sanityIsEmpty = true);
    }
}
