/**
 * 
 */
package de.ax.log.aggregation.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class to test whether the severity levels 
 * of the {@code ProcessSeverity} enum comply 
 * to the requirement {@code INFO < WARN < ERROR}
 * 
 * @author Serhan
 *
 */
public class ProcessSeverityTest {

	@Test
	public void infoShouldLessThanWarn() {
		assertTrue(ProcessSeverity.INFO.compareTo(ProcessSeverity.WARN) < 0);
	}
	
	@Test
	public void infoShouldLessThanError() {
		assertTrue(ProcessSeverity.INFO.compareTo(ProcessSeverity.ERROR) < 0);
	}
	
	@Test
	public void warnShouldLessThanError() {
		assertTrue(ProcessSeverity.WARN.compareTo(ProcessSeverity.ERROR) < 0);
	}
}
