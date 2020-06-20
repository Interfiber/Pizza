package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.VarExistsException;
import io.interfiber.Pizza.lang.VarNullException;
import java.io.*;
/**
 *The Math Library for Pizza
 * But With a TWIST!
 * This Chunk is Only Used For Calculating The Square Root Of A Number
 * @since 0.3
 * @author Interfiber
 * @version 1.0
 **/


public class MathSquare {

    public static void square(int input, String varOut) throws VarNullException, IOException {
        // This Should Be Easy...
        File varOutPath = new File(Variable.getVarPath(varOut));
        if(varOutPath.exists()){
            try {
                throw new VarExistsException(varOut);
            } catch (VarExistsException e) {
                e.printStackTrace();
            }
        }
        int square = input * input;
        Variable.create(varOut, String.valueOf(square));
    }
}
