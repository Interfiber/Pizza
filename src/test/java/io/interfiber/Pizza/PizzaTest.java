package io.interfiber.Pizza;

import io.interfiber.Pizza.coreFunctions.Variable;
import io.interfiber.Pizza.utils.tmp;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PizzaTest {

    @Test
    public void createVar() throws IOException {
        tmp.createTmp();
        File tmp = new File(io.interfiber.Pizza.utils.tmp.getTmpDir() + "/pizza");
        if(!tmp.exists()){
            System.out.println("Failed To Create Tmp!");
        }

        try {
            Variable.create("testVarForTesting", "foo foo foo FOOo");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File var = new File(Variable.getVarPath("testVarForTesting"));

        if(!var.exists()){
            System.out.println("Variable Class Failed Test!");
        }

    }
}
