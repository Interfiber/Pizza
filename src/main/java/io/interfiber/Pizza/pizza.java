package io.interfiber.Pizza;
import io.interfiber.Pizza.compiler.*;
import io.interfiber.Pizza.lang.MissingFunctionException;
import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.lang.VarNullException;

import java.io.*;

public class pizza {

	

    public static void main(String[] args) throws FileNotFoundException, IOException, SyntaxException, VarNullException, MissingFunctionException, Exception {
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
        if(args[0].contains("--java-version")){
            System.out.println(System.getProperty("java.version"));
        }
        if(args[0].contains("--help") || args[0].contains("-h")){
                System.out.println("Arguments:");
                System.out.println("- compile [pizza file]: Compile .pizza file");
                System.out.println("Info Flags:");
                System.out.println("--version: get version of pizza");
                System.out.println("Commands:");
                System.out.println("--help: Show this page");

        }

            if(args[0].contains("compile")) {
                boolean saveTmp = false;
                try {
                    if (args[2].equals("--save-tmp")) {
                        saveTmp = true;
                    }
                }catch(IndexOutOfBoundsException e){

                }
                compiler.compile(args[1], true, saveTmp);
            }

    }
}
