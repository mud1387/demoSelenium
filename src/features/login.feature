Feature: Login functionality

Scenario: Error alert displayed on logging with invalid credentials
	Given User opens Chrome browser and launches the application URL "http://automationpractice.com/index.php"
	Then page title should be "My Store"
	When user clicks on sign in link
	And user enters username as "acfg@gmail.com" and password as "12345"
	And clicks on submit button
	Then Error message is displayed on the page.
