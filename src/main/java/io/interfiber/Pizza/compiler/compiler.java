package io.interfiber.Pizza.compiler;
import java.io.*;
import java.util.*;
import io.interfiber.Pizza.coreFunctions.Function;
import io.interfiber.Pizza.coreFunctions.Variable;
import io.interfiber.Pizza.coreFunctions.Screen;
import io.interfiber.Pizza.utils.*;
import io.interfiber.Pizza.coreFunctions.exit;
import io.interfiber.Pizza.coreFunctions.Math;
public class compiler {
	public static void compile(String inputFile) throws IOException, NoSuchElementException{
		// Get file data
		File input = new File(inputFile);
		Scanner reader = new Scanner(input);
		String out = null;
		while (reader.hasNextLine()) {
				out = reader.next();
				if (out.contains("Console.pushString")) {
					Screen.printString(reader.nextLine().replace("\"", "").trim());
				}
				if (out.contains("var")) {
					Variable.create(reader.next(), reader.nextLine());
				}
				if (out.contains("exit")) {
					exit.terminateProcess(0);
				}
				if (out.contains("function")) {
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
				if (out.contains("funcrun")) {
					String funcName = reader.next() + ".pizzafunc";
					Function.runFuncFile(tmp.getTmpDir() + "/pizza/" + funcName);
				}
				if(out.contains("get")){

				}

			}


	}
	}
