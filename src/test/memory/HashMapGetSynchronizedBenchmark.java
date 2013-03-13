package test.memory;

import framework.Benchmark;

import java.util.HashMap;

public class HashMapGetSynchronizedBenchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        HashMap<String, String> map = new HashMap<String, String>();
        synchronized (map)
        {
            map.put("hello", "world");
        }
        for (int i = 0; i < repetitions; ++i)
        {
            synchronized (map)
            {
                map.get("hello");
            }
        }
    }
}
