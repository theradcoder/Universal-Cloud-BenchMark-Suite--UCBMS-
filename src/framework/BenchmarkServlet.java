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
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.write("<html><head><title>");

        String suiteToRun = req.getParameter("suite");

        writer.write(suiteToRun);

        writer.write("</title></head><body><h1>");

        writer.write(suiteToRun);

        writer.write("</h1><pre>");

        suiteToRun = suiteToRun.trim().toUpperCase();

        BenchmarkSuite suite = null;

        if(suiteToRun.equals("FLOAT"))
            suite = new FloatBenchmarkSuite(writer);
        else if(suiteToRun.equals("MULTIPLICATION"))
            suite = new MultiplicationBenchmarkSuite(writer);
        else if(suiteToRun.equals("JARFILE"))
            suite = new JarFileBenchmarkSuite(writer);
        else if(suiteToRun.equals("URLCONNECTION"))
            suite = new UrlConnectionBenchmarkSuite(writer);
        else if(suiteToRun.equals("LINPACK"))
            suite = new LinPackBenchmarkSuite(writer);
        else if(suiteToRun.equals("HASHEDCOLLECTION"))
            suite = new HashedCollectionsBenchmarkSuite(writer);

        else
            writer.println("invalid suite: " + suiteToRun);

        try
        {
            ResultPackager packager = new ResultPackager(writer, 10, new Runner());

            packager.runAndPackage(suite);
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

        writer.write("</pre><hr/><a href='/'>Return to menu</a></body></html>");
        writer.flush();

    }
}