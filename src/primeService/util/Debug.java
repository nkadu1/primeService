package primeService.util;

public class Debug {
	private volatile static Debug uniqueInstance;
	private static int debugValue;
	
	private Debug() 
	{
	}
	
	public static Debug getInstance() 
	{
		if(uniqueInstance == null)
		{
			synchronized (Debug.class) 
			{
				if(uniqueInstance == null)
				{
					uniqueInstance = new Debug();
				}
			}
		}
		
		return uniqueInstance;
	}
	
	public  void set(int value)
	{
		debugValue = value;
	}
	
	public int get()
	{
		return debugValue;
	}
	
	public static void printToStdout(int level, String debugMessage)
	{
		
		if(level == debugValue)
		{
			System.out.print(level);
			System.out.println(","+debugMessage);
		}	
	}

}
