Feature: Admin

  Scenario: I'm an admin
    Given I access 'http://chat.elpalomito.com'
    When I log in as 'admin'
    Then I admin! 'nah'