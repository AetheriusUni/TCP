import java.io.*;
import java.net.*;

class TCPClient {
 public static void main(String argv[]) throws Exception {
	  String sentence="";
	  String modifiedSentence="";
	  String search = "gg";
	  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
	  Socket clientSocket = new Socket("localhost", 6789);
	  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  while(true)
	  {
		  sentence = inFromUser.readLine();
		  if(sentence.toLowerCase().startsWith(search))
		  {
			  break;
		  }
		  outToServer.writeBytes(sentence + '\n');
		  modifiedSentence = inFromServer.readLine();
		  System.out.println("FROM SERVER: " + modifiedSentence);
		  clientSocket.close();
		  clientSocket = new Socket("localhost", 6789);
		  outToServer = new DataOutputStream(clientSocket.getOutputStream());
		  inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	  }
	  clientSocket.close();
 }
}