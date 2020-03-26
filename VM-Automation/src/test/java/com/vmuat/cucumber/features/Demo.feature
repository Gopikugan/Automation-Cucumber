@v2.2
Feature: To Check the login functionality of Gmail
	Description: This feature is to validate the login functionality


Background: User in Login page
	Given user already in login page


@Regression
Scenario: Verify user able login to application with valid credentails
	When user try to login with valid credentials
		|username				|password	|
		|gopikugan16@gmail.com	|16june95	|
	Then application should navigate to inbox page
	And verify the title of inbox page


@Smoke
Scenario Outline: Verify user shoud not login to application with invalid credentails
	When user try to login with invalid credentials
	Then appropirate error message should get displayed
Examples:
	|username				|password	|
	|gopikugan16@gmail.com	|16june1995	|
	|gopi@gmail.com			|16june95	|


@Smoke
Scenario: verify the forgot password functionality of login page
	When user click on forgot password link
	Then Email address field should be visible for user