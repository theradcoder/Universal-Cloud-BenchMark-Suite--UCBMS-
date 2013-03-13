
package test.network;

import framework.Benchmark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionBenchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        for (int i = 0; i < repetitions; ++i)
        {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((in.readLine()) != null)
            {
            }
            in.close();
        }
    }
}