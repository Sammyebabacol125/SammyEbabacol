import java.net.*;
import java.io.*;

public class EchoServer {
	
	public static void main(String[] args) {
		System.out.println("***User's Details***");
		try (ServerSocket sock = new ServerSocket(6013)){
			while(true) {
				Socket client = sock.accept();
				System.out.println("---YOU'RE CONNECTED---");
				BufferedReader bin = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter spout = new PrintWriter(client.getOutputStream(),true);
				String line;
				while ((line=bin.readLine()) !=null) {
					System.out.println("On Server: "+line);
					spout.println(line);
				}
				sock.close();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
}
