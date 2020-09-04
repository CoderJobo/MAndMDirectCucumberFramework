Feature: M And M Direct Item Searching

  Scenario Outline: As a user I want to search for a product
    Given I am navigated to M And M Direct
    When I perform a search for a <ProductName> product
    Then I should see search results for that product

    Examples:
    | ProductName |
    | sunglasses  |
    | boots       |
    | jackets     |
