package test.memory;

import framework.Benchmark;

import java.util.LinkedHashMap;

public class LinkedHashMapGetBenchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < repetitions; ++i)
        {
            map.get("hello");
        }
    }
}
