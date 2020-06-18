package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.VarCreateException;

import java.io.File;
import java.io.IOException;

public class OS {
    public static String getPizzaVersion(){
        return "0.3";
    }
    public static String getJavaVersion(){
        return System.getProperty("java.version");
    }
    public static String getJavaVendor(){
        return System.getProperty("java.vendor");
    }
    public static String getOSName(){
        return System.getProperty("os.name");
    }
    public static String getOSVersion(){
        return System.getProperty("os.version");
    }
    public static String getUserName(){
        return System.getProperty("user.name");
    }
    public static String getUserHome(){
        return System.getProperty("user.home");
    }
    public static void getProperty(String property, String varOut) throws IOException {
        if(property.equalsIgnoreCase("pizza.version")){
            Variable.create(varOut, getPizzaVersion());
        }
        if(property.equalsIgnoreCase("OS.Name")){
            Variable.create(varOut, getOSName());
        }
        if(property.equalsIgnoreCase("OS.Version")){
            Variable.create(varOut, getOSVersion());
        }
        if(property.equalsIgnoreCase("User.Name")){
            Variable.create(varOut, getUserName());
        }
        if(property.equalsIgnoreCase("User.Home")){
            Variable.create(varOut, getUserHome());
        }
        File varPath = new File(Variable.getVarPath(varOut));
        if(!varPath.exists()){
            try {
                throw new VarCreateException(varOut);
            } catch (VarCreateException e) {
                e.printStackTrace();
            }
        }
    }
}
