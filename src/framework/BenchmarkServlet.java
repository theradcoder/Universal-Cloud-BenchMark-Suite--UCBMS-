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
        double[] runs = new double[10];
        try
        {
            DecimalFormat formatter = new DecimalFormat("#,##0");
            for (Benchmark b : getBenchmarks())
            {
                double min = 0;
                double max = 0;
                double average = 0;

                for(int i = 0; i<runs.length; i++)
                {
                    double totalTime = r.run(b, getRepetitions());
                    runs[i] = totalTime;

                    average += totalTime;

                    if(i == 0)
                        min = totalTime;

                    if(totalTime < min)
                        min = totalTime;

                    if(totalTime > max)
                        max = totalTime;
                }

                average /= 10;

                String name = b.getClass().getSimpleName();

                PrintWriter pw = resp.getWriter();

                pw.println("Benchmark: " + name);
                pw.println("Runs: " + runs.length);
                pw.println("Repetitions / runs: " + getRepetitions());
                pw.println("Average Elapsed Time (ns): " + formatter.format(average));
                pw.println("Average Elapsed Time (ms): " + (average / 1000000));
                pw.println("Max Elapsed Time (ns): " + formatter.format(max));
                pw.println("Max Elapsed Time (ms): " + (max / 1000000));
                pw.println("Min Elapsed Time (ns): " + formatter.format(min));
                pw.println("Min Elapsed Time (ms): " + (min / 1000000));
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