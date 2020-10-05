Feature: portal.500apps

  @integration
  Scenario Outline: 7685_validate the adding integration
    Given Read the test data  "<TestData>" from Excel file for integration
    When user navigates to site url for integration
    Then verify the title of the Login Page for integration
    When Enter Email address and password for integration
    And Click on Login button for integration
    When Click on integration option
    And Click on integration from Dashboard menu for integration
    When User click on Integrations app as Twilio
    And I Enter the Account Sid for Twillio
    And I Enter the Auth Token
    And I Click on Authentication button
	Then User validate the disabled button for twillio app
    #When Click on Disabled button for Twillio App
    #Then I verify the modal title for Are you sure to diable
    #When I click on Confirm button
    #Then I verify the Twillio app enable mode to install or not

    Examples: 
      | TestData  |
      | TestData1 |
