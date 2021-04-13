Feature: User Table page logs panel test

  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I login as user "ROMAN"
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    Then "User Table" page should be opened
    When I select 'Vip' checkbox for "Sergey Ivan" on User Table page
    Then Logs should be on Logs panel on User Table page
      | Vip: condition changed to true |