package application;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client implements RPSConstants {

	public static void main(String[] args) {
		
		
		//try catch for errors
		try {
			int score=0;//initializes score counter that only is reset if you rerun code
			//runs if restart is true
			boolean restart = true;
			again: while (restart) {//starts over from "again"

				//Creates scanner object for inputs
				Scanner scanner = new Scanner(System.in);

				//introduction to client/lobby
				System.out.println("Welcome to Rock, Paper, Scissors!\n"
						+ "If you are playing for the first time, press 1 and enter to see the rules\n"
						+ "Press 2 and enter to start game immediately!\n"
						+ "Or press 3 and enter to exit the system.");

				boolean lobby = true;
				while (lobby) {
				
					String startChoice = scanner.nextLine(); //scans for menu input "startChoice"
					
					//menu options
					if (startChoice.equals("1")) {
						System.out.println(
								"When you are asked for an input you have to choose Rock, Paper or Scissors\n"
										+ "Type r for Rock, p for Paper and s for scissors, and then enter\n"
										+ "Rock beats scissors, Paper beats Rock and Scissor beats Paper\n"
										+ "The result will then be diplayed when your opponent has chosen their answer.\n"
										+ "Now please press 1 to see the rules, press 2 to start a game or press 3 to exit. \nEnjoy!");
					} else if (startChoice.equals("3")) {
						System.out.println("Terminating....");
						System.exit(0);// closing in an intended manner
					} else if (startChoice.equals("2")) {
						System.out.println("Now starting game...");
						lobby = false;//exits lobby loop
					} else { // (startChoice != "2" && startChoice != "1" && startChoice != "3")
						System.out.println(
								"Error! Please press 1 to see the rules, press 2 to start a game or press 3 to exit.");
					} 

				}
				
				//access socket in server
				Socket socket = new Socket("localhost", 8000);

				//get and send data to server "socket"
				DataInputStream fromS = new DataInputStream(socket.getInputStream());
				DataOutputStream toS = new DataOutputStream(socket.getOutputStream());

				//get info of player number and feedback accordingly
				int player = fromS.readInt();
				if (player == PLAYER1) {
					System.out.println("You are Player 1");
					System.out.println("Waiting for second player...");
				} else {
					System.out.println("You are Player 2");
				}

				//asks for input from player
				boolean myTurn = fromS.readBoolean();
				if (myTurn) {
					while (true) {
						System.out.println("Players connected! \nPlease input your move: ");
						char move = scanner.next().charAt(0);
						if (move == 'r' || move == 'p' || move == 's') {
							toS.writeInt(move);
							System.out.println("Waiting for opponents choice...");
							System.out.println("");
							break;
						} else {
							System.out.println("Error! Input must be r, p or s");
						}
					}
				}

				//runs always and reads information from server about outcome of the choices of the players
				while (true) {
					char p1Input = fromS.readChar();
					char p2Input = fromS.readChar();

					if (p1Input == 'p') {
						String answer = "Paper";
						System.out.println("Player 1 chose: " + answer);
					}
					if (p1Input == 'r') {
						String answer = "Rock";
						System.out.println("Player 1 chose: " + answer);
					}
					if (p1Input == 's') {
						String answer = "Scissor";
						System.out.println("Player 1 chose: " + answer);
					}

					if (p2Input == 'p') {
						String answer2 = "Paper";
						System.out.println("Player 2 chose: " + answer2);
					}
					if (p2Input == 'r') {
						String answer2 = "Rock";
						System.out.println("Player 2 chose: " + answer2);
					}
					if (p2Input == 's') {
						String answer2 = "Scissor";
						System.out.println("Player 2 chose: " + answer2);
					}

					//conclusion and score count
					int received = fromS.readInt();
					if (received == 1) {
						System.out.println("Player 1 wins!");
						if(player == PLAYER1) {
							score++;	
						}
					} else if (received == 2) {
						System.out.println("Player 2 wins!");
						if(player == PLAYER2) {
							score++;
						}
					} else if (received == 3) {
						System.out.println("It's a Tie!");
					}System.out.println("You have won "+score+" times.");

					//ask for a new game
					System.out.println("Press y to continue with new game, or no to exit");
					if (scanner.next().equals("no")) {
						restart = false;
						System.exit(0);//terminates the program
					} else {
						continue again;// continue code from "again" above
					}

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}