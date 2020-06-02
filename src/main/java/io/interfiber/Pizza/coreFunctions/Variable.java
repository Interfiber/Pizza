package io.interfiber.Pizza.coreFunctions;
import io.interfiber.Pizza.lang.VarNullException;
import io.interfiber.Pizza.utils.tmp;

import java.io.*;
import java.util.Scanner;


public class Variable {
	public static void create(String varName, String varData) throws  IOException {
		File pizzaTmp = new File(tmp.getTmpDir() + "pizza");
		File varStore = new File(pizzaTmp.toString() + "/" + varName);
		if (!varStore.createNewFile()){
			System.err.println("ERROR! Could not create varStore file at" + tmp.getTmpDir() + "pizza/" + varName);
			System.err.println("Please remove it before executing again!");
			System.exit(1);
		}
		FileWriter fw = new FileWriter(varStore);
		fw.write(varData);
		fw.close();

	}
	public static String read(String varName) throws FileNotFoundException {
		File varFile = new File(tmp.getTmpDir() + "pizza/" + varName);
		Scanner varReader = new Scanner(varFile);
		String varData = null;
		while(varReader.hasNextLine()){
			varData = varReader.nextLine();
		}
		return varData;

	}
	public static void varExists(String varName){
		File varFile = new File(tmp.getTmpDir() + "pizza/" + varName);
		if(!varFile.exists()){
			VarNullException.catchError(varName);
		}
	}
}
