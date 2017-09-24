package de.ax.log.aggregation.util;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import de.ax.log.aggregation.model.LogEntry;
import de.ax.log.aggregation.model.ProcessSeverity;

/**
 * Utility class to parse the {@code LogEntiry} objects from Json file
 * 
 * @author Serhan
 *
 */
public class LogEntryDeserializer implements JsonDeserializer<LogEntry> {

	/** Custom deserialize method to convert Json string 
	 * representation of the {@code LogEntiry} objects in 
	 * the desired way.
	 * 
	 * @param json The Json data being deserialized
	 * @param type  The type of the Object to deserialize to
	 * @param context Context for deserialization
	 * 
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 * */
	public LogEntry deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException{

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");
		
		JsonObject jsonObject = json.getAsJsonObject();
		
		LogEntry logEntry = new LogEntry();
		try {
			logEntry.setRequestId(jsonObject.get("requestId").getAsInt());
			logEntry.setProcessId(jsonObject.get("processId").getAsInt());
			logEntry.setHost(jsonObject.get("host").getAsString());
			logEntry.setSeverity(ProcessSeverity.valueOf(jsonObject.get("severity").getAsString()));
			logEntry.setTimestamp(LocalDateTime.parse(jsonObject.get("timestamp").getAsString(), formatter));
		}catch(DateTimeParseException | NullPointerException ex) {
			System.out.println("An exception was occured while parsing the json object!");
			throw new JsonParseException(ex);
		}
		return logEntry;
	}

}
