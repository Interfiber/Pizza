package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.ClassExistsException;
import io.interfiber.Pizza.lang.FileCreationException;
import io.interfiber.Pizza.utils.tmp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Class {

    public void create(String className, String classCode) throws IOException {
        // Class data is stored in .pclas files
        File classFile = new File(tmp.getTmpDir() + "/" + className + ".pclas");
        if(classFile.exists()){
            try {
                throw new ClassExistsException(className);
            } catch (ClassExistsException e) {
                e.printStackTrace();
            }
        }
        if(!classFile.createNewFile()){
            try {
                throw new FileCreationException(classFile.getAbsolutePath());
            } catch (FileCreationException e) {
                e.printStackTrace();
            }
        }
        FileWriter fw = new FileWriter(classFile);
        fw.write(classCode);
        fw.close();

    }
}
