package io.interfiber.Pizza.coreFunctions;
import io.interfiber.Pizza.lang.VarCreateException;
import io.interfiber.Pizza.lang.VarNullException;
import io.interfiber.Pizza.utils.tmp;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Variable {
	/**
	 * Handle things related to varibles
	 * such as read a vars contents,
	 * test if a var exists, get a vars path, create a var, and merge to vars together.
	 * @param varName
	 * @param varData
	 * @throws IOException
	 */
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
		varReader.useDelimiter("\\Z");
		String varData = null;
		varData = varReader.next();
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
