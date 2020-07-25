package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.FileExistsException;
import io.interfiber.Pizza.lang.MissingFileException;
import org.rauschig.jarchivelib.Archiver;
import org.rauschig.jarchivelib.ArchiverFactory;

import java.io.File;
import java.io.IOException;

public class Zip {
    public void unzip(String zipPath, String outPath) throws IOException {
        File zipFile = new File(zipPath);
        if(!zipFile.exists()){
            try {
                throw new MissingFileException(zipPath);
            } catch (MissingFileException e) {
                e.printStackTrace();
            }
        }
        File outFile = new File(outPath);
        if(outFile.exists()){
            try {
                throw new FileExistsException(outPath);
            } catch (FileExistsException e) {
                e.printStackTrace();
            }
        }

        Archiver archiver = ArchiverFactory.createArchiver("zip");
        archiver.extract(new File(zipFile.getAbsolutePath()), new File(outFile.getAbsolutePath()));

    }
}
