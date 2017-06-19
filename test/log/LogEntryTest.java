package log;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class LogEntryTest {
	
	@Test
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        // System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        // System.out.println(le2);
    }
    
	@Test
    public void testLogAnalyzer() {
       LogAnalyzer LA = new LogAnalyzer();
       
       LA.readFile("short-test_log");
       
       LA.printAll();
       
       System.out.println("Test completed again");
    }

}
