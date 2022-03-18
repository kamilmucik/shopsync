Feature: Call echo feature test

  Background:
    Given configured tenant

  Scenario: Invoke version service to get correct answer
    Given Create endpoint connection
    When I send POST request
    Then The result status code is 200