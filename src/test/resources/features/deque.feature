Business Need: Deque

  @deque
  Scenario: Test Queue assignment
    When I am on home page
    Then I see main page has loaded successfully
    And I verified that there 5 total number of radio buttons
    When I click on add a traveler
    Then I see another select is added to the page
    When I click arrow under the video and see that the video get changed

    @accessibility
    Scenario: test accessibility
      Then I am doing accessibility testing
