/**
 * 
 */
package de.ax.log.aggregation.util;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.ax.log.aggregation.model.LogEntry;
import de.ax.log.aggregation.model.ProcessSeverity;

/**
 * Test class for the {@code LogEntryDeserializer} class
 * 
 * @author Serhan
 *
 */
public class LogEntryDeserializerTest {

	private DateTimeFormatter formatter;
	private String jsonString;
	private Gson gson;
	
	@Before
	public void setupBeforeTest() {
		 formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");
		 jsonString =  "{requestId:\"12345\", processId:\"7\", host:\"tc-1\", severity:\"INFO\", timestamp:\"17.06.2015 14:13:25.023\"}";
		 gson = new GsonBuilder().registerTypeAdapter(LogEntry.class,new LogEntryDeserializer()).create();
	}
	
	@Test
	public void shouldParseLogEntryFromTextCorrectly() {
		
		LogEntry logEntryActual = gson.fromJson(jsonString, LogEntry.class);
		LogEntry logEntryExpected = new LogEntry(12345, 7, "tc-1", ProcessSeverity.INFO, LocalDateTime.parse("17.06.2015 14:13:25.023", formatter)); 
		
		assertTrue(logEntryExpected.equals(logEntryActual));
	}

}
