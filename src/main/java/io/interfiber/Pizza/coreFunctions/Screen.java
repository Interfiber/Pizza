package io.interfiber.Pizza.coreFunctions;

import java.io.FileNotFoundException;


public class Screen {
	public static void printString(String input) throws FileNotFoundException {
		if(input.contains(".:")){
			String varFile = input.replace(".:", "");
			String data = Variable.read(varFile.trim());
			System.out.println(data.trim());

		}
		if(!input.contains(".:")) {
			System.out.println(input);
		}
}
}