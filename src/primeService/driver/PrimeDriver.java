package primeService.driver;
import primeService.client.ClientDriver;
import primeService.server.ServerDriver;
import primeService.util.Debug;

public class PrimeDriver {
	public static void main(String[] args) {
		try{
			Debug d  = Debug.getInstance();
			
		int i;
		if(args[0].equals("Server"))
		{
			i=Integer.parseInt(args[1]); 
			ServerDriver sd = new ServerDriver(i);
			sd.Serverdriverfunc();
		}
		else
		{
			i=Integer.parseInt(args[1]);
			d.set(Integer.parseInt(args[3]));
			ClientDriver cd = new ClientDriver(args[2],i);
			cd.Clientdriverfunc();
		}
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
		}
	}
}
