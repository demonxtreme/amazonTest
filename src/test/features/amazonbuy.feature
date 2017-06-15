Feature: Purchase a product in amazon

Scenario: As a user I want to purchase shoes in amazon
  Given I am on amazon home page
  When I search "nike air max" on amazon
  And I click first item on the list
  And I am on product page
  And I select the size of the shoes
  And I click add to basket button
  And I verify the correct item in the cart
  And I click proceed to checkout
  And I insert my email "pannoalan123@hotmail.com" and pass "123456"
  And I click sign in button
  Then I am on delivery address
