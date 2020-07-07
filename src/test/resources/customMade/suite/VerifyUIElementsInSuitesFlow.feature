Feature: Verify UI Flow of the custom made suite Order

  In this feature Entire UI Flow of the Suites flow has to be Validated
  #This feature is just a dummy implementation of unit tests

  Scenario: Validate the UI Flow Of Suite Ordered
    Given user is accessing suitsupply home page with data CM,inStore,Suit,NL
    When he check for options in dropdown
    Then he should view below options to select
    | Option1 | Option2    |  Option3     |  Option4       |  Option5  |  Option6  |
    | FABRIC  | JACKET     | TROUSERS     | EXTRA TROUSERS | WAISTCOAT | SIZE      |