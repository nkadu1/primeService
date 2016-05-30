package primeService.socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import primeService.server.AllPrimeQueries;
import primeService.server.ServerMenu;
import primeService.util.Debug;

public class PrimeServerSocket {
	private Socket socket=null;
	private ServerSocket serversocket=null;
	private int port;
	private AllPrimeQueries apq=null;
	
	//This Function will set the object of AllPrimeQueries
	public PrimeServerSocket (int port,AllPrimeQueries apq)
	{
		Debug.printToStdout(4,"A serverocket method is called");
		this.port = port;
		this.apq = apq;
	}
	
	//This function is used to start the thread based on input port
	public void runprime()
	{
		Debug.printToStdout(3,"A runprime method is called");
		try {
			this.serversocket = new ServerSocket(this.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{}
		PrimeServerWorker psw = null;
		try {
				while(true){
			    this.socket = this.serversocket.accept();
				psw = new PrimeServerWorker(this.socket);
				psw.setQuery(this.apq);
				new Thread(psw).start(); 
				}
			}
			catch(Exception ex){
				}
		finally{}	
	}
}

