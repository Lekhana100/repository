
Feature: Verify Homepage and payments

@SanityWeb
Scenario: Verify  login in web
When verify HomePage is loaded 
Then click on Login and register the new user in web
#Then verify I AM A NEW CUSTOMER is displayed for new users in web
#When click on continue for new users in web
#And enter mandatory details for new users in web
#And click on continue in register page in web
Then verify home element is displayed with login details in web
And Add a product to the cart and validate in the payment page



@SanityWeboo
Scenario: Verify payment flow
#When click on URL in browser
#Then click on Login or register in web
And add a product to the cart
And Proceed to the checkout page and continue till payments
Then  Validate on the payments page if the product details are correct.

