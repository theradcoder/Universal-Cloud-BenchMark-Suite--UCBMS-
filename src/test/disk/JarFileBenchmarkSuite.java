package test.disk;

import framework.Benchmark;
import framework.BenchmarkServlet;
import framework.BenchmarkSuite;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class JarFileBenchmarkSuite extends BenchmarkSuite
{
    public JarFileBenchmarkSuite(PrintWriter writer)
    {
        super(writer);
    }

    @Override
    protected long getRepetitions()
    {
        return 1000;
    }

    @Override
    protected List<Benchmark> getBenchmarks()
    {
        ArrayList<Benchmark> list = new ArrayList<Benchmark>();
        list.add(new JarFileBenchmark());
        return list;
    }
}