
package test.disk;

import java.io.File;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import framework.SimpleBenchmark;

public class JarFileBenchmark extends SimpleBenchmark {

    private String filename = "WEB-INF/lib/gson.jar";

    public void timeReadJARManifest(int reps) throws Exception {
        File f = new File(filename);
        for (int i = 0; i < reps; ++i) {
            JarFile jf = new JarFile(f);
            Manifest m = jf.getManifest();
            jf.close();
        }
    }
}
