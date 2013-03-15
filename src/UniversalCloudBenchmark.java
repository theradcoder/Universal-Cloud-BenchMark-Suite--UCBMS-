import java.io.*;

/**
 * User: jgerard
 * Date: 3/14/13
 * Time: 9:07 PM
 */
public class UniversalCloudBenchmark
{
    private static void printMenu()
    {
        Console console = System.console();
        PrintWriter out = console.writer();

        out.println("Universal Cloud Benchmark v1.0");
        out.println();
        out.println("1. Run all benchmarks");
        out.println("2. Run CPU benchmarks");
        out.println("3. Run Disk benchmarks");
        out.println("4. Run Linpack benchmarks");
        out.println("5. Run Memory benchmarks");
        out.println("6. Run Network benchmarks");
        out.println("X. Exit");
    }
    
    public static void main(String[] args)
    {
        while(true)
        {
            printMenu();
            processRequest();
        }
    }

    private static void processRequest()
    {
        String input = System.console().readLine().trim().toUpperCase();

        if(input.length() != 1)
        {
            System.out.println("Invalid input");
            return;
        }

        char c = input.charAt(0);

        switch(c)
        {
            case '0':
                break;
            case '1':
                break;
            case '2':
                break;
            case '3':
                break;
            case '4':
                break;
            case '5':
                break;
            case '6':
                break;
            case 'X':
                System.exit(0);
                return;
        }
    }
}