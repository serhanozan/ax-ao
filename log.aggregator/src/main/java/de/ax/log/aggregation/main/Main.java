package de.ax.log.aggregation.main;

import java.io.IOException;

/**
 * Test driver for the application 
 * */
public class Main {

	/**
	 * By default, if the project is run directly as a Java application, 
	 * this method is called. The main method gets the path to the test 
	 * file named audatex-input.log which is located in src/main/resources
	 * folder and passes it to Aggregator::aggregate method to run a sample 
	 * report.
	 * 
	 * @param args command line arguments, which are not used inside the method 
	 * */
	public static void main(String[] args) throws IOException {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	    String path = classLoader.getResource("audatex-input.data").getPath();
		Aggregator aggregator = new Aggregator();
		aggregator.aggregate(path);
				
	}
}
