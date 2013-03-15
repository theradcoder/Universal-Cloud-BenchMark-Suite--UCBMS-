package test.cpu;

import framework.Benchmark;
import framework.BenchmarkSuite;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MultiplicationBenchmarkSuite extends BenchmarkSuite
{
    @Override
    protected long getRepetitions()
    {
        return 100 * 1000 * 1000;
    }

    @Override
    protected List<Benchmark> getBenchmarks()
    {
        List<Benchmark> list = new ArrayList<Benchmark>();
        list.add(new MultiplyIntByConstant8Benchmark());
        list.add(new MultiplyIntByConstant10Benchmark());
        list.add(new MultiplyIntByVariable8Benchmark());
        list.add(new MultiplyIntByVariable10Benchmark());
        return list;
    }
}