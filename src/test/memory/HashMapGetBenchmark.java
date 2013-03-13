package test.memory;

import framework.Benchmark;

import java.util.HashMap;

public class HashMapGetBenchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < repetitions; ++i)
        {
            map.get("hello");
        }
    }
}