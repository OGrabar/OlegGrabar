Feature: Different elements page test

  Scenario: Go to Different elements page. Select checkboxes, radio buttons and dropdowns. Verify logs
    Given I open JDI GitHub site
    Then 'Home Page' page should be opened
    When I login as user 'ROMAN'
    Then Username should be 'ROMAN IOVLEV'
    When I click on 'Service' button in Header
    And I click on 'Different elements' button in Service dropdown
    Then 'Different Elements' page should be opened
    When I click 'Water' checkbox on Different elements page
    And I click 'Wind' checkbox on Different elements page
    And I click 'Selen' radio button on Different elements page
    And I select 'Yellow' dropdown option on Different elements page
    Then Logs should be on Logs panel on Different elements page
      | Yellow |
      | Selen  |
      | Wind   |
      | Water  |