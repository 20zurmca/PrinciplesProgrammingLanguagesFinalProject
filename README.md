# Principles of Programming Languages Final Project
The Final Project for CS 301 @ Lafayette College
## Authors
  * Garrett Rademacher '20
  * Joseph Teddick     '20
  * Shira Wein         '19
  * Cameron Zurmuhl    '20

## Contents of Submission
The submission .zip file should contain six items: the Scala Document, the Presentation Slides, a folder containing Examples of Source Code, A folder containing the Game Source Code, the Game Documentation, and this README file.

## Description
This repository holds the final project for our CS301 class at Lafayette College: Principles of Programming Languages. The assignment is to
demonstrate an assigned programming language to the class in the form of a strategic game and examples. Our assigned language was Scala. Our game of choice was Blackjack, a popular casino game where the player plays against a dealer. The player's goal is to get as close as possible to a 21 hand value, with Ace-K, Ace-J, Ace-Q, Ace-10 being automatc winning blackjack hands. Further details of the game are below.

## Installations
The IDE we used for this project is Intellij by JetBrains, and we encourage you to download it to run the examples in the IDE.
You can download IntelliJ here: https://www.jetbrains.com/idea/download. 

To set up a Scala project within IntelliJ, consult this site: https://docs.scala-lang.org/getting-started-intellij-track/getting-started-with-scala-in-intellij.html

If you just want to run our code, you would select "open project" after opening IntelliJ and select either the Blackjack directory or ProgrammingModel for the various Scala examples. Make sure the Scala sdk and Java jdk are configured after loading in the project. The Scala sdk can be downloaded within the IDE. You may need to set the ./src folder as "sources root" and add Scala framework support to the project by right clicking on the toplevel project folder, click "Add Framework Support" and select Scala. When chosing the library, you can download the Scala sdk in this step. You will want to restart the IDE after accomplishing all of this.

## Programming Model
The Programming Model project contains various packages that demonstrate/define different functional/O-O aspects about Scala. The examples provide a sufficient education to get started with the language. Note that Scala runs on the JVM, so integration with Java is very simple. All of the examples are encapsulated around Scala objects that extend the App class, making the object effectively like a main method. To run an example object, you can right click on the name of the object and select the "run" option. The examples are well-commented and all output are put in comments as well. 

## Blackjack

The game of Blackjack requires two or more people (or computers); one dealer as well as one or more players. However, the game is usually played with one dealer and two to seven players. The game is also played with anywhere from one to eight decks, in this version, the game is played with one deck. Each round, each player (including the dealer) is dealt two cards known as their hand. Each player’s cards are dealt face up while the dealer’s first card is dealt face down (their second is dealt face up). 

The goal is to get the cards in the player’s hand to sum to 21, or as close as possible without going over. Number cards count for their printed value, face cards count for ten, and an ace can count as either one point or eleven points. After a player is dealt their hand, they have several options: stand, hit, or split. Standing ends that player’s turn. Hitting will cause the dealer to draw a card off the top of the deck and add that card to the player’s hand. Splitting is only allowed immediately after the player has been dealt their hand and only if both the player’s initial cards match in rank (any two face cards count as a match). Each player goes through all of their options before the dealer makes any moves. After all players have gone, the dealer can now either choose to hit or stand same as the player until the dealer has at least 17 or more as a score of their hand. After the dealer has ended their turn, each player’s hand is evaluated individually against the dealer’s hand; if the players have split hands, both of their hands are evaluated separately. The player wins if they are closer to 21 without going over than the dealer is. If the dealer goes over 21 (known as a bust), then all players win their hands. In the event of a tie, neither the dealer or the player is rewarded (known as a push). This cycle of hands is continued until the player is satisfied.

To play our game, start the round off by pressing deal, then procede to hit, stand, and split to your heart's content.


