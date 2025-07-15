# src/test/resources/features/CarInsurance.feature

Feature: Car Insurance Quote Submission

  As a user of Policybazaar
  I want to get a car insurance quote
  So that I can compare different insurance plans for my vehicle

  @Regression @CarInsurance
  Scenario: Verify Error Message for Invalid Mobile Number during Car Insurance Quote
    Given I am on the Policybazaar Car Insurance page
    When I proceed without entering a car number
    And I select the city
    And I select the car brand
    And I select the car model
    And I select the fuel type
    And I select the variant
    And I enter user details with name "John Doe" and invalid mobile number "874654372"
    Then I should see an error message containing "valid" for the mobile number field