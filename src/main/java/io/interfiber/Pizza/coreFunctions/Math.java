package io.interfiber.Pizza.coreFunctions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import io.interfiber.Pizza.coreFunctions.Variable;


public class Math {
		/*
		   The Math Library for Pizza 
		   Functions such as Math.add Math.subtract and other functions
		   related to math
		   	@since 1.0
		   		
		   
		*/
	public static void get(String num1, String key, String num2, String output) throws IOException {

			if(!num1.contains(".:") && !num2.contains(".:") && key.contains("+")){
				int plusOut = Integer.parseInt(num1) + Integer.parseInt(num2);
				Variable.create(output, String.valueOf(plusOut));
			}

	}
}
