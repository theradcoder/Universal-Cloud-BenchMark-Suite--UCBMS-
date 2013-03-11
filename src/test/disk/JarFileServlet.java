package test.disk;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@SuppressWarnings("serial")
public class JarFileServlet extends HttpServlet
{
    int repetitions = 10;
    Boolean runWarmup = true;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        resp.setContentType("text/plain");
        JarFileBenchmark benchmark = new JarFileBenchmark();
        try
        {
            //Runner.execute(benchmark, repetitions, resp.getWriter(), runWarmup);
        } catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }
}
