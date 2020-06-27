package io.interfiber.Pizza;
import io.interfiber.Pizza.commandline.Project;
import io.interfiber.Pizza.compiler.*;
import io.interfiber.Pizza.lang.MissingFunctionException;
import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.lang.VarNullException;
import java.util.*;

import java.io.*;

public class pizza {

    /**
     * Launch pizza with arguments
     * Main Class
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     * @throws SyntaxException
     * @throws VarNullException
     * @throws MissingFunctionException
     * @throws Exception
     */

    public static void main(String[] args) throws FileNotFoundException, IOException, SyntaxException, VarNullException, MissingFunctionException, Exception {
        // call compile function
    	try {
        if(args[0].contains("--version") || args[0].contains("-v")){
            System.out.println("Pizza version information:");
            System.out.print("\n");
            String javaVersion = System.getProperty("java.version");
            String javaVendor = System.getProperty("java.vendor");
            String os = System.getProperty("os.name");
            System.out.println("Java Version: " + javaVersion);
            System.out.println("Pizza Version: 0.4 Beta");
            System.out.println("Java Vendor: " + javaVendor);
            System.out.println("OS: " + os);
            System.exit(0);
        }
        if(args[0].equals("init")) {
        	Project p = new Project();
        	p.create();
        }
        if(args[0].contains("--help") || args[0].contains("-h")){
                System.out.println("Arguments:");
                System.out.println("- compile [pizza file]: Compile .pizza file");
                System.out.println("- init: create Pizza project");
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
    	}catch(java.lang.ArrayIndexOutOfBoundsException e) {
         	System.out.println("Error! No input files or arguments!");
         	System.out.println("run pizza --help for more help");
         	System.exit(-1);
    	}
			
    }
}
