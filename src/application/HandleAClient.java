package application;



import java.io.*;
import java.net.*;

public class HandleAClient implements Runnable, RPSConstants {

	// Create sockets for the two players
	private Socket player1;
	private Socket player2;

	// constructer that refers to the players
	public HandleAClient(Socket player1, Socket player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			// Get and send data to player1
			DataInputStream fromP1 = new DataInputStream(player1.getInputStream());
			DataOutputStream toP1 = new DataOutputStream(player1.getOutputStream());

			// Get and send data to player2
			DataInputStream fromP2 = new DataInputStream(player2.getInputStream());
			DataOutputStream toP2 = new DataOutputStream(player2.getOutputStream());

			while (true) {

				// Get information of choice in game from both players
				char p1Input = fromP1.readChar();
				char p2Input = fromP2.readChar();

				//gives feedback to the server
				if (p1Input == 'r' || p1Input == 'p' || p1Input == 's' && p2Input == 'r' || p2Input == 'p'
						|| p2Input == 's') {
					System.out.println("P1: " + p1Input);
					System.out.println("P2: " + p2Input);

					//send information to the players of the opponents choice
					toP1.writeChar(p1Input);
					toP1.writeChar(p2Input);

					toP2.writeChar(p1Input);
					toP2.writeChar(p2Input);

					//results calculated and send to the players
					if (p1Input == p2Input) {
						toP1.writeInt(TIE);
						toP2.writeInt(TIE);
						System.out.println("TIEE!");
					} else if (p1Input == 'r' && p2Input == 's') {// player1 wins
						toP1.writeInt(P1WON);
						toP2.writeInt(P1WON);
						System.out.println("P1 Won");
					} else if (p1Input == 'p' && p2Input == 'r') {
						toP1.writeInt(P1WON);
						toP2.writeInt(P1WON);
						System.out.println("P1 Won");
					} else if (p1Input == 's' && p2Input == 'p') {
						toP1.writeInt(P1WON);
						toP2.writeInt(P1WON);
						System.out.println("P1 Won");

					} else if (p2Input == 'r' && p1Input == 's') {// player2 wins
						toP1.writeInt(P2WON);
						toP2.writeInt(P2WON);
						System.out.println("P2 Won");
					} else if (p2Input == 'p' && p1Input == 'r') {
						toP1.writeInt(P2WON);
						toP2.writeInt(P2WON);
						System.out.println("P2 Won");
					} else if (p2Input == 's' && p1Input == 'p') {
						toP1.writeInt(P2WON);
						toP2.writeInt(P2WON);
						System.out.println("P2 Won");
					}

				}

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
