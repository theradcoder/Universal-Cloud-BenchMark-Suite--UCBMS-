package test.cpu;

import framework.Benchmark;
import framework.BenchmarkServlet;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class FloatServlet extends BenchmarkServlet
{
    @Override
    protected <T extends Benchmark> List<T> getBenchmarks()
    {
        List<T> list = new ArrayList<T>();
        list.add((T) new FloatToIntBitsBenchmark());
        list.add((T) new FloatToRawIntBitsBenchmark());
        list.add((T) new IntBitsToFloatBenchmark());
        return list;
    }
}