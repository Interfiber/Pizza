package io.interfiber.Pizza.compiler;
import java.io.*;
import java.util.*;
import io.interfiber.Pizza.coreFunctions.Variable;
import io.interfiber.Pizza.coreFunctions.Screen;
public class compiler {

	public static void compile(String inputFile) throws IOException {

		// Get file data
		File input = new File(inputFile);
		Scanner reader = new Scanner(input);
		String out = null;
		while (reader.hasNextLine()){
			// do stuff
			out = reader.next();
			if (out.contains("Console.pushString")){
				Screen.printString(reader.nextLine());

			}
			if (out.contains("var")){
				Variable.create(reader.next(), reader.nextLine());
			}
			if(out.contains("Vars.delete !")){
				//Syntax: Vars.delete [force-opertion:!=yes,#=no] [varible]
				
			}
		}
	}
}