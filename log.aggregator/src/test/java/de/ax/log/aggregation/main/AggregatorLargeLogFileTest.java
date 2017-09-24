package de.ax.log.aggregation.main;

import static org.junit.Assert.assertEquals;

import java.io.FileOutputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ax.log.aggregation.model.ProcessSeverity;

public class AggregatorLargeLogFileTest {
	
	private static String path;
	private static Aggregator aggregator;
	
	@BeforeClass
	public static void setupBeforeClass() {
		path = Thread.currentThread().getContextClassLoader().getResource("large-log-file.data").getPath();

		try(FileOutputStream fos = new FileOutputStream(path)) {
			int i = 0;
			for (; i < 2000000; i++) {
				fos.write(("{requestId:\""+ i+1 +"\", processId:\"7\", host:\"tc-1\", severity:\"ERROR\", timestamp:\"17.06.2015 14:13:25.023\"}\n").getBytes());
			}
			for (; i < 4000000; i++) {
				fos.write(("{requestId:\""+ i+1 +"\", processId:\"4\", host:\"tc-2\", severity:\"INFO\", timestamp:\"17.06.2015 14:13:25.023\"}\n").getBytes());
			}
			for (; i < 6000000; i++) {
				fos.write(("{requestId:\""+ i+1 +"\", processId:\"2\", host:\"tc-3\", severity:\"INFO\", timestamp:\"18.06.2015 14:13:25.023\"}\n").getBytes());
			}
			for (; i < 8000000; i++) {
				fos.write(("{requestId:\""+ i+1 +"\", processId:\"8\", host:\"tc-4\", severity:\"ERROR\", timestamp:\"19.06.2015 14:13:25.023\"}\n").getBytes());
			}
			for (; i < 10000000; i++) {
				fos.write(("{requestId:\""+ i+1 +"\", processId:\"1\", host:\"tc-5\", severity:\"ERROR\", timestamp:\"21.06.2015 14:13:25.023\"}\n").getBytes());
			}
			for (; i < 12000000; i++) {
				fos.write(("{requestId:\""+ i+1 +"\", processId:\"6\", host:\"tc-6\", severity:\"ERROR\", timestamp:\"22.06.2015 14:13:25.023\"}\n").getBytes());
			}
			fos.write(("{requestId:\""+ i++ +"\", processId:\"2\", host:\"tc-8\", severity:\"WARN\", timestamp:\"16.06.2015 14:13:25.023\"}\n").getBytes());
			fos.write(("{requestId:\""+ i++ +"\", processId:\"2\", host:\"tc-7\", severity:\"WARN\", timestamp:\"17.06.2015 14:13:25.023\"}\n").getBytes());
			fos.write(("{requestId:\""+ i++ +"\", processId:\"2\", host:\"tc-6\", severity:\"INFO\", timestamp:\"15.06.2015 14:13:25.023\"}\n").getBytes());
		}catch (Exception e) {
			System.out.println("ERROR OCCURED!!!");
			e.printStackTrace();
		}
		
		aggregator = new Aggregator();
		aggregator.aggregate(path);
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		try(FileOutputStream fos = new FileOutputStream(path)) {
			//just to clean the file
		}catch (Exception e) {
			System.out.println("ERROR OCCURED!!!");
			e.printStackTrace();
		}
	}
	
	@Test
	public void shouldFindCorrectValuesForLongestProcess() {
		assertEquals(2, aggregator.getLongestProcessId());
	}
	
	@Test
	public void shouldFindCorrectValuesForLongestDuration() {
		assertEquals(259200000, aggregator.getLongestDuration());
	}
	
	@Test
	public void shouldFindCorrectValuesForMaxSeverityForProcess2() {
		assertEquals(ProcessSeverity.WARN, aggregator.getMaxSeverityMap().get(2));
	}
	
	@Test
	public void shouldFindCorrectValuesForNumberOfHostsForProcess2() {
		assertEquals(2000003, aggregator.getProcessHostsMap().get(2).size());
	}
}
