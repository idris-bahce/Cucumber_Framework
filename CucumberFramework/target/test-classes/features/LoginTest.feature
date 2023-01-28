@Login
Feature: Login User with correct email and password

  Scenario Outline:
    Given Launch browser and land on the home page
    When Click on login button and enter <email> and <password>
    Then click on login button and click delete button and verify that account deleted
    Examples:
      | email          | password |
      | idris@idris123 |123456    |