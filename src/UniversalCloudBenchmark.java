import framework.ResultPackager;
import framework.Runner;
import test.cpu.FloatBenchmarkSuite;
import test.cpu.MultiplicationBenchmarkSuite;
import test.disk.JarFileBenchmarkSuite;
import test.linpack.LinPackBenchmarkSuite;
import test.memory.HashedCollectionsBenchmarkSuite;
import test.network.UrlConnectionBenchmarkSuite;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * User: jgerard
 * Date: 3/14/13
 * Time: 9:07 PM
 */
public class UniversalCloudBenchmark
{
    private static void printMenu()
    {
        PrintWriter out = new PrintWriter(System.out);

        out.println("Universal Cloud Benchmark v1.0");
        out.println();
        out.println("1. Run all benchmarks");
        out.println("2. Run CPU benchmarks");
        out.println("3. Run Disk benchmarks");
        out.println("4. Run Linpack benchmarks");
        out.println("5. Run Memory benchmarks");
        out.println("6. Run Network benchmarks");
        out.println("X. Exit");
        out.flush();
    }

    public static void main(String[] args)
    {
        try
        {
            while (true)
            {
                printMenu();
                processRequest();
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            for (StackTraceElement ste : e.getStackTrace())
                System.err.println(ste.toString());
        }
    }

    private static void processRequest() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim().toUpperCase();

        PrintWriter writer = new PrintWriter(System.out);

        if (input.length() != 1)
        {
            writer.println("Invalid input");
            writer.flush();
            return;
        }

        char c = input.charAt(0);

        ResultPackager packager = new ResultPackager(writer, 10, new Runner());

        switch (c)
        {
            case '0':


                break;
            case '1':
                packager.runAndPackage(new FloatBenchmarkSuite());
                packager.runAndPackage(new MultiplicationBenchmarkSuite());
                packager.runAndPackage(new JarFileBenchmarkSuite());
                packager.runAndPackage(new LinPackBenchmarkSuite());
                packager.runAndPackage(new HashedCollectionsBenchmarkSuite());
                packager.runAndPackage(new UrlConnectionBenchmarkSuite());
                break;
            case '2':
                packager.runAndPackage(new FloatBenchmarkSuite());
                packager.runAndPackage(new MultiplicationBenchmarkSuite());
                break;
            case '3':
                packager.runAndPackage(new JarFileBenchmarkSuite());
                break;
            case '4':
                packager.runAndPackage(new LinPackBenchmarkSuite());
                break;
            case '5':
                packager.runAndPackage(new HashedCollectionsBenchmarkSuite());
                break;
            case '6':
                packager.runAndPackage(new UrlConnectionBenchmarkSuite());
                break;
            case 'X':
                System.exit(0);
                return;
        }
    }
}