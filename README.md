# Game-of-Games
implementation for game of games

We have 5 small game to play with:
 1. Find the Thimble
 2. Coin Flip
 3. Guess the Number
 4. Even and Odd
 5. Find the Red Thread

PlayGames.java

It is a general game board that user can choose either to play which game or quit the program.

getInput.java

It contains all/only the methods to prompt (if appropriate) and get input from the user, ensuring that the input is valid (correct type and in the value range specified).

There are our 5 games:

hideTheThimble.java

In this game, the players will specify the “best out of number” for the game. For instance, if they choose 7, a player will win the game if they successfully guess the hand holding the thimble 4 or more times. The “best out of number” chosen must be odd

CoinFlip.java

In this game, the players will specify the “best out of number” for the game. For instance, if they choose 7, a player will win the game if they guessed the flip result 4 times. For each coin flip, the player calling heads or tails will indicate if they choose heads or tails.

guessTheNumber.java

In this game, the players will specify the range of numbers and the number of guesses, however the number of guesses cannot be more than half the number of values in the range. So for instance, if the range is from 1-10, the user can make at most 5 guesses.

EvenAndOdd.java

In this game, the players choose even or odd. They remain even or odd for the whole game; they cannot change from throw to throw. Values from 1-5 are valid throws. The user will specify the “best out of number” for the game. For instance, if they choose 7, the first player to win 4 throws wins the game. The “best of number” chosen must be odd.

FindRedThreadGame.java

In this game, the players stipulate how many spools a player can “pull from the box” at a time, but it cannot be more than half the total number of spools. There are always assumed to be 20 spools, one of which is red.”

