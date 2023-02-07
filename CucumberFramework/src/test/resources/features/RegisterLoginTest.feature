Feature: Login User with correct email and password

  @Register
  Scenario Outline: Register Process
    Given Launch browser and land on the home page
    When Click on login button and enter "<name>" and "<email>" and click signup button
    And verify "ENTER ACCOUNT INFORMATION"
    Then select title man and fill details: "<Password>", DateOfBirth:"<day>" "<month>" "<year>"
    And Select checkbox Sign up for our newsletter and Receive special offers from our partners
    Then  Fill details: "<firstName>", "<lastName>", "<company>", "<address>", "<address2>", "<state>", "<city>", "<zipcode>", "<mobileNumber>"
    And Click Create Account button and verify that "ACCOUNT CREATED!" is visible
    Then Click Continue button and verify that "Logged in as idris" is visible
    Examples:
      | name  | email          | Password | day | month | year | firstName | lastName | company | address | address2 | state  | city  | zipcode | mobileNumber |
      | idris | idris@idris123 | 123456   | 4   | May   | 1990 | idris     | ace      | inar    | diri    | sjhdja   | pencap | Delhi | 03300   | 1425369875   |

  @Login
  Scenario Outline: Login process
    Given Launch browser and land on the home page
    When Click on login button and enter "<email>"
    And enter password "<password>"
    Then click on login button and click delete button and verify that account deleted
    Examples:
      | email          | password |
      | idris@idris123 | 123456   |





