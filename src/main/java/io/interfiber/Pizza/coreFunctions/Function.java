package io.interfiber.Pizza.coreFunctions;
import java.io.*;

import io.interfiber.Pizza.compiler.compiler;
import io.interfiber.Pizza.lang.MissingFunctionException;
import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.lang.VarNullException;
import io.interfiber.Pizza.utils.tmp;
public class Function {

    public static void runFuncFile(String path) throws IOException, SyntaxException, VarNullException, MissingFunctionException, Exception {
        //Run function. DONE!
        File funcFile = new File(path);
        if(!funcFile.exists()){
            throw new MissingFunctionException(funcFile.getName().replace(".pizzafunc", "").trim());
        }
        compiler.compile(path, false);
    }
}
