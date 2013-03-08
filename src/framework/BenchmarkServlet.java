package framework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * User: jgerard
 * Date: 3/7/13
 * Time: 11:29 PM
 */
public abstract class BenchmarkServlet extends HttpServlet
{
    protected int getRepetitions()
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

        Runner r = new Runner(getWarmUp(), resp.getOutputStream());
        try
        {
            for(Benchmark b : getBenchmarks())
            {
                r.run(b, getRepetitions());
            }
//            Benchmark b = (Benchmark)((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
//            r.run(b, getRepetitions());
        }
        catch(Exception e)
        {
            resp.getWriter().print(e.toString());
            resp.getWriter().flush();
        }
    }
}