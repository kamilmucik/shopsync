#Feature: As a Client, I want to insert record
#
#  Background:
#    Given configured tenant
#
#  Scenario: Invoke accounting service to get correct answer
#    Given Create accounting endpoint connection
#    When I send customerAccountGaming POST request
#    Then The result status code is 200