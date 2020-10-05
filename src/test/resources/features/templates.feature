Feature: templates scenarios

  @templates
   Scenario Outline:7798_verify the Templates functionality
    Given Read the test data  "<TestData>" from Excel file for Template
    When user navigates to site url
    
    Then verify the title of the Login Page for Templates
    When Enter Email address and password
    When I Click on Login Button    
    When Click on MailSend link
    And Click on Templates from Dashboard menu
    When Click on Add Templates button	
    And Click on Add Cutom button at right side
    When Enter Name of Templates
    
    And Subject of Templates
    When Click  Submit button
    And Clickc  OK button
    Then Verify the Templates created successfully or not

    Examples: 
      |TestData|
      |TestData1|
      
      
      
