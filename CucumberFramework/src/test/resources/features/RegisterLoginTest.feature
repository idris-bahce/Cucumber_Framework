
Feature: Login User with correct email and password

  Scenario Outline: Register Process
    Given Launch browser and land on the home page

  Scenario Outline: Login process
    Given Launch browser and land on the home page
    When Click on login button and enter "<email>"
    And enter password "<password>"
    Then click on login button and click delete button and verify that account deleted
    Examples:
      | email          | password |
      | idris@idris123 | 123456   |





