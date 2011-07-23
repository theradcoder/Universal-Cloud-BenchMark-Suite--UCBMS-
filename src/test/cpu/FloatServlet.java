package test.cpu;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Runner;


@SuppressWarnings("serial")
public class FloatServlet extends HttpServlet {
	int repetitions = 10;
	Boolean runWarmup = true;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		FloatBenchmark benchmark = new FloatBenchmark();
		try{
			Runner.execute(benchmark, repetitions, resp.getWriter(), runWarmup);
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());
		}
	}
}