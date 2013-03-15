package framework;

import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * User: jgerard
 * Date: 3/14/13
 * Time: 10:21 PM
 */
public class ResultPackager
{
    private final PrintWriter writer;
    private final BenchmarkSuite suite;
    private final int runs;
    private final Runner runner;

    public ResultPackager(PrintWriter writer, BenchmarkSuite suite, int runs, Runner runner)
    {
        this.writer = writer;
        this.suite = suite;
        this.runs = runs;
        this.runner = runner;
    }

    public void runAndPackage() throws Exception
    {
        double[] runResults = new double[runs];

        DecimalFormat formatter = new DecimalFormat("#,##0");
        for (Benchmark b : suite.getBenchmarks())
        {
            double min = 0;
            double max = 0;
            double average = 0;

            for(int i = 0; i<runs; i++)
            {
                double totalTime = runner.run(b, suite.getRepetitions());
                runResults[i] = totalTime;

                average += totalTime;

                if(i == 0)
                    min = totalTime;

                if(totalTime < min)
                    min = totalTime;

                if(totalTime > max)
                    max = totalTime;
            }

            average /= 10;

            String name = b.getClass().getSimpleName();

            writer.println("Benchmark: " + name);
            writer.println("Runs: " + this.runs);
            writer.println("Repetitions / runs: " + suite.getRepetitions());
            writer.println("Average Elapsed Time (ns): " + formatter.format(average));
            writer.println("Average Elapsed Time (ms): " + (average / 1000000));
            writer.println("Max Elapsed Time (ns): " + formatter.format(max));
            writer.println("Max Elapsed Time (ms): " + (max / 1000000));
            writer.println("Min Elapsed Time (ns): " + formatter.format(min));
            writer.println("Min Elapsed Time (ms): " + (min / 1000000));
            writer.println();
        }
    }
}
