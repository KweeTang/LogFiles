package log;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class LogAnalyzerTest {

	@Test
    public void testLogAnalyzer() {
       LogAnalyzer LA = new LogAnalyzer();
       
       LA.readFile("short-test_log");
       
       LA.printAll();
       
       LA.printCountUniqueIPs();
 
       LA.printCountVisitsPerIP();
       
       LA.printMostNumberOfVisitsPerIP();

       LA.printIPsForDays();
       
    }

}
