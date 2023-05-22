
Feature: Verify PurchaseFlow

@SanityWeb
Scenario: Verify  login in web
When verify HomePage is loaded 
Then click on Login and register the new user in web
Then verify home element is displayed with login details in web
And Add a product to the cart and validate in the payment page



