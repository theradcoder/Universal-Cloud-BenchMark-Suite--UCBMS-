package framework;

import test.cpu.FloatBenchmarkSuite;
import test.cpu.MultiplicationBenchmarkSuite;
import test.disk.JarFileBenchmarkSuite;
import test.linpack.LinPackBenchmarkSuite;
import test.memory.HashedCollectionsBenchmarkSuite;
import test.network.UrlConnectionBenchmarkSuite;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * User: jgerard
 * Date: 3/7/13
 * Time: 11:29 PM
 */
public class BenchmarkServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/plain");
        PrintWriter writer = resp.getWriter();

        String suiteToRun = req.getParameter("suite");

        suiteToRun = suiteToRun.trim().toUpperCase();

        BenchmarkSuite suite = null;

        if(suiteToRun.equals("FLOAT"))
            suite = new FloatBenchmarkSuite();
        else if(suiteToRun.equals("MULTIPLICATION"))
            suite = new MultiplicationBenchmarkSuite();
        else if(suiteToRun.equals("JARFILE"))
            suite = new JarFileBenchmarkSuite();
        else if(suiteToRun.equals("URLCONNECTION"))
            suite = new UrlConnectionBenchmarkSuite();
        else if(suiteToRun.equals("LINPACK"))
            suite = new LinPackBenchmarkSuite();
        else if(suiteToRun.equals("HASHEDCOLLECTION"))
            suite = new HashedCollectionsBenchmarkSuite();



        else
            writer.println("invalid suite: " + suiteToRun);

        try
        {
            ResultPackager packager = new ResultPackager(writer, suite, 10, new Runner());

            packager.runAndPackage();
        }
        catch(Exception e)
        {
            writer.println(e.getMessage());
            for(StackTraceElement ste : e.getStackTrace())
            {
                writer.println(ste.toString());
            }
            writer.flush();
        }
    }
}