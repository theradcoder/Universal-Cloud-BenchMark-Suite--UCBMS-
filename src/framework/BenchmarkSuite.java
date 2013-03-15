package framework;

import java.util.List;

/**
 * User: jgerard
 * Date: 3/14/13
 * Time: 10:24 PM
 */
public abstract class BenchmarkSuite
{
    protected boolean getWarmUp()
    {
        return true;
    }

    protected long getRepetitions()
    {
        return 1000;
    }

    protected abstract List<Benchmark> getBenchmarks();
}