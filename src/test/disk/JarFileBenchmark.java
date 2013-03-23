
package test.disk;

import framework.Benchmark;

import java.io.File;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class JarFileBenchmark implements Benchmark
{
    private String filename = JarFileBenchmark.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/log4j.properties";

    @Override
    public void execute(long repetitions) throws Exception
    {
        File f = new File(filename);

        f.canRead();

//        File f = new File(filename);
//        for (int i = 0; i < repetitions; ++i)
//        {
//            JarFile jf = new JarFile(f);
//            Manifest m = jf.getManifest();
//            jf.close();
//        }
    }
}