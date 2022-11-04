Feature: Wikipedia verification title

@scenarioOutlinePractice
Scenario Outline: Wikipedia Search Functionality Title Verification with using DDT

  Given User is on Wikipedia home page
When User types "<searchValue>" in the wiki search box
And User clicks wiki search button
Then User sees "<expectedTitle>" is in the wiki title

Examples:
| searchValue       | expectedTitle       |
| Steve Jobs        | Steve Jobs          |
|Cristiano Ronaldo  | Cristiano Ronaldo  |
  |Bill Gates       | Bill Gates        |
  |Simon Bolivar      | Messi             |
