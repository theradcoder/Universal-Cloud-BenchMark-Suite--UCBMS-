package test.cpu;

import framework.Benchmark;

public class MultiplyIntByConstant8Benchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        int result = 1;
        for (int i = 0; i < repetitions; ++i)
        {
            result *= 8;
        }

        if (result < 0) // this is just hear to make sure the JIT doesn't optimize out this method
            throw new RuntimeException("Never Reached");
    }
}
