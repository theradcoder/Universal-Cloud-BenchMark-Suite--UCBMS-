package test.memory;

import framework.Benchmark;
import framework.BenchmarkSuite;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class HashedCollectionsBenchmarkSuite extends BenchmarkSuite
{
    public HashedCollectionsBenchmarkSuite(PrintWriter writer)
    {
        super(writer);
    }

    @Override
    protected long getRepetitions()
    {
        return 1000000;
    }

    @Override
    protected List<Benchmark> getBenchmarks()
    {
        ArrayList<Benchmark> list = new ArrayList<Benchmark>();
        list.add(new HashMapGetBenchmark());
        list.add(new HashMapGetSynchronizedBenchmark());
        list.add(new LinkedHashMapGetBenchmark());
        list.add(new HashtableGetBenchmark());
        list.add(new ConcurrentHashMapGetBenchmark());
        return list;
    }
}