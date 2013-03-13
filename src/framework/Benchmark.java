package framework;

import java.io.IOException;

/**
 * User: jgerard
 * Date: 3/7/13
 * Time: 9:36 PM
 */
public interface Benchmark
{
    void execute(long repetitions) throws IOException;
}