package test.network;

import framework.Benchmark;
import framework.BenchmarkSuite;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class UrlConnectionBenchmarkSuite extends BenchmarkSuite
{
    public UrlConnectionBenchmarkSuite(PrintWriter writer)
    {
        super(writer);
    }

    protected long getRepetitions()
    {
        return 10;
    }

    @Override
    protected List<Benchmark> getBenchmarks()
    {
        ArrayList<Benchmark> list = new ArrayList<Benchmark>();
        list.add(new UrlConnectionBenchmark());
        return list;
    }
}