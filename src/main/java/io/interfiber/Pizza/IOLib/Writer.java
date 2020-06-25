package io.interfiber.Pizza.IOLib;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    /**
     * Write to a file
     * @param data
     * @param file
     * @throws IOException
     */
    public static void write(String data, String file) throws IOException {
        File f = new File(file);
        FileWriter fw = new FileWriter(f);
        fw.write(data);
        fw.close();
    }
}
