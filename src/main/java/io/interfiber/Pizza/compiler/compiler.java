package io.interfiber.Pizza.compiler;
import io.interfiber.Pizza.HttpLib.Downloader;
import io.interfiber.Pizza.IOLib.Writer;
import io.interfiber.Pizza.coreFunctions.Math;
import io.interfiber.Pizza.coreFunctions.*;
import io.interfiber.Pizza.lang.*;
import io.interfiber.Pizza.utils.tmp;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class compiler {
	public static String httpLibIsImported;

	/**
	 * Parses And Handles syntax
	 * to Add More Syntax add another if statement
	 * example:
	 * if(out.equals("say")){
	 * String message = reader.nextLine();
	 * Process px = Runtime.getRuntime().exec("say " + message);
	 * }
	 * @author Interfiber
	 * @version 1.4
	 * @since 0.1
	 * @param inputFile
	 * @param compiledFirst
	 * @param saveTmp
	 * @throws IOException
	 * @throws NoSuchElementException
	 * @throws SyntaxException
	 * @throws VarNullException
	 * @throws MissingFunctionException
	 * @throws Exception
	 */
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
				String varName = reader.next();
				String key = reader.next();
				String varData = reader.nextLine();
				if(!key.equals("=")) {
					throw new SyntaxException("Expected Token =");
				}
				
				Variable.create(varName, varData.replace("\"", ""));
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
					Writer.write(values.replace("\"", "").trim(), tmp.getTmpDir() + "/pizza/" + name + "." + i);
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
			if(out.equals("time.getLocal")){
				String varOut = reader.next();
				Time.getDateTime(varOut);
			}
			if(out.equals("square")){
				// Other Math func
				String num1 = reader.next();
				String varOut = reader.next();
				MathSquare.square(num1, varOut);
			}
			if(out.equals("IO.retriveFile")) {
				try {
				String url = reader.next();
				String outputFile = reader.next();
				Downloader.downloadFile(url, outputFile);
				}catch(NullPointerException e5) {
					throw new SyntaxException("Missing or Corrupted Argument Found!");
				}
			}
			if(out.equals("Time.sleep")) {
				ThreadProcess tp = new ThreadProcess();
				tp.sleep(Integer.parseInt(reader.next()));
			}
			if(out.equals("Window.init")) {
				String inputYaml = reader.next();
				Window.createWindow(inputYaml);
			}
			if(out.equals("Window.createPopup")) {
				Window w = new Window();
				w.createPopup(reader.nextLine());
			}
			if(out.equals("IStream")){
				String var = reader.next();
				String file = reader.next().replace("\"", "").trim();
				String key = reader.next();
				String placeHolder = reader.nextLine();
				String text = reader.nextLine();
				if(key.contains("{")){
					FileWriter fw = new FileWriter(new File(file));
					while(!text.contains("}")){
						fw.write(text + "\n");
						text = reader.nextLine();
					}
					fw.close();
				}
			}
			if(out.equals("OStream")){
				// Syntax
				// OStream os = "file"
				// Console.pushString ".:os"
				String name = reader.next();
				String key = reader.next();
				if(!key.contains("=")){
					throw new SyntaxException("Could Not find Symbol =");
				}
				String filePath = reader.next().replace("\"", "").trim();

				File f = new File(filePath);
				if(!f.exists()){
					throw new MissingFileException(filePath);
				}
				File varPath = new File(Variable.getVarPath(name));
				if(varPath.exists()){
					throw new VarExistsException(name);
				}
				Scanner s = new Scanner(new File(filePath));
				s.useDelimiter("\\Z");
				Variable.create(name, s.next());
			}



		}
		if(compiledFirst){
			if(saveTmp){
				System.out.println("Saved TmpDir!");
				System.out.println("Please Remove This Folder Before Another Program Runs:");
				System.out.println(tmp.getTmpDir() + "pizza");
			}
			
			if(!saveTmp) {
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