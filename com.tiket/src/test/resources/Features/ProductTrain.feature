Feature: Train booking transaction with non-instan payment

	@Smoke
  Scenario Outline: Train transaction with non-instant payment for one-way trip with 1 adult and 1 infant login with email
    Given user login with <email> and <password>
    When user booking train for one-way trip with one adult and one infant
    And with non-instant payment schema
    Then user successful complete booking transaction

    Examples: 
      | email              | password  |
      | testqarahman@gmail.com | Ccgl0618* |
