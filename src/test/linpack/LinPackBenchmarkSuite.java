package test.linpack;

import framework.Benchmark;
import framework.BenchmarkSuite;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class LinPackBenchmarkSuite extends BenchmarkSuite
{
    public LinPackBenchmarkSuite(PrintWriter writer)
    {
        super(writer);
    }

    @Override
    protected List<Benchmark> getBenchmarks()
    {
        ArrayList<Benchmark> list = new ArrayList<Benchmark>();
        list.add(new LinpackBenchmarck(getWriter()));
        return list;
    }
}