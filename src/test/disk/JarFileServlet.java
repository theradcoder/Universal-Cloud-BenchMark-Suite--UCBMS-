package test.disk;

import framework.Benchmark;
import framework.BenchmarkServlet;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class JarFileServlet extends BenchmarkServlet
{

    protected long getRepetitions()
    {
        return 1000;
    }

    @Override
    protected <T extends Benchmark> List<T> getBenchmarks()
    {
        ArrayList<T> list = new ArrayList<T>();
        list.add((T) new JarFileBenchmark());
        return list;
    }
}