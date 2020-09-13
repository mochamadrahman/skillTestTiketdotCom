Feature: Flight booking transaction with virtual account payment

	@Regression
  Scenario Outline: Transaction with Virtual Account for domestic round trip with 1 transit and login with email
    Given login with <email> and <password>
    When user booking flight for domestic round trip with one transit
    And with virtual account payment schema
    Then user complete booking transaction

    Examples: 
      | email              | password  |
      | testqarahman@gmail.com | Ccgl0618* |
