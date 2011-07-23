
package framework;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.ImmutableMap;


/**
 * Creates, executes and reports benchmark runs.
 */
public final class Runner {
	  private static final Class<?>[] ARGUMENT_TYPES = { int.class }; //each benchmark method must accept one int parameter: the number of repetitions to execute
	  private static final long warmUpDuration = 1000000000; //warmup for one second before timing each benchmark
	
	//Get all timeX() methods in benchmarkClass  
	private static Map<String, Method> createTimedMethods(Class benchmarkClass) throws Exception {
	    ImmutableMap.Builder<String, Method> result = ImmutableMap.builder();
	    for (Method method : benchmarkClass.getDeclaredMethods()) {
	      int modifiers = method.getModifiers();
	      if (!method.getName().startsWith("time")) {
	        continue;
	      }

	      if (!Modifier.isPublic(modifiers)
	          || Modifier.isStatic(modifiers)
	          || Modifier.isAbstract(modifiers)
	          || !Arrays.equals(method.getParameterTypes(), ARGUMENT_TYPES)) {
	        throw new Exception("Timed methods must be public, "
	            + "non-static, non-abstract and take a single int parameter. "
	            + "But " + method + " violates these requirements.");
	      }

	      result.put(method.getName().substring(4), method);
	    }

	    return result.build();
	  }	
	
	//execute method for warmUpDuration (1 second) before timing
	private static void warmUp(Method method, SimpleBenchmark suite) throws Exception {
		long timeToEndWarmup = System.nanoTime() + warmUpDuration;
		while (System.nanoTime() < timeToEndWarmup) {
			method.invoke(suite, 1);
		}
	}
	
	//time all timeX() methods in the test suite
	public static void execute(SimpleBenchmark suite, int reps, PrintWriter output, Boolean runWarmup) throws Exception {
		//Format display of nanoseconds output
		NumberFormat formatter = new DecimalFormat("#,##0");
		
		
	  //Get all timeX() methods in the benchmark class
	  Map<String, Method> methods = createTimedMethods(suite.getClass());
	  output.println("Benchmark class: '" + suite.getClass()+ "'");
	  output.println("Repetitions: " + reps);
	  output.println();
	  
	  //Time the execution of each timeX() method, passing it the number of repetitions
	  for(String methodName : methods.keySet()){
		  output.println("Method: '" + methodName + "'");
		  final Method method = methods.get(methodName);		  
		  suite.setUp();
		  
		  //Run the method for at least 1 second before timing, to be sure the JVM has 'warmed up'
		  if(runWarmup){
			  warmUp(method, suite);
		  }
		  
		  double startTime = System.nanoTime();		  
		  method.invoke(suite, reps);
		  double endTime = System.nanoTime();
		  suite.tearDown();
		  output.println(formatter.format(endTime - startTime));
		  output.println();
	  }	  
	  
  }
}
