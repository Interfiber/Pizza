package io.interfiber.Pizza.utils;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class tmp {
    public static String getTmpDir(){
        return System.getenv("TMPDIR");
    }
    public static void createTmp() throws IOException {
        File tmpDir = new File(tmp.getTmpDir() + "pizza");
        tmpDir.mkdirs();
        if(!tmpDir.exists()){
            System.out.println("Could Not Create " + tmp.getTmpDir());
            System.exit(1);
        }

    }
}
