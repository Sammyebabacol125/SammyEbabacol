import java.net.*;
import java.io.*;
public class EchoClient {
	
	public static void main(String[] args) {
		String line;
		
		System.out.println("***User's Details***");
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		try {
			Socket sock = new Socket("127.0.01",6013);
			PrintWriter cpout = new PrintWriter(sock.getOutputStream(),true);
			BufferedReader bin = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			System.out.println("---YOU'RE CONNECTED---");
			while (true) {
				System.out.println("Please Enter Text(press ENTER): ");
				line = scan.readLine();
				if("stop".equalsIgnoreCase(line))
					break;
				cpout.println(line);
				String echo = bin.readLine();
				System.out.println("Server says: "+echo);
						}
			sock.close();
		}catch (IOException e) {
			System.err.println(e);
		}
}
}