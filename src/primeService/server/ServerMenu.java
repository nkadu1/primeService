package primeService.server;
import java.util.Scanner;

import primeService.client.ShowMenuInterface;
import primeService.util.Debug;

public class ServerMenu implements ShowMenuInterface{
	
	private Scanner instream = new Scanner(System.in);
	private String ClientName = null;
	public AllPrimeQueries apq = null;
	private  int choice =0;
	private Scanner s=null;
	
   // private ServerMenu sm = new ServerMenu(); 
	public ServerMenu (AllPrimeQueries apq )
	{
		Debug.printToStdout(2,"A ServerMenu is called");
		this.apq = apq;
	}
	
	/*This Function will read input from keyboard and returns the app choice
	 * 
	 * (returns selected choice)
	 * @see primeService.client.ShowMenuInterface#ShowMenu()
	 */
	public int ShowMenu()
	{
		try{
		s= new Scanner(System.in);	
		System.out.println("[1] Client Name [print the name and query integer]" );
		System.out.println("[2] All Client Queries [print all names and queries so far]");
		System.out.println("[3] Quit [quit the server]");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{s.close();}
		return s.nextInt();
		}

	//To do the selected operation based on choice
	public void OperateMenu(int port)
	{
		try{
		do{
			choice = this.ShowMenu();
			if(choice== 1)
			{
				System.out.println("Enter Client Name");
				ClientName = instream.nextLine();
				System.out.print("Clientname : " + ClientName);
		    	if(apq.HS.containsKey(ClientName))
		    		System.out.println(apq.HS.get(ClientName).toString());
		    	else
		    		System.out.println("This Client Name does not exist ");
			}
			if(choice== 2)
			{
				for ( String key : this.apq.HS.keySet() ) {  // "for each key in the map's key set"
				    String value = (this.apq.HS.get(key)).toString();
				    System.out.println( " " + key + "," + value + " " );
				}
			}
			
			else if(choice== 3)
			{
					System.out.println("Exit from Server");
					System.exit(1);
			}
		}while(choice!=3);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			s.close();
		}
	}
}
