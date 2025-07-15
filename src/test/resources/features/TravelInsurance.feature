# src/test/resources/features/TravelInsurance.feature

Feature: Travel Insurance Quote Flow

  As a Policybazaar user
  I want to get a travel insurance quote
  So that I can secure my trip

  @Regression @TravelInsurance
  Scenario: Successfully navigate through the travel insurance quote process
    Given I am on the Policybazaar website
    When I click on the "Travel Insurance" link
    And I enter destination country as "France"
    And I select travel dates
    And I click on the continue button
    And I select travellers and their ages
    And I select pre-existing medical condition status
   