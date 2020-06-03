package io.interfiber.Pizza;
import io.interfiber.Pizza.compiler.*;
import java.io.*;
public class pizza {

	

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // call compile function
    	
        try {
            compiler.compile(args[0], true);
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
