package application;

import java.io.*;
import java.net.*;//import all of .net including socket and server

public class Server implements RPSConstants {

	static int playerCount = 0;
	static int gameCount = 0;
	static boolean ready = false;

	public static void main(String[] args) {
		// specify where the server and client connect
		int port = 8000;

		new Thread(() -> {
			try {
				// make a Server socket in the port
				ServerSocket serverSocket = new ServerSocket(port);

				while (true) { // Check all the time

					// accept player1 to access port
					Socket player1 = serverSocket.accept();
					playerCount++;
					new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);
					System.out.println("Player " + playerCount + " online."); // server knows player is connected

					// accept player2 to access
					Socket player2 = serverSocket.accept();
					ready = true;
					playerCount++;
					gameCount++;
					new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);
					new DataOutputStream(player1.getOutputStream()).writeBoolean(ready);
					new DataOutputStream(player2.getOutputStream()).writeBoolean(ready);
					System.out.println("Player " + playerCount + " online."); // server knows player is connected
					System.out.println("Game nr: " + gameCount + " started."); // define gamenumber

					// Start a thread that creates a handler that takes two payers
					new Thread(new HandleAClient(player1, player2)).start();// Thread constructor
				}

			} catch (IOException ex) {// make error if try is not succeeded
				System.err.println(ex);
			}
		}).start();

	}
}
