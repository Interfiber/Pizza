package io.interfiber.Pizza.IOLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public String read(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner sc = new Scanner(f);
        sc.useDelimiter("\\Z");
        return sc.nextLine();
    }
}
