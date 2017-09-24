package de.ax.log.aggregation.main;

import org.junit.Before;
import org.junit.Test;

public class AggregatorCorruptFileTest {

	private String path;
	private Aggregator aggregator;
	
	@Before
	public void setupBeforeTest() {
	    path = getClass().getClassLoader().getResource("corrupt-log-file.log").getPath();
		aggregator = new Aggregator();
	}
	
	@Test
	public void shouldNotThrowExceptions() {
		aggregator.aggregate(path);
	}
}
