package io.interfiber.Pizza.coreFunctions;
import io.interfiber.Pizza.lang.VarCreateException;
import io.interfiber.Pizza.lang.VarNullException;
import io.interfiber.Pizza.utils.tmp;

import java.io.*;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;


public class Variable {
	public static void create(String varName, String varData) throws  IOException {
		File pizzaTmp = new File(tmp.getTmpDir() + "pizza");
		File varStore = new File(pizzaTmp.toString() + "/" + varName);
		FileUtils.touch(varStore);
		FileWriter fw = new FileWriter(varStore);
		fw.write(varData);
		fw.close();

	}
	public static void varExists(String varName) throws VarNullException {
		File f = new File(tmp.getTmpDir() + "/pizza/" + varName);
		if(!f.exists()){
			throw new VarNullException(varName);
		}
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
	public static String getVarPath(String var){return tmp.getTmpDir() + "/pizza/" + var;}
	public static void merge(String var1, String var2, String varOut) throws IOException, VarNullException {
		Variable.varExists(var1);
		Variable.varExists(var2);
		String mergeOut = Variable.read(var1) + " " + Variable.read(var2);
		Variable.create(varOut, mergeOut);
		File varFile = new File(getVarPath(varOut));
		if(!varFile.exists()){
			try {
				throw new VarCreateException(varOut);
			} catch (VarCreateException e) {
				e.printStackTrace();
			}
		}

	}
}
