package primeService.server;
import primeService.socket.PrimeServerSocket;
import primeService.util.Debug;

	public class ServerDriver implements Runnable{
	private int port;
	private AllPrimeQueries apq= null;
	private ServerMenu sm = null;
	
	public ServerDriver(int port)
	{
		Debug.printToStdout(4,"A ServerDriver constructor is called");
		this.port = port;
		this.apq = new AllPrimeQueries(); 
	}
	
	//Function to perform appropriate action based on choice
	public void Serverdriverfunc()
	{
		Debug.printToStdout(3,"A ServerDriverfunc() method is called");
		// to check
		Thread t1 = new Thread(this);
		t1.start();
		sm = new ServerMenu(this.apq);
		sm.OperateMenu(this.port);
	}	

	//This function will be invoked when the thread [t1] defined above will start
	public void run(){
		Debug.printToStdout(3,"A run method is called");
		PrimeServerSocket  pss1 = new PrimeServerSocket(this.port,this.apq);
		pss1.runprime();
	}
}