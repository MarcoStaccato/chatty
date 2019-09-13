Feature: Admin

  Scenario: I'm an admin
    Given I access chat
    When I log in as 'admin'
    Then I admin! 'nah'