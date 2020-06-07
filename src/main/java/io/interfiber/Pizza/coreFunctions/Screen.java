package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.VarNullException;

import java.io.FileNotFoundException;


public class Screen {
	public static void printString(String input) throws FileNotFoundException, VarNullException {
		if(input.contains(".:")){
			String varFile = input.replace(".:", "");
			String data = null;
			try {
				 data = Variable.read(varFile.trim());
			}catch(FileNotFoundException e){
				throw new VarNullException(varFile);
			}
			System.out.println(data.trim());

		}
		if(!input.contains(".:")) {

			System.out.println(input);
		}
}
}