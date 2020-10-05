Feature: portal.500apps news letter
  
  @newsletter
  Scenario Outline: 7791_validate the adding newsletter
    Given Read the test data  "<TestData>" from Excel file
    When Navigates to the url
    Then Verify the title of the Login Page
    When Enter Email adrees and password
    And Click on Login button
    Then User should see home text in Url
    When Click on MailSend option
    And Click on NewsLetter from Dashboard menu
    When Click on Add Newsletter button
    And Click on Add Cutom button
    When Enter Name of News Letter
    And Subject of News letter
    When Click on Submit button
    And Click on OK button
    Then Verify the newsletter created successfully or not
   	
   	

    Examples: 
      | TestData  |
      | TestData1 |


  @newletter
  Scenario Outline: validate login functionlity with invalid data
    Given Read the test data  "<TestData>" from Excel file
    When Navigates to the url
    Then Verify the title of the Login Page
    When Enter Invalid Email Address and Password
    And Click on Login button
    Then Verify the login successfull

    Examples: 
    | TestData  |
    | TestData1 |
