package test.network;

import framework.Benchmark;
import framework.BenchmarkServlet;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class UrlConnectionServlet extends BenchmarkServlet
{
    protected long getRepetitions()
    {
        return 10;
    }

    @Override
    protected <T extends Benchmark> List<T> getBenchmarks()
    {
        ArrayList<T> list = new ArrayList<T>();
        list.add((T) new UrlConnectionBenchmark());
        return list;
    }
}