package io.interfiber.Pizza;
import io.interfiber.Pizza.compiler.*;
import io.interfiber.Pizza.coreFunctions.Math;

import java.io.*;
public class pizza {

	

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // call compile function
        if(args[0].contains("--version") || args[0].contains("-v")){
            System.out.println("Pizza version information:");
            System.out.print("\n");
            String javaVersion = System.getProperty("java.version");
            String javaVendor = System.getProperty("java.vendor");
            String os = System.getProperty("os.name");
            System.out.println("Java Version: " + javaVersion);
            System.out.println("Pizza Version: 0.2 Beta");
            System.out.println("Java Vendor: " + javaVendor);
            System.out.println("OS: " + os);
            System.exit(0);
        }
        if(args[0].contains("--help") || args[0].contains("-h")){

        }
        try {
            if(args[0].contains("compile")) {
                compiler.compile(args[1], true);
            }
        }
        catch(java.lang.ArrayIndexOutOfBoundsException exception){
            System.out.println("Pizza -- CommandLine help page: 1");
            System.out.println("        pizza [filepath(example:~/dev/test.pizza)]");
            System.out.println("OPTIONS:");
            System.out.println("init: generate pizza project");
            System.out.println("install: Install a Pizza plugin for you project");
            System.exit(1);
        }
    }
}
