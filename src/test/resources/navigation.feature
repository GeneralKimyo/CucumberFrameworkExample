Feature: Navigation Testing
    As a user
    I want to navigate every pages
    So that I can use other features of website
@TC001
Scenario: Successful navigation to Store Page (TC001)
    Given I am on the home page
    When I click on store menu link
    Then I should see the store page
@TC002
Scenario: Successful navigation to About Page (TC002)
    Given I am on the home page
    When I click on About menu link
    Then I should see the About page
    And I should see the About Us title