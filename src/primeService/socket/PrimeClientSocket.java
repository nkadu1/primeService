package primeService.socket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import primeService.server.AllPrimeQueries;
import primeService.util.Debug;

public class PrimeClientSocket {
	private PrimeClientWorker pcw=null;
	private Socket socket=null;
	private int port=0;
	private String Data;
	private DataOutputStream dos =null;
	private String hostname;
	
	public PrimeClientSocket(String dataIn,int portIn,String hostname){
		Debug.printToStdout(4,"A primeclient constructor is called");
		this.Data = dataIn;
		this.port = portIn;
		this.hostname = hostname;
		pcw = new PrimeClientWorker(this.Data,this.port);
	}
	//To get the response from server
	public String getResponse()
	{
		Debug.printToStdout(3,"A getresponse method is called");
		return pcw.getResponseServer();
	}
	//To send data to server
	public void sendData(){
		Debug.printToStdout(3,"A senddata method is called");
		try {
			socket = new Socket(this.hostname, this.port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{}
		pcw.sendData();
	}
}	
