package test.memory;

import framework.Benchmark;

import java.util.Hashtable;

public class HashtableGetBenchmark implements Benchmark
{
    @Override
    public void execute(long repetitions) throws Exception
    {
        Hashtable<String, String> map = new Hashtable<String, String>();
        map.put("hello", "world");
        for (int i = 0; i < repetitions; ++i)
        {
            map.get("hello");
        }
    }
}
