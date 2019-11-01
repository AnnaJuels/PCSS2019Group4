## Introduction

The Server side of this rock, paper, scissors game consists of two classes, the Server class and the Handler class. The Server contains the Multithread and therefore enables connecting to several players at once.
In order to start a game, a server needs to be running before the clients can join the server. As soon as two clients join the server, they can start the rock, paper, scissors game.
The server side has been developed by ...
The client side has been developed by ...

## Step-by-Step guide 

**Step 1:** Download the repository by clicking this link: https://github.com/bjornwinther/PCSS2019Group4. Download the ZIP-file and save it to a local folder on your computer. Make sure that you have the latest java development kit installed on your computer.<br/>

**Step 2:** In case you have not installed Eclipse before, please do that now. You can find the link on how to install Eclipse here: https://www.eclipse.org/downloads/packages/installer <br/>

**Step 3:** After you have successfully installed Eclipse and downloaded the file on your computer, try to find and open the file. If you cannot find it, you can search for it in the file explorer search bar. <br/>

**Step 4:** When you have found the folder containing all the games content, click on it and the following folders: → “src” → “application” and then mark all 4 files. Right click on the four marked files and choose “Open”. If it does not automatically open with Eclipse then press “Open with…” and choose “Eclipse”. <br/>

**Step 5:** You should now have the application window of Eclipse opened with 4 small tabs on the top of the screen, right beneath the menu options. <br/>

**Step 6:** If you want to play the game on your own computer, the already implemented keyword “localhost” will work as an IP-address. The only thing you have to do is make a copy of the Client-class and call it e.g. Client2. After that, you can just start running the server-class (by clicking the green run-button) and afterwards run the two clients. The game will then give you further instructions on how to play. If the game does not run then make sure if the port has the same number. By default (our decision) it is set to 8000. <br/>

**Step 7:** In case you want to play on multiple computers, you will need to obtain the correct IP-address through the 'Command Prompt' on a Windows computer (cmd) or 'Terminal' on Mac before you can start the game. The easiest way to access the Command Prompt or Terminal is to search for them on your computer. After opening opening cmd (Windows) enter the command “ipconfig”. If you are opening terminal (Mac), enter the command "ipconfig getifaddr en0". The Windows computer will display you a lot of information, but you only need the IPV4 address (looking like this: 192.168.??.??). For the Mac, the IP address should be the only thing displayed. Copy the address and paste it both in the server and client class instead of the keyword “localhost”. You should then be able to play the game on several computers by all using the Client class downloaded on each computer. <br/>

## Gameplay

The first message the player will see is: <br/>
<p align="center">
Welcome to Rock, Paper, Scissors! <br/>
If you are playing for the first time, press 1 and enter to see the rules <br/>
Press 2 and enter to start game immediately! <br/>
Or press 3 and enter to exit the system. <br/>
</p>
 
The rules of our game are the same as for a normal rock, paper, scissors game, which are: <br/>
<p align="center">
rock beats scissors, paper beats rock and scissors beats paper <br/>
</p>
These rules will be displayed to the players if they want to see them by typing ‘1’ into the console. 

If the first player presses 2, they have to wait till a second player joins the game. As soon as there is a second player, the real game starts and the players are asked for their input. They have three options to choose from:
 <br/>
<p align="center">
‘r’ = rock, ‘p’ = paper and ‘s’ = scissors <br/>
</p>

As soon as both players have entered their choices, both choices will be displayed and a winner is presented. After the game is over, the players have three choices: see the rules again (press 1), play a game again (press 2) or exit the game (press 3).
