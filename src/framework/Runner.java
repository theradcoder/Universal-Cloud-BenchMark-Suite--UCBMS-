package framework;


public final class Runner
{
    private final boolean warmUp;

    public Runner()
    {
        this(true);
    }

    public Runner(boolean warmUp)
    {
        this.warmUp = warmUp;
    }

    private static final long warmUpDuration = 1000000000; //warmup for one second before timing each benchmark

    public double run(Benchmark benchmark, long repetitions) throws Exception
    {
        if (warmUp)
            benchmark.execute(repetitions); // disregard results

        double startTime = System.nanoTime();

        benchmark.execute(repetitions);

        return System.nanoTime() - startTime;
    }
}