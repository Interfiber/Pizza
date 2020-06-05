package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.utils.tmp;

import java.io.FileNotFoundException;
import java.io.IOException;

public class If {

    public static void contains(String var, String containsData, String function) throws IOException {
        String varData = Variable.read(var);
        if(varData.contains(containsData)){
            Function.runFuncFile(tmp.getTmpDir() + "/pizza/" + function + ".pizzafunc");
        }

    }
}
