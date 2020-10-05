Feature: portal.500apps

  #@smoke
  #@mailsend
  #Scenario Outline: validate the adding newsletter
  #Given Read the test data  "<TestData>" from Excel file
  #When Navigates to the url
  #Then Verify the title of the Login Page
  #When Enter Email adrees and password
  #And Click on Login button
  #Then User should see home text in Url
  #When Click on MailSend option
  #And Click on NewsLetter from Dashboard menu
  #When Click on Add Newsletter button
  #And user click on Image
  #    And Click on Add Cutom button
  #    When Enter Name of News Letter
  #    And Subject of News letter
  #When Click on Submit button
  #And Click on OK button
  #Then Verify the newsletter created successfully or not
  #
  #Examples:
  #| TestData  |
  #| TestData1 |
  #
  #==================================================================
  #@smoke
  #@mailsend
  #Scenario Outline: validate the adding drips
  #Given Read the test data  "<TestData>" from Excel file for Drips
  #When user navigates to site url for Drips
  #Then verify the title of the Login Page for drips
  #When Enter Email address and password for drips
  #And Click on Login button for drips
  #When Click on Drips option
  #And Click on Drips from Dashboard menu for drips
  #When Click on Add Drips button
  #		And Click on Add Cutom button
  #When Enter Name of drips
  #When trigger is selected
  #And Action of drips
  #And user Enter subject for drips
  #And user Enter Sender name for drips
  #And Clickc on Save button
  #Then Verify the drip created successfully or not
  #
  #Examples:
  #| TestData  |
  #| TestData1 |
  #
  #==================================================================
  #@smoke
  #@mailSend
  #Scenario Outline: 7798_verify the Templates functionality
  #Given Read the test data  "<TestData>" from Excel file for Template
  #When user navigates to site url
  #Then verify the title of the Login Page for Templates
  #When Enter Email address and password
  #When I Click on Login Button
  #When Click on MailSend link
  #And Click on Templates from Dashboard menu
  #When Click on Add Templates button
  #And user click on Image for Template
  #    And Click on Add Cutom button at right side
  #    When Enter Name of Templates
  #And Subject of Templates
  #And Select Category button
  #When Click Submit button for template
  #And Click OK button for template
  #Then Verify the Templates created successfully or not
  #
  #Examples:
  #| TestData  |
  #| TestData1 |
  #
  #==================================================================
  #  @smoke
  #@mailsend
  #Scenario Outline: 7793_validate the adding contacts
  #Given Read the test data  "<TestData>" from Excel file for contacts
  #When user navigates to site url for contacts
  #Then verify the title of the Login Page for contacts
  #When Enter Email address and password for contacts
  #And Click on Login button for contacts
  #When Click on MailSend option for contacts
  #And Click on contacts from Dashboard menu for contacts
  #When Click on Add contacts button
  #   And Click on Add Cutom button
  #When Enter First Name for contacts
  #And Enter Last Name for Contacts
  #And Enter for EMail ID for contacts
  #And Enter Phone number
  #   Then Select Company
  #	And Enter customone details
  #	And Enter customtwo details
  #And Click on Save button to save contact details
  #Then Verify the contacts created successfully or not
  #
  #Examples:
  #| TestData  |
  #| TestData1 |
  #
  #==================================================================
  #@mailsend
  #Scenario Outline: validate the adding reports
  #Given Read the test data  "<TestData>" from Excel file for reports
  #When user navigates to site url for reports
  #Then verify the title of the Login Page for reports
  #When Enter Email address and password for reports
  #And Click on Login button for reports
  #When Click on reports option
  #And Click on reports from Dashboard menu for reports
  #
  #    When Click on Add reports button
  #    And Click on Add Cutom button
  #    When Enter All the details of the reports
  #    And Click on Save button to save reports details
  #    Then Verify the reports created successfully or not
  #Examples:
  #| TestData  |
  #| TestData1 |
  #
  #==================================================================
  #	@smoke
  #@mailsend
  #Scenario Outline: Validate test
  #Given Read the test data  "<TestData>" from Excel file for integration
  #When user navigates to site url for integration
  #Then verify the title of the Login Page for integration
  #When Enter Email address and password for integration
  #And Click on Login button for integration
  #When Click on integration option
  #And Click on integration from Dashboard menu for integration
  #When User click on Integrations app as Twilio
  #And I Enter the Account Sid for Twillio
  #And I Enter the Auth Token
  #And I Click on Authentication button
  #Then User validate the disabled button for twillio app
  #
  #When Click on Disabled button for Twillio App
  #Then I verify the modal title for Are you sure to diable
  #When I click on Confirm button
  #Then I verify the Twillio app enable mode to install or not
  #Examples:
  #| TestData  |
  #| TestData1 |
  #
  #==================================================================
  #@mailsend
  #Scenario Outline: validate login functionlity with invalid data
  #Given Read the test data  "<TestData>" from Excel file
  #When Navigates to the url
  #Then Verify the title of the Login Page
  #When Enter Invalid Email Address and Password
  #And Click on Login button
  #Then Verify the login successfull
  #
  #Examples:
  #| TestData  |
  #| TestData1 |
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @mailsend @test @integrationtest
  Scenario Outline: Validate End to End Scenario for mailSend
    Given Read the test data  "<TestData>" from Excel file
    When Navigates to the url
    Then Verify the title of the Login Page
    When Enter Email adrees and password
    And Click on Login button
#    Then User should see home text in Url
    When Click on MailSend option
    #============Saving Newsletter==========
#    And Click on NewsLetter from Dashboard menu
#    When Click on Add Newsletter button
#    And user click on Image
#    When Click on Submit button
#    And Click on OK button
#    Then Verify the newsletter created successfully or not
    #============Saving Contacts============
#    And Click on contacts from Dashboard menu for contacts
#    When Click on Add contacts button
#    When Enter First Name for contacts
#    And Enter Last Name for Contacts
#    And Enter for EMail ID for contacts
#    And Enter Phone number
#    And Click on Save button to save contact details
#    Then Validate the contacted inserted successfully 
#    Then Verify the contacts created successfully or not
    #============Saving Integration==========Done==
    And Click on integration from Dashboard menu for integration
    When User click on Integrations app as Twilio
    And I Enter the Account Sid for Twillio
    And I Enter the Auth Token
    And I Click on Authentication button
    Then Validate the successfull message
    Then User validate the disabled button for twillio app
    #============Saving Templates============
#    And Click on Templates from Dashboard menu
#    When Click on Add Templates button
#    And user click on Image for Template
#    And Subject of Templates
#    And Select Category button
#    When Click Submit button for template
#    And Click OK button for template
#    Then Verify the Templates created successfully or not
    #============Saving Drips============
#    And Click on Drips from Dashboard menu for drips
#    When Click on Add Drips button
#    When Enter Name of drips
#    When trigger is selected
#    And Action of drips
#    And user Enter subject for drips
#    And user Enter Sender name for drips
#    When Enter the Body text
#    And Clickc on Save button
#    Then Verify the drip created successfully or not
#    When Click on Logout button
    #============Saving Invalid Login============
#    When Enter Invalid Email Address and Password
#    And Click on Login button
#    Then Validate the inavlid email and password error message

    Examples: 
      | TestData  |
      | TestData1 |
