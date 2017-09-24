package de.ax.log.aggregation.main;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the {@code Aggregator} class
 * This test case is aimed to confirm that the
 * program can handle an empty input file 
 * without throwing exceptions
 * 
 * @author Serhan
 *
 */
public class AggregatorEmptyFileTest {

	private String path;
	private Aggregator aggregator;
	
	@Before
	public void setupBeforeTest() {
	    path = getClass().getClassLoader().getResource("empty-log-file.data").getPath();
		aggregator = new Aggregator();
	}
	
	@Test
	public void shouldNotThrowExceptions() {
		aggregator.aggregate(path);
	}
}
