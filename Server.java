import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

public class Server extends JFrame {
	private JTextArea jt = new JTextArea();
	final int port = 9000;
	DataInputStream in; 
	DataOutputStream out; 
	ServerSocket server;
	Socket socket;
	public static void main(String[] args) {
		new Server();
	}
  //creates basic UI that outputs if server has been created
	public Server() {
		setLayout(new BorderLayout());
		add(new JScrollPane(jt), BorderLayout.CENTER);
		setTitle("RPS Server");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		 try {
			  server = new ServerSocket(port);
			  jt.append("Server Started." + '\n');
			  while(true) {
				  socket = server.accept();
				  jt.append("Client has joined" + '\n');
				  HandleAClient task = new HandleAClient(socket);
				  new Thread(task).start();;
				  
			  }
		 } catch(IOException e) {
			 System.err.println(e);
		 }
	}
}
class HandleAClient implements Runnable {
	private Socket socket;
	public HandleAClient(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while(true) {
				int selection = in.read();

			}
		} catch (IOException e) {
			System.err.println(e);
		}
		
	}
}
