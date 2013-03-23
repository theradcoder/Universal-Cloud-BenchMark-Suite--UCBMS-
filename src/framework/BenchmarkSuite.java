package framework;

import java.io.PrintWriter;
import java.util.List;

/**
 * User: jgerard
 * Date: 3/14/13
 * Time: 10:24 PM
 */
public abstract class BenchmarkSuite
{
    private final PrintWriter writer;

    public BenchmarkSuite(PrintWriter writer)
    {
        this.writer = writer;
    }

    protected boolean getWarmUp()
    {
        return true;
    }

    protected long getRepetitions()
    {
        return 1000;
    }

    protected abstract List<Benchmark> getBenchmarks();

    protected PrintWriter getWriter()
    {
        return writer;
    }
}