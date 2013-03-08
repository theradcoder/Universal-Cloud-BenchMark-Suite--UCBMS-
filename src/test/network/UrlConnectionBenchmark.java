
package test.network;

import framework.SimpleBenchmark;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionBenchmark extends SimpleBenchmark
{

	public void timeUrlConnection(int reps) throws Exception {

        for (int i = 0; i < reps; ++i) {
        	URL url = new URL("http://www.google.com");
        	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((inputLine = in.readLine()) != null) 
                System.out.println(inputLine);
            in.close();
        }
    }
    
    
}
