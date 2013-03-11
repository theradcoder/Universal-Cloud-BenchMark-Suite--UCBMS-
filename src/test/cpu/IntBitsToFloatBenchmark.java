package test.cpu;

/**
 * User: jgerard
 * Date: 3/8/13
 * Time: 12:55 AM
 */
public class IntBitsToFloatBenchmark extends FloatBenchmark
{
    @Override
    public void execute(long repetitions)
    {
        float result = 123.0f;
        for (int rep = 0; rep < repetitions; ++rep)
        {
            result = Float.intBitsToFloat(i);
        }
        if (result != i)
        {
            throw new RuntimeException(Integer.toString(i));
        }
    }
}