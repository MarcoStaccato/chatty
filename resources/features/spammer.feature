Feature: Spammer

  Scenario: I'm a spammer
    Given I access chat
    When I log in as 'spammer'
    Then I spam! 'I will spam the shit out of this chat'