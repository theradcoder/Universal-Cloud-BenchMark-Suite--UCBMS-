package test.cpu;

/**
 * User: jgerard
 * Date: 3/8/13
 * Time: 12:55 AM
 */
public class FloatToRawIntBitsBenchmark extends FloatBenchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        int result = 123;
        for (int rep = 0; rep < repetitions; ++rep)
        {
            result = Float.floatToRawIntBits(FloatTestValue);
        }
        if (result != IntTestValue)
        {
            throw new RuntimeException(Integer.toString(result));
        }
    }
}
