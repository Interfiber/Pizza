package io.interfiber.Pizza.utils;
import java.io.*;

public class tmp {
    public static String getTmpDir(){
        return System.getenv("TMPDIR");
    }
    public static void createTmp(){
        File tmpDir = new File(tmp.getTmpDir() + "/pizza");
        if(!tmpDir.exists()){
            tmpDir.mkdir();
            if(!tmpDir.exists()){
                System.out.println("Failed to create pizza tmpDir!");
                System.exit(1);
            }
        }

    }
}
