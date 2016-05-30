package primeService.client;

import primeService.util.Debug;

public class ClientDriver {
	ClientMenu cm = new ClientMenu();
	int port=0;	
	String hostname;
	public ClientDriver(String hostname,int port){
		Debug.printToStdout(3,"A ClientDriver constructor is called");
		this.port = port;
		this.hostname = hostname;
		
	}
	
	//To select choice from user
	public void Clientdriverfunc()
	{
		Debug.printToStdout(3,"A ClientDriver method is called");
		cm.OperateMenu(this.port,this.hostname);
	}
}

