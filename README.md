## Introduction

The Server side of this rock, paper, scissors game consists of two classes. The main Server class and the Handler class, whereas the Server contains the Multithread and therefore enables connecting to several players
In order to start a game, a server is required to be running before the clients can join the server. As soon as two clients joined the server, a rock, paper, scissors game will start.
The server side has been developed by ...
The client side has been developed by ...

## Step-by-Step guide 

**Step 1:** Download the repository by clicking this link: PCSS2019Group4. Download the ZIP-file and save it to a local folder on your computer. Make sure that you have the latest java development kit installed on your computer.<br/>

**Step 2:** In case you have not installed Eclipse before, please do that now. You can find the link on how to install Eclipse here: https://www.eclipse.org/downloads/packages/installer <br/>

**Step 3:** After you have successfully installed Eclipse and downloaded the file on your computer, try to find and open the file. If you cannot find it, you can search for it in the file explorer search bar. <br/>

**Step 4:** When you have found the folder containing all the games content, click on the folders individual name → “src” → “application” and then mark all 4 files. Right click on the four marked files and choose “Open”. If it does not automatically open with Eclipse then press “Open with…” and choose “Eclipse”. <br/>

**Step 5:** You should now have the application window of Eclipse opened with 4 small tabs on the top of the screen, right beneath the menu options. <br/>

**Step 6:** If you want to play the game on your own computer, the already implemented keyword “localhost” will work as an IP-address. The only thing you have to do is make a copy of the Client-class and call it e.g. Client2. After that, you can just start running the server-class (by clicking the green run-button) and afterwards run the two clients. The game will then give you further instructions on how to play. If the game does not run then make sure if the port has the same number. By default (our decision) it is set to 8000. <br/>

**Step 7:** In case you want to play on multiple computers, you will need to obtain the correct IP-address through the command prompt (cmd) before you can start the game. This can be done by opening cmd and enter the command “ipconfig”. That will display you different information, whereat only the IPV4 address (looking like this: 192.168.??.??) is important for you. Copy the address and paste it both in the server and client class instead of the keyword “localhost”. You should then be able to play the game on several computers using the Client and Client2 class. <br/>


## Gameplay
The first message the player will see is:
*Welcome to Rock, Paper, Scissors! :)*
*If you are playing for the first time, press 1 and enter to see the rules*
*Press 2 and enter to start game immediately!*
*Or press 3 and enter to exit the system.*
 
The rules of our game are the same as for a normal rock, paper, scissors game, which are: 
*rock beats scissors, paper beats rock and scissors beats paper*
These rules will be displayed to the players if they want to see them by clicking a certain number.

If the first player clicks 2, he has to wait till a second player joins the game. As soon as there is a second player, the real game starts and the players are asked for a user input. They have three options to choose from:
*‘r’ = rock, ‘p’ = paper and ‘s’ = scissors*

As soon as the second player entered his choice as well, both choices will be displayed and a winner is presented. After the game is over, the players have three choices: see the rules again (click 1), replay the game (click 2) or exit the game (click 3).
