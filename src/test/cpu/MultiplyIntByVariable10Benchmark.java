package test.cpu;

import framework.Benchmark;

public class MultiplyIntByVariable10Benchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        int result = 1;
        int factor = 10;
        for (int i = 0; i < repetitions; ++i)
        {
            result *= factor;
        }

        if (result < 0) // this is just hear to make sure the JIT doesn't optimize out this method
            throw new RuntimeException("Never Reached");
    }
}
