package framework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

/**
 * User: jgerard
 * Date: 3/7/13
 * Time: 11:29 PM
 */
public abstract class BenchmarkServlet extends HttpServlet
{
    protected long getRepetitions()
    {
        return 1;
    }

    protected boolean getWarmUp()
    {
        return true;
    }

    protected abstract <T extends Benchmark> List<T> getBenchmarks();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        resp.setContentType("text/plain");

        Runner r = new Runner(getWarmUp());
        try
        {
            DecimalFormat formatter = new DecimalFormat("#,##0");
            for (Benchmark b : getBenchmarks())
            {
                String name = b.getClass().getSimpleName();

                double totalTime = r.run(b, getRepetitions());

                PrintWriter pw = resp.getWriter();

                pw.println("Benchmark: " + name);
                pw.println("Repetitions: " + getRepetitions());
                pw.println("Elapsed Time (ns): " + formatter.format(totalTime));
                pw.println("Elapsed Time (ms): " + (totalTime / 1000000));
                pw.println();
            }
//            Benchmark b = (Benchmark)((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
//            r.run(b, getRepetitions());
        } catch (Exception e)
        {
            resp.getWriter().print(e.toString());
            resp.getWriter().flush();
        }
    }
}