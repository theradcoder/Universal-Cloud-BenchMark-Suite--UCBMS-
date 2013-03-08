package test.memory;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import framework.Runner;


@SuppressWarnings("serial")
public class HashedCollectionsServlet extends HttpServlet {
	int repetitions = 10;
	Boolean runWarmup = true;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		HashedCollectionsBenchmark benchmark = new HashedCollectionsBenchmark();
		try{
//			Runner.execute(benchmark, repetitions, resp.getWriter(), runWarmup);
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());
		}
	}
}
