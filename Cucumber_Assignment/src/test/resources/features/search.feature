Feature: Search functionality

  @search
  Scenario Outline: Search for an item on the homepage
    Given the user is on the homepage
    When the user searches for "<searchTerm>"
    Then the search results page should display relevant results for "<searchTerm>"

    Examples:
      | searchTerm |
      | Laptop     |
      | Headphones |

  @emptySearch
  Scenario: Attempt to search with an empty input
    Given the user is on the homepage
    When the user searches with an empty string
    Then an error message should be displayed or the page should remain on the homepage

    
    