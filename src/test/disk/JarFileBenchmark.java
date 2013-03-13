
package test.disk;

import framework.Benchmark;

import java.io.File;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarFileBenchmark implements Benchmark
{
    private String filename = "WEB-INF/lib/gson.jar";

    @Override
    public void execute(long repetitions) throws Exception
    {
        File f = new File(filename);
        for (int i = 0; i < repetitions; ++i)
        {
            JarFile jf = new JarFile(f);
            Manifest m = jf.getManifest();
            jf.close();
        }
    }
}