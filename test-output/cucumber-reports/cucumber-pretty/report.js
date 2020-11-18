$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/API-Test.feature");
formatter.feature({
  "line": 1,
  "name": "API test",
  "description": "",
  "id": "api-test",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7051620339,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Should see SINGLE USER data",
  "description": "",
  "id": "api-test;should-see-single-user-data",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 9,
      "name": "@sampletest"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "I make a search for user 3",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I should see following user data",
  "rows": [
    {
      "cells": [
        "first_name",
        "email"
      ],
      "line": 13
    },
    {
      "cells": [
        "Emma",
        "emma.wong@reqres.in"
      ],
      "line": 14
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 25
    }
  ],
  "location": "StepDefinition.i_make_a_search_for_user(int)"
});
formatter.result({
  "duration": 5128361700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.i_should_see_following_user_data(DataTable)"
});
formatter.result({
  "duration": 69712867,
  "error_message": "org.json.JSONException: A JSONArray text must start with \u0027[\u0027 at 1 [character 2 line 1]\n\tat org.json.JSONTokener.syntaxError(JSONTokener.java:507)\n\tat org.json.JSONArray.\u003cinit\u003e(JSONArray.java:109)\n\tat org.json.JSONArray.\u003cinit\u003e(JSONArray.java:162)\n\tat AutomationTest.BrightTalkTest.StepDefinition.i_should_see_following_user_data(StepDefinition.java:94)\n\tat ✽.Then I should see following user data(src/test/java/API-Test.feature:12)\n",
  "status": "failed"
});
formatter.after({
  "duration": 198492853,
  "status": "passed"
});
});