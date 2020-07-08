package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.*;
import java.io.File;
import java.io.IOException;

public class IOFile {


    public static void createFile(String path) throws IOException {
        File f = new File(path);
        if(f.exists()){
            try {
                throw new FileExistsException(path);
            } catch (FileExistsException e) {
                e.printStackTrace();
            }
        }
        if(!f.createNewFile()){
            try {
                throw new FileCreationException(path);
            } catch (FileCreationException e) {
                e.printStackTrace();
            }
        }

    }
}
