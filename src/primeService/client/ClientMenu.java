package primeService.client;

import java.util.Scanner;

import primeService.socket.PrimeClientSocket;
import primeService.util.Debug;

public class ClientMenu implements ShowMenuInterface{
	private String ClientName;
	private int queryno;
	private PrimeClientSocket ps=null; 
	private int choice = 0;
	private Scanner s=null;
	private ShowMenuInterface cm = null;
	
	//To show the Menu of client to user
	public int ShowMenu()
	{
		Debug.printToStdout(3,"A Showmenu method is called");
		try{
			s = new Scanner(System.in);
			System.out.println("[1] SetName");
			System.out.println("[2] Enter number to query for prime");
			System.out.println("[3] What is the server response?");
			System.out.println("[4] Quit");
			System.out.println("Enter your choice");
		}
		catch(Exception e){
			e.printStackTrace();
			return s.nextInt();
			}
		finally{}
		return s.nextInt();
		
	}
	//To operate the Menu of client to user
	public void OperateMenu(int port,String hostname)
	{
		Debug.printToStdout(3,"A OperateMenu method is called");
		cm = new ClientMenu();
		try{
		do{
			choice  = cm.ShowMenu();
			if(choice== 1){
				s = new Scanner(System.in);
				System.out.println("Please enter clientname");
				ClientName = s.nextLine();
			}
			else if(choice== 2){
				s= new Scanner(System.in);
				System.out.println("Please enter QueryNo to check for prime");
				queryno = s.nextInt();
				ps = new PrimeClientSocket(ClientName + "," + queryno + ",0",port,hostname);
				ps.sendData();
				}
			else if(choice== 3){
				ps = new PrimeClientSocket(ClientName + ",1",port,hostname);
				System.out.println(ps.getResponse());
			}
			else if(choice== 4)
			{
				System.out.println("Exiting...");
				System.exit(1);
			}			
		}while(choice!=4);
		}
		catch(Exception e){e.printStackTrace();}
		finally{s.close();}
	}
}
