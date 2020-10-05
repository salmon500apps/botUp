Feature: portal.500apps

  @reports
   Scenario Outline: validate the adding reports
    Given Read the test data  "<TestData>" from Excel file for reports
    When user navigates to site url for reports
    Then verify the title of the Login Page for reports
    When Enter Email address and password for reports
    And Click on Login button for reports
    When Click on reports option
    And Click on reports from Dashboard menu for reports
#    When Click on Add contacts button
#    And Click on Add Cutom button
#    When Enter All the details of the contacts 
#    And Click on Save button to save contact details
#    Then Verify the contact created successfully or not


    Examples: 
      | TestData  |
      | TestData1 |