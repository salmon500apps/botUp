Feature: PBX+ Call Flow

  @PBX
  Scenario Outline: PBX plus call flow - Create Call Flow
    Given Read the test data  "<TestData>" from Excel file for PBXplus
    When Navigates to the url for PBXplus
    Then Verify the title of the Login Page for PBXplus
    When Enter Email adrees and password for PBXplus
    And Click on Login button for PBXplus
    When User click on Pbx Plus link
    And User Click on Call Flow link in Dashboard
    Then User Click on Add Call Flow button
    And Enter Call FLow Name
    And Enter Description
    
    
    When Click on Text to speech in Iframe in Call Flow
    Then Enter Text to convert into voice
    Then Click on Save button for Text to Speech
    Then Join Nodes from Start to Text to Speech
    
    Then User Click on Play Audio
    And Select recorder Audio from drop-down
    Then CLikc on Save button in Play Audio
    Then Join Nodes from Text to Speech to Play Audio
  
  
    Then Click on Buiness Hours
    And Select time zone under settings
    And Enter From-Time and To-Time
    Then Click on Save Button for Business Hours
    And User Join Play Audio to Buiness Hours node
    
    
    When User Click on Voicemail in Iframe
    Then User Select Record Audio in Voicemail
    Then Enter Message for voicemail
    Then Click on Save button in Voicemail for iframe
    Then Join Nodes from Busineeshours No TO Voicemail
    When User Click on Menu in Iframe
    Then User Select Record Audio
    And User Enter Greetings Message
    And User clicks on add button for extension
    And Enter Input valueone
    And Enter Name textone
    Then Click on Add button for one
    And User clicks on add button for extension two
    And Enter Input valuetwo
    And Enter Name texttwo
    Then Click on Add button for extension two
    Then Click on Save button in Menu frame
    Then Join the node from Business hours Yes to Menu
  
    When Click on Forward call
    And Enter number in Forward call
    Then Click on Recording
    Then click on Save button on Forward Call
    Then Join Menu one to Forward call
    Then Click on Update button for Call FLow
    Then Validate the successfull message as Call Flow is Created
    Then Validate the Record Of Created Call is Inserted
    
#============Edit Functionality=======================

    When User Click on Ellipse button
    And Clicks on Edit button
    Then Click on Findme
    Then click on Add button for Find me Forward
    Then User Enter Number for FindMe
    And Clicks on Add Button
    Then User Clicks on Record on for FindMe
    Then User clicks on Save Button for FindMe
    Then User Joins from Menu TWO TO FindME
    Then User Click on Update button for Edit Functionality
    Then Validate the successfull message as Call Flow is Updated
    Then Validate the Record Of Edit Call Flow is Inserted

#============Delete Functionality=======================

    When User Click on Ellipse for to Delete
    And Clicks on Delete button
    Then User clicks on Delete at are you sure pop-up
    Then User validates the delete toster message
    
    #============Integration Functionality=======================
    
    And Click on integration from Dashboard menu for integration in PBXplus
    When User click on Integrations app as Twilio in PBXplus
    And I Enter the Account Sid for Twillio in PBXplus
    And I Enter the Auth Token in PBXplus
    And I Click on Authentication button in PBXplus
    Then Validate the successfull message in PBXplus
    Then User validate the disabled button for twillio app in PBXplus
    
    
    
    Examples: 
      | TestData  |
      | TestData1 |
