package de.ax.log.aggregation.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.ax.log.aggregation.model.ProcessSeverity;

public class AggregatorSmallLogFileTest {

	private String path;
	private Aggregator aggregator;
	
	@Before
	public void setupBeforeTest() {
	    path = getClass().getClassLoader().getResource("small-log-file.data").getPath();
		aggregator = new Aggregator();
	}
	
	@Test
	public void shouldFindCorrectValuesForLongestProcess() {
		aggregator.aggregate(path);
		
		assertEquals(2, aggregator.getLongestProcessId());
	}
	
	@Test
	public void shouldFindCorrectValuesForLongestDuration() {
		aggregator.aggregate(path);
		
		assertEquals(345600000, aggregator.getLongestDuration());
	}
	
	@Test
	public void shouldFindCorrectValuesForMaxSeverityForProcess4() {
		aggregator.aggregate(path);
		
		assertEquals(ProcessSeverity.INFO, aggregator.getMaxSeverityMap().get(4));
	}
	
	@Test
	public void shouldFindCorrectValuesForNumberOfHostsForProcess2() {
		aggregator.aggregate(path);
		
		assertEquals(2, aggregator.getProcessHostsMap().get(2).size());
	}
}
