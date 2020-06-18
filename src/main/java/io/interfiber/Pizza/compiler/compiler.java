package io.interfiber.Pizza.compiler;
import java.io.*;
import java.util.*;

import io.interfiber.Pizza.IOLib.Writer;
import io.interfiber.Pizza.coreFunctions.*;
import io.interfiber.Pizza.coreFunctions.Math;
import io.interfiber.Pizza.coreFunctions.command;
import io.interfiber.Pizza.lang.MissingFunctionException;
import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.lang.VarNullException;
import io.interfiber.Pizza.utils.*;
import org.apache.commons.io.FileUtils;

public class compiler {
	public static String httpLibIsImported;
	public static void compile(String inputFile, boolean compiledFirst, boolean saveTmp) throws IOException, NoSuchElementException, SyntaxException, VarNullException, MissingFunctionException, Exception {
		// Get file data
		File input = new File(inputFile);
		Scanner reader = new Scanner(input);
		String out = null;
		while (reader.hasNext()) {
			out = reader.next();
			if (out.equals("Console.pushString")) {
				String message = null;
				try {
					message = reader.nextLine().replace("\"", "").trim();
				}catch(NoSuchElementException ex){
					if(message == null){
						throw new SyntaxException("Can not print null");
					}
				}
				Screen.printString(message);

			}


			if (out.equals("var")) {
				Variable.create(reader.next(), reader.nextLine());
			}
			if (out.equals("exit")) {
				String exitCode = null;
				try {
					exitCode = String.valueOf(reader.nextInt());
				}catch(NoSuchElementException e){
					throw new SyntaxException("Could not exit with exit code of " + exitCode);
				}
				exit.terminateProcess(0);
			}
			if (out.equals("function")) {
				String name = reader.next();
				String key = reader.next();
				String code = reader.nextLine();
				tmp.createTmp();
				File f = new File(tmp.getTmpDir() + "pizza/" + name + ".pizzafunc");
				FileWriter fw = new FileWriter(f);
				if (key.contains("{")) {
					while (!code.contains("}")) {
						fw.write(code);
						code = reader.nextLine().concat("\n");
					}
				}
				fw.close();
			}
			if (out.equals("funcrun")) {
				String funcName = reader.next() + ".pizzafunc";
				Function.runFuncFile(tmp.getTmpDir() + "/pizza/" + funcName);
			}
			if(out.equals("user.getNextLine")){
				User.getInput(reader.next());
			}
			if (out.equals("get")) {
				Math.get(reader.next(), reader.next(), reader.next(), reader.next());
			}

			if(out.equals("loop")){
				Loop.forLoop(reader.nextInt(), reader.next());
			}
			if(out.equals("exec")){
				command.executeCommand(reader.nextLine().replace("\"", "").trim());
			}
			if(out.equals("if.contains")) {
				String varible = reader.next().replace("\"", "").trim();
				String containsData = reader.next().replace("\"", "").trim();
				String funcName = reader.next().replace("\"", "").trim();
				If.contains(varible, containsData, funcName);
			}
			if(out.equals("Array")){
				String name = reader.next();
				String key = reader.next();
				String values = reader.nextLine();
				int i = 0;
				tmp.createTmp();
				while(!values.equals("}")){
					Writer.write(values.trim(), tmp.getTmpDir() + "/pizza/" + name + "." + i);
					values = reader.nextLine();
					i++;
				}
			}
			if(out.equals("merge")){
				// Syntax: merge var1 var2 var3
				// Console.pushString ".:var3"
				String Var1 = new String(reader.next());
				String Var2 = new String(reader.next());
				String VarOut = new String(reader.next());
				Variable.merge(Var1, Var2, VarOut);
				// Merge Complete
			}
			if(out.equals("OS.getProperty")){
				String property = reader.next();
				String varOut = reader.next();
				OS.getProperty(property, varOut);
			}


		}
		if(compiledFirst){
			if(saveTmp){
				System.out.println("Saved TmpDir!");
				System.out.println("Please Remove This Folder Before Another Program Runs:");
				System.out.println(tmp.getTmpDir() + "pizza");
			}
			if(saveTmp == false) {
				File remove = new File(tmp.getTmpDir() + "/pizza");
				if(remove.exists()) {
					FileUtils.forceDelete(remove);
					if (remove.exists()) {
						System.out.println("Could Not Remove TmpDir!");
					}
				}
			}
		}
	}
	}