import java.io.*;
import java.net.*;

class TCPServer {
 public static void main(String argv[]) throws Exception {
	  String clientSentence;
	  String capitalizedSentence;
	  String endit = "GG";
	  @SuppressWarnings("resource")
	  ServerSocket welcomeSocket = new ServerSocket(6789);
	  // covers basic communication
	  while (true) {
	  Socket connectionSocket = welcomeSocket.accept();
	  BufferedReader inFromClient =
	  new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	  DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
	  clientSentence = inFromClient.readLine();
	  System.out.println("Received: " + clientSentence);
	  if(clientSentence==null)
	  {
		  System.out.print(endit);
		  break;
	  }
	  capitalizedSentence = clientSentence.toUpperCase() + '\n';
	  outToClient.writeBytes(capitalizedSentence);
  }
 }
}