package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.MissingFunctionException;
import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.lang.VarNullException;
import io.interfiber.Pizza.utils.tmp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class If {

    public static void contains(String var, String containsData, String function) throws IOException, SyntaxException, VarNullException, MissingFunctionException, Exception {
        String varData = Variable.read(var);
        if(containsData.contains(".:")){
            //containsData is a var
            containsData = Variable.read(containsData.replace(".:", "").trim());
        }
        if(varData.contains(containsData)){
            Function.runFuncFile(tmp.getTmpDir() + "/pizza/" + function + ".pizzafunc");
        }

    }
}
