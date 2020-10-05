Feature: portal.500apps contacts

  @contacts 
  Scenario Outline: 7793_validate the adding contacts
    Given Read the test data  "<TestData>" from Excel file for contacts
    When user navigates to site url for contacts
    Then verify the title of the Login Page for contacts
    When Enter Email address and password for contacts
    And Click on Login button for contacts
    When Click on MailSend option for contacts
    And Click on contacts from Dashboard menu for contacts
    When Click on Add contacts button
#   And Click on Add Cutom button
    When Enter First Name for contacts
    And Enter Last Name for Contacts
    And Enter for EMail ID for contacts
    And Enter Phone number
#   Then Select Company
#	And Enter customone details 
#	And Enter customtwo details
    And Click on Save button to save contact details
    Then Verify the contacts created successfully or not
   	
   	

    Examples: 
      | TestData  |
      | TestData1 |