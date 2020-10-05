Feature: Botup Functionality

  Background: Refresh to 500 apps on every scenario
  Given User should refresh the page on every scenario completes

  @Login @botup @integration @bots @document @flow
   Scenario: Botup CallFlow Login Functionality
    Given User navigates to site
      | https://portal.500apps.io/#/login |
    When User enter with login details
      | stgcheck1@yopmail.com | stgcheck1 |
    And User hit the login button
    Then User Validate the dashboard and check welcome message displayed
    When I Click on Botup app from Dashboard
      | Botup | Dashboard |
 
#   ============Intergration for Facebook===========================
#	@integration @botup
#  Scenario: Botup Intergration Functionality
#   When User Click on Integration link from Dashboard
#    | Integrations | 
#    When User click on Integrations app as Facebook for Botup
#    | Facebook_profile1 |
#    And I Enter the User ID for Facebook for Botup
#    | unikai.testing@gmail.com |
#    And I Enter the Password for Facebook
#    | Unikai@123 |
#    And I Click on Login button for Facebook
#    Then Validate the successfull message for Facebook
#    | Authenticated Successfully |
#    Then User validate the disabled button for Facebook app for Botup 

#   ============Intergration for Twilio===========================

    @integration @botup
   Scenario: Botup Adding Integration Functionality   
   When I Click on Integration link from Dashboard for Botup
    | Integrations | 
    When User click on Integrations app as Twilio for Botup
    | Twilio |
    And I Enter the Account Sid for Twillio for Botup
    | ACb77109f19f59d4e12a412d8f9613486f |
    And I Enter the Auth Token for Botup
    | f40f08c326db301fe1b613db63b534ed |
    And I Click on Authentication button for Botup
    Then Validate the successfull message for Botup
    | Authenticated Successfully |
    Then User validate the disabled button for twillio app for Botup  
 
    
#   ================Bots=================================== 
#	 @bots @botup
    Scenario: Botup bots Functionality
     When User Click on Bots link from Dashboard
    | Bots | 
    Then click on Add Bot button
    And Select Flow Name for Bot
    And Enter Name for Bot
    And Select Category for Bot
    And Select for Associlated with for Bot
    Then click on Save button for Bot
    Then User Validate the toster message for bots
        
    When User select the already created Bots and click on Elipsis button For Edit
    And Click on Edit button for Bots
    When I select another Bots and hit the save button
    Then I Validate the toast message for Bots edit
         
    When User select the already created Bots and click on Elipsis button For InActive Status
    And Click on Active button for Bots for Inactive
    When I select IsActive as Inactive Bots and hit the Update button
    Then I Validate the toast message for Bots InActive
     
    When User select the already created Bots and click on Elipsis button For Is Active status
    And Click on Active button for Bots
    When I select IsActive Bots and hit the Update button
    Then I Validate the toast message for Bots IsActive
    
    When User select the already created Bots and click on Elipsis button For Delete
    And Click on Delete button for Bots
    Then I Validate the toast message for Bots Delete
    
#        
#    
#    #   ================Documents=================================== 
#    
#    @document @botup
  Scenario: Botup Document Functionality
      When User Click on Document in Dashboard link
      Then clicks on Add Document in Documents
      And enter the name of the Document
      Then select Document from Browser Desktop
      Then click on Save Button Document
      Then captures the toster message of Document
      
    When User select the already created Document and click on Elipsis button For Delete
     And Click on Delete button for Document
     Then captures the Delete toster message of Document
     
      
#        ================Flow=================================== 
#     @flow @botup
  Scenario: Botup Flow Functionality
      When User Click on Flows in Dashboard link
      Then User Click on Add Flow
      And User Select Default Template
      Then User Clicks on Save Flow button
	  Then captures the toster message of Flow
	  
	 When User select the already created Flow and click on Elipsis button For Edit
    And Click on Edit button for Flow
    When I select another Flow and hit the save button
    | Welcome To Botup |
    Then I Validate the toast message for Flow edit
    
	When User select the already created Flow and click on Elipsis button For Delete
    And Click on Delete button for Flow
    Then I Validate the toast message for Flow Delete
      
	  #        ================Contacts=================================== 
#	      @contact @botup	  
	  Scenario: Botup Contact Functionality
      When User Click on Contacts in Dashboard link
	  
      
      
     
      
     
    
    