# Live Football World Cup Score Board

This is a simple Java application that allows you to keep track of live scores of football matches.

## Usage

You can interact with the application through the command line interface:

> Start a new match: enter option `1` and follow the prompts to enter the home and away team names.
> Update score: enter option `2` and provide the match ID, home team score and away team score.
> Finish a match: enter option `3` and provide the match ID.
> Get live score board: enter option `4` to see the live score board of matches in progress.
> Exit: enter option `5` to exit the application.

## Class Details

### LiveFootballWCScoreBoard

This class maintains a collection of `LiveMatch` objects and provides methods to add, update and remove matches. It also provides a method to retrieve the live score board.

### LiveMatch

This class represents a single football match with a unique ID, home and away teams, and scores. It provides methods to update the scores and retrieve various details of the match. It implements the `Comparable` interface to enable sorting of matches by total score and ID.

## How to use from Visual Studio Code

1. Download the source code to a directory of your choice.
2. Open the extracted directory in Visual Studio Code.
3. Run the `LiveFootballWCScoreBoard.java` file by right-clicking on the file and selecting `Run Java`.
4. Interact with the application through the command line interface.


# Live Football World Cup Score Board Test

This is a JUnit test class for the `LiveFootballWCScoreBoard` class. 

## Dependencies

This class has the following dependencies:

> JUnit
> LiveFootballWCScoreBoard
> LiveMatch

## Tests 

This class has the following tests:

> `teststartNewMatch()`: tests the `startNewMatch()` method of the `LiveFootballWCScoreBoard` class.
> `testUpdateScore()`: tests the `updateScore()` method of the `LiveFootballWCScoreBoard` class.
> `testFinishMatch()`: tests the `finishMatch()` method of the `LiveFootballWCScoreBoard` class.
> `testGetLiveScoreBoard()`: tests the `getliveScoreBoard()` method of the `LiveFootballWCScoreBoard` class.
 
Each test method verifies the expected behavior of a specific method in the `LiveFootballWCScoreBoard` class using assertions provided by JUnit.

## How to run the tests from Visual Studio Code

1. Open the file `LiveFootballWCScoreBoardTest.java` in Visual Studio Code.
2. Click on the Test Explorer icon on the left-hand side of the window to open the Test Explorer panel.
3. Click on the Refresh button in the Test Explorer panel to scan for tests.
4. Once the tests have been detected, you can either run them individually or all at once.
5. Once the tests have been run, the Test Explorer panel will show the results of each test, including whether it passed or failed.
