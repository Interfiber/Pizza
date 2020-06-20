package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.VarNullException;
import java.math.*;

public class MathPi {

    /**
    * Math Library For Pizza But Only Made
     * to Perform Tasks Related To PI Algorithms
     * @since 0.3
     * @version 1.0
     * @author Interfiber
     **/


    // Heavy Comments In Coming!
    public void pi(double radius, String varOut){
        // Lets Blow THis Popsicle Stand
        // Check if VarOut Exists Yet
        try {
            Variable.varExists(varOut);
            // Catch A VarNullException: io.interfiber
        } catch (VarNullException e) {
            e.printStackTrace();
        }
        // If It Does Not Exists Then We Do Some Math To Produce A OUTPUT NUMBER!
        //java.lang.Math;
         // We Need To Use java.lang.math instead of Math because Math.java is in the current package!




    }

}
