package test.cpu;

import framework.Benchmark;
import framework.BenchmarkServlet;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MultiplicationServlet extends BenchmarkServlet
{
    @Override
    protected long getRepetitions()
    {
        return 100 * 1000 * 1000;
    }

    @Override
    protected <T extends Benchmark> List<T> getBenchmarks()
    {
        List<T> list = new ArrayList<T>();
        list.add((T) new MultiplyIntByConstant8Benchmark());
        list.add((T) new MultiplyIntByConstant10Benchmark());
        list.add((T) new MultiplyIntByVariable8Benchmark());
        list.add((T) new MultiplyIntByVariable10Benchmark());
        return list;
    }
}