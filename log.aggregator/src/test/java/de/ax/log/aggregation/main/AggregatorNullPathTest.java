package de.ax.log.aggregation.main;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the {@code Aggregator} class
 * This test case is aimed to confirm that the
 * program can handle a null path to input file 
 * without throwing exceptions but printing what 
 * went wrong to console
 * 
 * @author Serhan
 *
 */
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
