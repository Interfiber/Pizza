package io.interfiber.Pizza.utils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class cleanup {
    /**
     * Cleanup the folder created when pizza is running
     * that contains variables, functions, Arrays, and other stuff
     */
    public static  void cleanup(){
    File tmpPizza = new File(tmp.getTmpDir() + "pizza");
    try {
		FileUtils.deleteDirectory(tmpPizza);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
