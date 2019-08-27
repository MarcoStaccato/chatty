Feature: Spammer

  Scenario: I'm a spammer
    Given I access 'http://chat.elpalomito.com'
    When I log in as 'spammer'
    Then I spam! 'I will spam the shit out of this chat'