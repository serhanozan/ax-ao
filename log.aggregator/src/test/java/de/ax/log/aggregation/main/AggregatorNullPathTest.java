package de.ax.log.aggregation.main;

import org.junit.Before;
import org.junit.Test;

public class AggregatorNullPathTest {
	private String path;
	private Aggregator aggregator;
	
	@Before
	public void setupBeforeTest() {
	    path = null;
		aggregator = new Aggregator();
	}
	
	@Test
	public void shouldNotThrowExceptions() {
		aggregator.aggregate(path);
	}
}
