import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		final int port = 1234;
		Server server = new Server(port);
	
		boolean stop = false;
		Scanner input = new Scanner(System.in); 
		while (!stop) {
			 System.out.println("Enter STOP to stop Server");
			 if (input.nextLine().equals("STOP")) {
//				 if (Thread.activeCount() < 3) {
					 stop = true;
//				 }
//				 else {
//					 System.out.println("Client connected, stopping");
//					 Server.Stop();
//					 
//					 while (Thread.activeCount() > 2) {
//						 Thread.sleep(1000);
//					 }
//				 }
			 } 
		}
		
		
		
		System.out.println("Server stopped");
		System.exit(0);
	}

}
