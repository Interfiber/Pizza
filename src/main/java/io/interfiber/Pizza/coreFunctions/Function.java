package io.interfiber.Pizza.coreFunctions;
import java.io.*;

import io.interfiber.Pizza.compiler.compiler;
import io.interfiber.Pizza.utils.tmp;
public class Function {

    public static void runFuncFile(String path) throws IOException {
            //Run function. DONE!
        compiler.compile(path, false);
    }
}
