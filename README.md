<br><br>
<strong>Log Aggregation</strong>
<br><br>
The distributed system X consists of many applications located on many physical servers (cluster). Every client request triggers business process with many steps, which may run on different hosts. Every host, after execution of every process steps produces the following output:<br><br>
{<br>
	requestId : “”,<br>
	processId : “”,<br>
	host : “”,<br>
	severity : “”<br>
timestamp : “”<br>
}<br><br>
Where:<br>
•	requestId – (string) the process step execution ID, globally unique for every log entry<br>
•	processId – (string) the processId that given step participated in, shared among entries participating in the same process<br>
•	host – (string) the host name executing the step<br>
•	severity – (string) can have 3 possible values: INFO, WARN and ERROR, where INFO < WARN < ERROR<br>
•	timestamp – (string) step execution timestamp in format dd.MM.yyyy HH:mm:ss.SSS (for example: 12.09.2015 17:48:21.921)<br><br>
So that<br>
•	Every process can have one or more steps (the log entries will share same processId in this case)<br>
•	Some long-running processes can span many days<br>
•	Log entries are unsorted/unordered in the input file (it can happen that process final step comes before the process start step in the log file)<br><br>
<strong>Input</strong><br>
Your program will receive single parameter - path to the input log file. The file will have log entries (one entry per line). <br><br>
<strong>Input file</strong><br>
{requestId:”12345”, processId:”7”, host:”tc-1”, severity:”INFO”, timestamp:”17.06.2015 14:13:25.023”}<br>
{requestId:”12346”, processId:”4”, host:”tc-5”, severity:”INFO”, timestamp:”17.06.2015 14:13:25.023”}<br>
{requestId:”12347”, processId:”2”, host:”tc-3”, severity:”WARN”, timestamp:”18.06.2015 14:13:25.023”}<br>
{requestId:”12348”, processId:”8”, host:”tc-3”, severity:”ERROR”, timestamp:”19.06.2015 14:13:25.023”}<br>
…<br>
{requestId:”12355”, processId:”1”, host:”tc-5”, severity:”WARN”, timestamp:”18.06.2015 14:13:25.023”}<br>
{requestId:”12356”, processId:”6”, host:”tc-1”, severity:”INFO”, timestamp:”17.06.2015 14:13:25.023”}<br>
{requestId:”12357”, processId:”2”, host:”tc-1”, severity:”ERROR”, timestamp:”22.06.2015 14:13:25.023”}<br>
<br><br>
<strong>Output</strong><br>
Program should analyze the logs and calculate the following information:<br>
•	Total number of processes executed on the cluster<br>
•	The longest process (the process that took most time, time interval between process start and end steps). If process has just one step (start), consider the process duration is 0<br>
•	For every executed process<br>
	o	Maximum severity value (see the severity field description)<br>
	o	Number of hosts participated<br><br>
The program should produce the output data<br><br>
<strong>Sample output</strong><br><br>
The total number of processes is 6 (1,2,4,6,7,8)<br><br>
The longest process: 2 (5 days)<br><br>
Maximum severity for process 1 : WARN<br>
…<br>
Maximum severity for process 8 : ERROR<br>
<br>
Number of hosts for process 1 : 1  (tc-5)<br>
…<br>
Number of hosts for process 8 : 3  (tc-3, tc-5)<strong>I assume that this is a set, but the total numbers should be counted, too</strong><br><br>
<strong>Additional Requirements</strong><br>
•	The actual test input file may be many gigabytes long; your program will be executed with default java memory settings and can’t fail with OutOfMemoryError<br>
•	Project must be configured with Maven<br>
•	Program must have unit tests<br>
•	Public methods and classes must have Javadoc<br>
•	It is allowed to use any opensource libraries<br>

