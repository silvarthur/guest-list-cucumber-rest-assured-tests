Feature:
  Verify different POST requests using Rest Assured.

  Scenario:
    Given A person to be added to the list of guests;
    When The request that inserts a guest to the list is executed;
    Then The new guest must be added to the list successfully.