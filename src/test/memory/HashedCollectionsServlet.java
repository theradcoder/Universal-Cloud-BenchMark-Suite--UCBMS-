package test.memory;

import framework.Benchmark;
import framework.BenchmarkServlet;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class HashedCollectionsServlet extends BenchmarkServlet
{
    @Override
    protected long getRepetitions()
    {
        return 1000000;
    }

    @Override
    protected <T extends Benchmark> List<T> getBenchmarks()
    {
        ArrayList<T> list = new ArrayList<T>();
        list.add((T) new HashMapGetBenchmark());
        list.add((T) new HashMapGetSynchronizedBenchmark());
        list.add((T) new LinkedHashMapGetBenchmark());
        list.add((T) new HashtableGetBenchmark());
        list.add((T) new ConcurrentHashMapGetBenchmark());
        return list;
    }
}