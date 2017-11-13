Feature: Search
  As a interview candidate
  I want to search for public Flickr feed and compare results against end point results
  So that i accomplish technical test


  Scenario Outline: Search for feed and compare results
    Given Iam home homePage
    When I search for feed "<name>"
    Then I validate ui results with an endpoint "<uri>"

    Examples:
      | name    | uri                                                                                               |
      | rihanna | https://api.flickr.com/services/feeds/photos_public.gne?format=json&nojsoncallback=1&tags=rihanna |

