package test.memory;

import framework.Benchmark;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapGetBenchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < repetitions; ++i)
        {
            map.get("hello");
        }
    }
}