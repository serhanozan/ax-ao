package de.ax.log.aggregation.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The {@code LogEntry} class represents the structure of  
 * individual lines of the log files. Each line is formatted 
 * according to the structure of this class.
 * 
 * @author Serhan
 *
 */
public class LogEntry {

	/** The process step execution ID, 
	 * globally unique for every log entry. */
	private Integer requestId;
	
	/** The process ID that given step participated in, 
	 * shared among entries participating in the same process. */
	private Integer processId;
	
	/** The host name executing the step*/
	private String host;
	
	/** The severity of this process
	 *  {@link de.ax.log.aggregation.model.ProcessSeverity process severity} */
	private ProcessSeverity severity;
	
	/** The default constructor of the {@code LogEntry} class*/
	public LogEntry() {
		
	}
	
	/** Step execution timestamp in format dd.MM.yyyy HH:mm:ss:SSS*/
	private LocalDateTime timestamp;
	
	/**
	 * The parameterized constructor of the {@code LogEntry} class
	 * @param requestId {@link #requestId requestId}
	 * @param processId {@link #processId processId}
	 * @param host 		{@link #host host}
	 * @param severity 	{@link #severity severity}
	 * @param timestamp {@link #timestamp timestamp}
	 */
	public LogEntry(Integer requestId, Integer processId, String host, ProcessSeverity severity,
			LocalDateTime timestamp) {
		this.requestId = requestId;
		this.processId = processId;
		this.host = host;
		this.severity = severity;
		this.timestamp = timestamp;
	}

	/**
	 * @return the {@code requestId} 
	 */
	public Integer getRequestId() {
		return requestId;
	}
	/**
	 * @param requestId the {@link #requestId requestId} to set
	 *  
	 */
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	/**
	 * @return the {@link #processId processId}
	 */
	public Integer getProcessId() {
		return processId;
	}
	/**
	 * @param processId the {@code processId} to set
	 */
	public void setProcessId(Integer processId) {
		this.processId = processId;
	}
	/**
	 * @return the {@link #host host}
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the {@code host } to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the {@link #severity severity}
	 */
	public ProcessSeverity getSeverity() {
		return severity;
	}
	/**
	 * @param severity the {@code severity } to set
	 */
	public void setSeverity(ProcessSeverity severity) {
		this.severity = severity;
	}
	/**
	 * @return the {@link #timestamp timestamp}
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the {@code timestamp } to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/** Returns a hash code value for the object. */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((severity == null) ? 0 : severity.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		return result;
	}

	/**Indicates whether some other object is "equal to" this one. */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (severity != other.severity)
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	/** Returns a string representation of the {@code LogEntry} instance*/
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");
		return "Log Entity : {" + 	
				" requestId : " + requestId + 
				" processId : " + processId + 
				" host : " 		+ host 		+
				" severity : " 	+ severity  +
				" timestamp : " + formatter.format(timestamp)	+
				"}";
	}

}
