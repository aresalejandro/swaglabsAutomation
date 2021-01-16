@Login
Feature: As a user i want to interact with the Login functionalities

  @SmokeTest
  Scenario Outline: The User : <user> log in successfully into the app
    Given The User is in Swaglabs Login Page
    When The User do the Login with '<user>' and '<password>'
    Then The Home view is displayed

    Examples:
      | user                    | password     |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |
	
  Scenario Outline: The user tries to log in with invalid data
    Given The User is in Swaglabs Login Page
    When The User do the Login with '<user>' and '<password>'
    Then The message '<message>' is displayed
    
    Examples:
      | user            | password     | message                                                                   |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      |                 |              | Epic sadface: Username is required                                        |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   | error        | Epic sadface: Username and password do not match any user in this service |
      | error           | secret_sauce | Epic sadface: Username and password do not match any user in this service |
      | standard_user   |              | Epic sadface: Password is required                                        |
