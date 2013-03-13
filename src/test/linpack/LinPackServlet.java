package test.linpack;

import framework.Benchmark;
import framework.BenchmarkServlet;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class LinPackServlet extends BenchmarkServlet
{
    @Override
    protected <T extends Benchmark> List<T> getBenchmarks()
    {
        ArrayList<T> list = new ArrayList<T>();
        list.add((T) new LinpackBenchmarck(writer));
        return list;
    }
}