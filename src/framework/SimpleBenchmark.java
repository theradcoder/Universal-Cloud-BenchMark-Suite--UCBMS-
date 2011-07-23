package framework;


/**
 * A convenience class for implementing benchmarks in plain code.
 * Implementing classes must have a no-arguments constructor.
 * Loosely based on Google Caliper's class of the same name.
 *
 *
 */
public abstract class SimpleBenchmark {

	public void setUp() throws Exception {}
	public void tearDown() throws Exception {}
	
}