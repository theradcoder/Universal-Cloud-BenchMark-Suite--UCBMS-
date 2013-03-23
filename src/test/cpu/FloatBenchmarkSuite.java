package test.cpu;

import framework.Benchmark;
import framework.BenchmarkSuite;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * User: jgerard
 * Date: 3/14/13
 * Time: 10:30 PM
 */
public class FloatBenchmarkSuite extends BenchmarkSuite
{
    public FloatBenchmarkSuite(PrintWriter writer)
    {
        super(writer);
    }

    @Override
    public long getRepetitions()
    {
        return 1000000;
    }

    @Override
    public List<Benchmark> getBenchmarks()
    {
        List<Benchmark> list = new ArrayList<Benchmark>();
        list.add(new FloatToIntBitsBenchmark());
        list.add(new FloatToRawIntBitsBenchmark());
        list.add(new IntBitsToFloatBenchmark());
        return list;
    }
}
