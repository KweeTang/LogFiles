package log;

import java.util.ArrayList;

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
	
	public void printAll() {
		
		for (LogEntry le : records){
			System.out.println(le);
		}
	}
}
