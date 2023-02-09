Feature:  VOD Filtering
  As a Product Owner of a Streaming website, I want to be able to filter the VOD section to display only "Darts" videos.

  Background: :
    Given I am on OnDemand tab

  Scenario Outline: Verify that the darts videos are filtered when darts is selected on sports filter
    When I select "<Sports>" as a sports filter
    Then the only filtered "<Sports>" videos should be listed

    Examples:
      | Sports    | Competition | Duration |
      | Darts     |             |          |
      | Golf      |             |          |
      | Snooker   |             |          |
      | Ping Pong |             |          |
      | Fishing   |             |          |

  Scenario Outline: Verify that the darts videos are filtered when darts is selected on sports filter
    When I select "<Sports>" as a sports filter
    And competition as "<Competition>"
    And length of video duration as "<Duration>"
    Then the only filtered "<Sports>" videos should be listed

    Examples:
      | Sports    | Competition              | Duration |
      | Darts     | World Darts Championship | Long     |
      | Pool      | World Cup of Pool        | Medium   |
      | Snooker   |                          | Long     |
      | Ping Pong |                          |          |
      | Fishing   |                          |          |


  Scenario Outline: Verify that the videos are displayed based on search filter
    When I enter "<Search Text>" into the search field
    Then the only filtered "<Search Text>" videos should be listed

    Examples:
      | Search Text |
#      | Darts       |
#      | Fishing     |
#      | Basketball  |
      | Golf        |