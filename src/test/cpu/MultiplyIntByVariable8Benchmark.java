package test.cpu;

import framework.Benchmark;

public class MultiplyIntByVariable8Benchmark implements Benchmark
{
    @Override
    public void execute(long repetitions)
    {
        int result = 1;
        int factor = 8;
        for (int i = 0; i < repetitions; ++i)
        {
            result *= factor;
        }

        if (result < 0) // this is just hear to make sure the JIT doesn't optimize out this method
            throw new RuntimeException("Never Reached");
    }
}
