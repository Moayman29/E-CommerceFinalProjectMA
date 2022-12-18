@smoke

Feature: users could register with new accounts

  Scenario: guest user could register with valid data successfully

  Given user go to register page
  And user select gender type
  When user enter first name "automation" and last name "tester"
  And user enter date of birth
  And user enter email "test3@example.com" field
  And user fills Password fields "P@ssw0rd" "P@ssw0rd"
  And user clicks on register button
  Then success message is displayed