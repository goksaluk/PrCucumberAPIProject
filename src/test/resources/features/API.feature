
  @API
  Feature: User manipulate the API
    Scenario: Printing email adress and verify a valid post IDs
      When The user is on the Placeholder page
      And  The user accepts content type as "application/json"
      And  Path parameter should be "postId", random id: "1" and sends request to "/posts/{postId}/comments"
      And  The user prints out their email adress to the console
      Then The user gets this user's associated posts
      And  Verify that they contains a valid post IDs an integer between one and hundred

    Scenario: Sending a post request
      When The user is on the Placeholder page
      And  The user accepts content type as "application/json"
      And  The user sends POST request to "/posts" with following information:
           |title     |body      |userId   |
           |foo       |bar       |1        |
      Then Verify that status code shouldn't be 200

