$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/features/homePage.feature");
formatter.feature({
  "name": "Login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Error alert displayed on logging with invalid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User opens Chrome browser and launches the application URL \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.user_opens_Chrome_browser_and_launches_the_application_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "page title should be \"My Store\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.page_title_should_be(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on sign in link",
  "keyword": "When "
});
formatter.match({
  "location": "steps.user_clicks_on_sign_in_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters username as \"acfg@gmail.com\" and password as \"12345\"",
  "keyword": "And "
});
formatter.match({
  "location": "steps.user_enters_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on submit button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.clicks_on_submit_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "No Error message is displayed on the page.",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("file:src/features/login.feature");
formatter.feature({
  "name": "Login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Error alert displayed on logging with invalid credentials",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User opens Chrome browser and launches the application URL \"http://automationpractice.com/index.php\"",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.user_opens_Chrome_browser_and_launches_the_application_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "page title should be \"My Stoe\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.page_title_should_be(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected [My Store] but found [My Stoe]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:453)\r\n\tat org.testng.Assert.assertEquals(Assert.java:463)\r\n\tat com.demo.helper.assertion.assertionHelper.verifyText(assertionHelper.java:8)\r\n\tat com.demo.stepDefinitions.steps.page_title_should_be(steps.java:44)\r\n\tat ✽.page title should be \"My Stoe\"(file:src/features/login.feature:5)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "user clicks on sign in link",
  "keyword": "When "
});
formatter.match({
  "location": "steps.user_clicks_on_sign_in_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "user enters username as \"acfg@gmail.com\" and password as \"12345\"",
  "keyword": "And "
});
formatter.match({
  "location": "steps.user_enters_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "clicks on submit button",
  "keyword": "And "
});
formatter.match({
  "location": "steps.clicks_on_submit_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Error message is displayed on the page.",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.error_message_is_displayed_on_the_page()"
});
formatter.result({
  "status": "skipped"
});
});