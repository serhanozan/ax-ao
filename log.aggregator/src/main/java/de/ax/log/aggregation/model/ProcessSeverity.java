package de.ax.log.aggregation.model;

/**
 * The {@code ProcessSeverity} enum is used to 
 * represent the severity of the process states 
 * in the log entries. It simplifies assessing 
 * the priority of the process state such that
 * {@code INFO < WARN < ERROR}
 * 
 * @author Serhan
 *
 */
public enum ProcessSeverity {
	/** The process state with lowest priority, 
	 *  used just to inform the user
	 *  This has the numeric value of {@code 1} */
	INFO(1),
	/** The process state with middle priority,
	 *  used to warn the user
	 *  This has the numeric value of {@code 2} */
	WARN(2),
	/** The process state with highest priority,
	 *  used to tell the user that something went wrong
	 *  This has the numeric value of {@code 3} */
	ERROR(3);
	
	/**
	 * Private parameterized constructor for the {@code ProcessSeverity} enum
	 */
	private ProcessSeverity(int severityLevel) {
		this.severityLevel = severityLevel;
	}

	/**Represents the priority of the process severity
	 * Higher severity level means higher priority*/
	private int severityLevel;
	
	
	/**
	 * @return the {@link #severityLevel severityLevel}
	 */
	public int severityLevel() {
		return severityLevel;
	}
}
