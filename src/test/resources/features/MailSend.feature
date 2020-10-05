Feature: Mailsend Functionality

  Background: Refresh to 500 apps on every scenario for mailsend
  Given User should refresh the page on every scenario completes for mailsend

  @Login @botup @integration @bots @document @flow
   Scenario: mailsend Login Functionality
    Given User navigates to site for mailsend
      | https://portal.500apps.io/#/login |
    When User enter with login details for mailsend
      | stgcheck1@yopmail.com | stgcheck1 |
    And User hit the login button for mailsend
    Then User Validate the dashboard and check welcome message displayed for mailsend
    When I Click on Botup app from Dashboard
      | Mailsend | Dashboard |
