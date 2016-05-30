package primeService.socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import primeService.client.ShowMenuInterface;
import primeService.server.AllPrimeQueries;
import primeService.server.ServerDriver;
import primeService.server.ServerMenu;
import primeService.util.CheckPrime;
import primeService.util.Debug;

public class PrimeServerWorker implements Runnable{

	private Socket socket=null;
	private AllPrimeQueries apq=null;
	private CheckPrime cp;
	private DataInputStream dis = null;
	private String clientData = null;
	private int isPrime;
	private int number;
	private DataOutputStream dos = null;
	
	public PrimeServerWorker(Socket socket)
	{ 
		Debug.printToStdout(4,"A Serverworker method is called");
	 this.socket = socket;
	}
	//To set the Query
	public void setQuery(AllPrimeQueries apq)
	{
		Debug.printToStdout(3,"A setquery method is called");
		this.apq = apq;
	}
	
	//This will run when the thread in server socket will start
	public void run() {
		Debug.printToStdout(3,"A run method is called");
		try{
	    	dis = new DataInputStream(this.socket.getInputStream());
	    	dos = new DataOutputStream(this.socket.getOutputStream());
	        clientData = dis.readUTF();
	        String[] split = clientData.split(",");
	        if(split.length == 3){
	        	this.apq.Storedata(split[0],Integer.parseInt(split[1]));
			}
	        else if(split.length == 2){
	        	List<Integer> ls=null;
	        	ls = this.apq.HS.get(split[0]);
	        	number =  ls.get(ls.size()-1);
	        	if(number > 3)
	        	{
	        		cp = new CheckPrime();
	        		isPrime = cp.checkifprime(number);
					if(isPrime == 1)
						dos.writeUTF(number  + " : is prime");
					else
						dos.writeUTF(number  + " : is not prime");
	        	}
	        	else
	        	{
	        		dos.writeUTF("Entered number " + number  + " : is less than Threshold value 3");
	        	}
				
		    }
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			try {
				dis.close();
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    }
}
