package test.network;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Runner;


@SuppressWarnings("serial")
public class UrlConnectionServlet extends HttpServlet {
	int repetitions = 1;
	Boolean runWarmup = false;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		UrlConnectionBenchmark benchmark = new UrlConnectionBenchmark();
		try{
			Runner.execute(benchmark, repetitions, resp.getWriter(), runWarmup);
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());
		}
	}
}
