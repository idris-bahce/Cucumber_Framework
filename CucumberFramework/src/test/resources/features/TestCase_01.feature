
  Feature: Test Case 01

    Scenario:Test Case 1: Register User
      Given Launch browser and Navigate to url and Verify that home page is visible successfully
      When Click on Signup  Login button Verify New User Signup! is visible
      And Enter name and email address, Click Signup button and Verify that ENTER ACCOUNT INFORMATION is visible
      Then Fill details: Title, Name, Email, Password, Date of birth
      And Select checkbox Sign up for our newsletter! and  Select checkbox Receive special offers from our partners
      Then Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
      And Click Create Account button and erify that ACCOUNT CREATED! is visible