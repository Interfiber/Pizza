package io.interfiber.Pizza.utils;
import java.io.*;


public class cleanup {

    public static  void cleanup(){
    File tmpPizza = new File(tmp.getTmpDir() + "pizza");
    if(!tmpPizza.delete()){
        System.err.println("ERROR! Could not execute RuntimeCleanup!");
        System.err.println("Could not remove" + tmpPizza.toString() + " Please remove this folder");
        System.err.println("Manually with rm -rf " + tmpPizza.toString());
     }
    }
}
