package test.cpu;

/**
 * User: jgerard
 * Date: 3/8/13
 * Time: 12:55 AM
 */
public class FloatToIntBitsBenchmark extends FloatBenchmark
{
    @Override
    public void execute(int repetitions) {
        int result = 123;
        for (int rep = 0; rep < repetitions; ++rep) {
            result = Float.floatToIntBits(f);
        }
        if (result != i) {
            throw new RuntimeException(Integer.toString(result));
        }
    }
}
