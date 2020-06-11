package io.interfiber.Pizza.coreFunctions;
import io.interfiber.Pizza.HttpLib.StartServer;
import io.interfiber.Pizza.compiler.compiler;

import java.io.*;

public class Importer {

    public static void importCore(String libID){
        if(libID.contains("HttpLib")){
                compiler compiler = new compiler();
                compiler.httpLibIsImported = "true";
                System.out.println("DONE!");
        }

    }
    public static void importCustom(String pkgFile){
        // PKG File is a file that contains all of the functions. Written in the zip format
        File pkg = new File(pkgFile);

    }

}
