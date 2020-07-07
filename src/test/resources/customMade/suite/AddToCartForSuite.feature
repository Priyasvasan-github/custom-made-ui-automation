Feature: Verify User is able to custom made choices to his suite

  In this feature Positive flow of Add to cart functionality of suit is verified
  @tt
  Scenario Outline: Verify users are able to add custom made suit to cart
    Given user is accessing suitsupply home page with data CM,inStore,Suit,NL
    When he chooses <FABRIC>,<JACKET FIT>,<TROUSERS FIT>,<WAISTCOAT>,<TROUSERS (ADDITIONAL)>,<TROUSERS SIZE>,<JACKET SIZE>,<WAIST COAT SIZE>
    Then the summary should have all the options as per selection
    Examples:
      | FABRIC                 | JACKET FIT                  | TROUSERS FIT | TROUSERS (ADDITIONAL)| WAISTCOAT | TROUSERS SIZE  | JACKET SIZE | WAIST COAT SIZE|
      | Navy Plain Wool        | WASHINGTON - Washington Notch Lapel Single Breasted | Brescia      |  Skip | Capetown  | 42             |  42         | 44    |
      | Light Brown Plain Wool | HAVANA - Havana Single Breasted    | Washington                    |Brescia| Skip      |  42             |  42         | NO |