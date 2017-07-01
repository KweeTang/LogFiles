package log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import edu.duke.FileResource;

public class LogAnalyzer {

	private ArrayList<LogEntry> records;
	
	public LogAnalyzer() {
		records = new ArrayList<LogEntry> ();
	}
	
	public void readFile(String filename)
	{
		FileResource fr = new FileResource(filename);
		
		for ( String line : fr.lines())
		{
			records.add(WebLogParser.parseEntry(line));
		}
	}
	
	
	
	private int countUniqueIPs(){
		
		// Start with an empty list
		ArrayList<String> UniqueIPs = new ArrayList<String> ();
		
		// Loop through the ArrayList
		for (LogEntry le : records){
			String ipaddress = le.getIpAddress();
			
			if(!UniqueIPs.contains(ipaddress)) {
				UniqueIPs.add(ipaddress);
			}
		}
		return UniqueIPs.size();
	}
	
	private HashMap<String, Integer> countVisitsPerIP () {
	
		HashMap<String, Integer> map = new HashMap<String, Integer> ();
		
		for (LogEntry le : records)
			{
				String ipaddress = le.getIpAddress();
				
				// New ip address
				if (!map.containsKey(ipaddress)) {
					map.put(ipaddress, 1);
				}
				else {
						map.put(ipaddress, map.get(ipaddress) + 1 );
				}
			}
		return map;
	}
	
	private int MostNumberVisitsPerIP (HashMap<String, Integer> IPs){
		
		// Set Max to the first IP address count
		int Max = 0;
		// Iterate through each IP address
			for (String key : IPs.keySet()) {
		//    if IP address count > Max
			  if(IPs.get(key) >= Max)	
	    //       Max = IP address count
				 Max = IPs.get(key); 
			}
		return Max;
	}
	
	private HashMap<String, ArrayList<String>> IPsForDays() {
	
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>> ();
		
		ArrayList<String> alist = new ArrayList<String>();
		
		// Loop through the log entries
		for (LogEntry le : records) {
		
			Date date = le.getAccessTime();
			
			// Add Ip address to alist
			alist.add(le.getIpAddress());
			
			// Map days to IP addresses
			map.put(date.toString(), alist);

		}
		return map;
	}
	
	
	// Print functions
	public void printAll() {
		
		for (LogEntry le : records){
			System.out.println(le);
		}
	}
	
	public void printCountUniqueIPs() {
		System.out.println ("Unique IPs: " + countUniqueIPs());
	}
	
	public void printCountVisitsPerIP() {
		
		HashMap<String, Integer> map = countVisitsPerIP();
		
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
	}
	
	public void printMostNumberOfVisitsPerIP() {
		
		System.out.println("***printMostNumberOfVisitsPerIP***");
		
		System.out.println(MostNumberVisitsPerIP(countVisitsPerIP()));
	}

	public void printIPsForDays() {
		
		System.out.println("***printIPsForDays***");
		
		HashMap<String, ArrayList<String>> map = IPsForDays(); 
		
		for(String key : map.keySet()) {
			System.out.println(key + map.get(key));
		}
	}

}
