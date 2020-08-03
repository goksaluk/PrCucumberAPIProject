
  @API
  Feature: The task for API
    Background: Placeholder page and content type
      When the user is on Placeholder page
      And  the user accepts content type as "application/json"

    Scenario: Printing email adress and verify a valid post IDs
      And  path parameter should be "postId", random id: "1" and sends request to "/posts/{postId}/comments"
      And  the user prints out their email adress to the console
      Then the user gets this user's associated posts
      And  verify that they contains a valid post IDs an integer between one and hundred

    Scenario: Sending a post request
      And  the user sends POST request to "/posts" with following information:
           |title     |body      |userId   |
           |foo       |bar       |1        |
      Then verify that status code shouldn't be 200

