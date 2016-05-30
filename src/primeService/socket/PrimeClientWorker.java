package primeService.socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import primeService.util.Debug;


public class PrimeClientWorker{
	private Socket socket=null;
	private String Data = null;
	private int port;
	private DataOutputStream dos =null;
	
	//This constructor is used to set Incoming data and port
	public PrimeClientWorker(String clientDataIn,int portIn){
		Debug.printToStdout(4,"A CWorker method is called");
		this.Data = clientDataIn;
		this.port = portIn;
		try {
			this.socket = new Socket("localhost",this.port);
		}
		catch(Exception e){}
	}
	
	public void sendData(){
		Debug.printToStdout(3,"A senddata method is called");
		try {
			dos= new DataOutputStream(this.socket.getOutputStream());
			dos.writeUTF(this.Data);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getResponseServer(){
		Debug.printToStdout(3,"A getresponse method is called");
		String serverResponse = null;
		DataInputStream dis = null;
		try {
			dos = new DataOutputStream(this.socket.getOutputStream());
			dos.writeUTF(this.Data);
			dis = new DataInputStream(this.socket.getInputStream());
			serverResponse = dis.readUTF();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally{
			try {
				dos.close();
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return serverResponse;
	}
}
