Feature: All bookings.com scenarios

  https://www.booking.com/searchresults.html?aid=397594&label=gog235jc-1DCAEoggI46AdIM1gDaGyIAQGYATG4ARfIAQzYAQPoAQH4AQqIAgGoAgO4AqCxsZ0GwAIB0gIkYjlhNTBmNWEtZDEzMS00OGU5LTlkZGEtNTBiOTZkZWU1YTE42AIE4AIB&sid=3a835ee8169eab4b6a1c4a9772dcba43&sb=1&sb_lp=1&src=index&src_elem=sb&error_url=https%3A%2F%2Fwww.booking.com%2Findex.html%3Faid%3D397594%26label%3Dgog235jc-1DCAEoggI46AdIM1gDaGyIAQGYATG4ARfIAQzYAQPoAQH4AQqIAgGoAgO4AqCxsZ0GwAIB0gIkYjlhNTBmNWEtZDEzMS00OGU5LTlkZGEtNTBiOTZkZWU1YTE42AIE4AIB%26sid%3D3a835ee8169eab4b6a1c4a9772dcba43%26sb_price_type%3Dtotal%26%26&ss=Goa%2C+India&is_ski_area=&checkin_year=2023&checkin_month=1&checkin_monthday=17&checkout_year=2023&checkout_month=1&checkout_monthday=18&efdco=1&group_adults=2&group_children=0&no_rooms=1&b_h4u_keep_filters=&from_sf=1&dest_id=4127&dest_type=region&search_pageview_id=27a368d06a2c00a3&search_selected=true


# 1
  @starverify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select option for stars as <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
     # | 5 stars |
      | 4 stars |
     # | 3 stars |


#2

  @maxAmount
  Scenario: check the hotel prices are below a certain amount
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "10000" amount



#3
  @hotelsSearch
  Scenario: verify given hotel is present in the list
    Given I am on default locations search result screen
    Then I verify "AquaVista" is within search result
