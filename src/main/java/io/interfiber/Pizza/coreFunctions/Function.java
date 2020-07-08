package io.interfiber.Pizza.coreFunctions;
import io.interfiber.Pizza.compiler.compiler;
import io.interfiber.Pizza.lang.MissingFunctionException;
import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.lang.VarNullException;

import java.io.File;
import java.io.IOException;

public class Function {
    /**
     * Create a pizza function
     * @param path
     * @throws IOException
     * @throws SyntaxException
     * @throws VarNullException
     * @throws MissingFunctionException
     * @throws Exception
     */
    public static void runFuncFile(String path) throws IOException, SyntaxException, VarNullException, MissingFunctionException, Exception {
        //Run function. DONE!
        File funcFile = new File(path);
        if(!funcFile.exists()){
            throw new MissingFunctionException(funcFile.getName().replace(".pizzafunc", "").trim());
        }
        compiler.compile(path, false, true);
    }
}
