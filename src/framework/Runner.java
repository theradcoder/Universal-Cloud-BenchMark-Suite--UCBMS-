package framework;

import java.io.OutputStream;

public final class Runner
{
    private final boolean warmUp;
    private final OutputStream output;

    public Runner(boolean warmUp, OutputStream output)
    {
        this.warmUp = warmUp;
        this.output = output;
    }

    private static final long warmUpDuration = 1000000000; //warmup for one second before timing each benchmark

    public double run(Benchmark benchmark, int repetitions)
    {
//        benchmark.setUp();

        if(warmUp)
            warmUp(benchmark);

        double startTime = System.nanoTime();

        benchmark.execute(repetitions);

        double endTime = System.nanoTime();

//        benchmark.tearDown();

        return endTime - startTime;
    }

    // Not sure of the value of this method implementation
    private void warmUp(Benchmark benchmark)
    {
        long timeToEndWarmup = System.nanoTime() + warmUpDuration;
        while (System.nanoTime() < timeToEndWarmup) {
            benchmark.execute(1);
        }
    }
}