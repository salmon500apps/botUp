Feature: PBX Plus Call Flow Functionality

  Background: Refresh to 500 apps on every scenario for Pbx module
  Given User should refresh the page on every scenario completes for Pbx module
  
    @pbxplus @Login  @callflow @edit_callflow @inactive_flow @delete_flow @numbers @edit_numbers @delete_numbers @export_numbers @media @voicemails @integrationpbx
  Scenario: PBX Plus Login Functionality
    Given User is navigates to site
      | https://portal.500apps.io |
    When User enter login details
      | stgcheck1@yopmail.com | stgcheck1 |
    And I hit the login button
    Then Validate the dashboard and check welcome message displayed
    When I Click on PBX plus app from Dash board
      | Pbxplus | Call Flows |
      
 @callflow @pbxplus
  Scenario: PBX Plus CallFlow Adding Functionality
  And I Click on Add Call flow button
  When User enter Call Flow Details
  | PBXCallFlow | PBXCallDescription |
  Then I Create a CallFlow for Text Speech
  | Welcome To PBXplus |
  When I Create a CallFlow for Play Audio
  | Media1 |
  And I Create a Call Flow for Business Hours
  | 10:00 | 19:00 |
  When I Create a Call Flow for Voice Mail
  | Media1 | Please Call in Working Hours |
  Then I Create a Call Flow For Menu
  | Media1 | Please wait, We are connecting the Call |
  When I Click on Add Button and Enter the setting details
  | input | name |
  |     1 | Yes  |
  |     2 | No   |
  Then User Press the save button
  When I Create a Call flow for Forward Call
  | 9876543210 |
  And I Hit the Save button for entire call flow and valida the successful toast message
  | Inserted Successfully |
  
#  @edit_callflow @pbxplus
  Scenario: PBX Plus CallFlow Adding Edit Functionality
    When User select the already created callflow and click on Elipsis button
    And Click on Edit button
    When I Click on Find me and Fill the required fields and hit the submit button
    Then I Validate the toast message
      | Updated Successfully |
      
#       @inactive_flow   @pbxplus
   Scenario: PBX Plus CallFlow Adding Inactive and Active Functionality with Views  
    When Click on Call Flow for Inacitve and Active
    When Click on Call Flow for Card View
	And Click on List View
	And Click on Inactive button
	Then User Capture the Sucessfull message of Inactive
	And Click on Active button
	Then Capture the Sucessfull message of Inactive

#  @delete_flow @pbxplus
  Scenario: PBX Plus CallFlow Adding Delete Functionality
    And Clicks on Delete button for callflow
    Then User clicks on Delete at are you sure pop-up dialog
    Then validate call flow delete toster message
      | Deleted Successfully |
      
    
    
	
#	@numbers @pbxplus @testtesttest
  Scenario: PBX Plus numbers Functionality
    When User Click on Numbers in Dashboard link
    Then clicks on Add Number in numbers
    And selects provider
    And Selects number from phone numbers
    And Selects Call Flow ID
    Then clicks on Save Button
    Then captures the toster message of numbers
   
#    @edit_numbers @pbxplus 
  Scenario: PBX Plus numbers Edit Functionality
    When User select the already created numbers and click on Elipsis button
    And Click on Edit button for numbers
    When I select another number hit the save button
    Then I Validate the toast message for numbers edit
      | Updated Successfully |


#  @delete_numbers @pbxplus 
  Scenario: PBX Plus numbers delete Functionality
    And Clicks on Delete button for numbers on elipsis button
    Then User clicks on Delete at are you sure pop-up dialog for numbers
    Then validate numbers delete toster message
      | Deleted Successfully |


#  @export_numbers @pbxplus (Feature Removed)
#  Scenario: PBX Plus numbers export Functionality
#    And Clicks on export button for numbers on elipsis button
#    Then validate numbers export toster message
#      | Export is Completed |
#    
        
#   @media @pbxplus 
  Scenario: PBX Plus media Functionality
      When User Click on media in Dashboard link
      Then clicks on Add Media in Media
      And enter the name of the media
      Then select media from Browser Desktop
      And enter the category
      Then click on Save Button Media
      Then captures the toster message of media
      
#         @voicemails @pbxplus 
  Scenario: PBX Plus Voicemails Functionality
      When User Click on Voicemails in Dashboard link
      Then clicks on Play Recording URL
      And click on ellipse button then export voicemail
      Then captures the toster message of voicemails
      Then click on ellipse button then delete voicemail
      Then captures the toster message of voicemails
      
#      @integrationpbx   @pbxplus
   Scenario: PBX Plus CallFlow Adding Integration Functionality   
   When I Click on Integration link from Dashboard
    | Integrations | 
    When User click on Integrations app as Twilio for pbx
    | Twilio |
    And I Enter the Account Sid for Twillio for pbx
    | ACb77109f19f59d4e12a412d8f9613486f |
    And I Enter the Auth Token for pbx
    | f40f08c326db301fe1b613db63b534ed |
    And I Click on Authentication button for pbx
    Then Validate the successfull message for pbx
    | Authenticated Successfully |
    Then User validate the disabled button for twillio app for pbx  
    
      
      
      
