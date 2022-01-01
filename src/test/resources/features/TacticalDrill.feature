@Android @TacticalDrill

Feature: Tactical Drill LS - 5

  Scenario: Play the Tactical Drill LS - 5 until the sanity is empty
    Given User is on the On-boarding-One Page
    When User tap Start Button on the On-boarding-One Page
    And User is on the On-boarding-Two Page
    And User tap Start Button on the On-boarding-Two Page
    And User is on the Home Page
    And User tap Terminal Text on the Home Page
    And User is on the Terminal Page
    And User tap the Supplies Menu on the Terminal Page
    And User is on the Supplies Page
    And User tap the Tactical Drill Menu on the Supplies Page
    And user is on the Tactical Drill Page
    Then User play the Tactical Drill LS - Five until the sanity is empty
