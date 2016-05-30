package primeService.server;
import java.util.List;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import primeService.util.Debug;

public class AllPrimeQueries {
	//Hashtable to store Key-Value pairs
	public Map <String,List<Integer>> HS =null;

	public AllPrimeQueries(){
		Debug.printToStdout(4,"A AllPrimeconstructor is called");
		HS	= new Hashtable<String,List<Integer>>();
	}

	//Function to store data in Hashtable based on input client name
	public void Storedata(String s , int value){
		Debug.printToStdout(3,"A StoreData Method is called");
		//System.out.println("In store function");
		List<Integer> chain = new ArrayList<Integer>();;
		if(HS.containsKey(s)){
			chain = HS.get(s);
			chain.add(value);
			
		}else{
			chain.add(value);
			HS.put(s, chain);
		}
		//System.out.println("chain " + chain.toString());
	}
	
}
