Feature:
  Verify different GET requests using Rest Assured.

  Scenario:
    Given The list of all guests;
    When The request that gets all guest from the list is executed;
    Then Status code 200 must be returned when getting all guests;
    And An object containing all guests from the list must be returned.

  Scenario:
    Given A guest in the list of an event;
    When The request that gets a guest by the ID is executed;
    Then Status code 200 must be returned when getting guest by ID;
    And An object containing all the information about the guest must be returned.

