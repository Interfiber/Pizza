package io.interfiber.Pizza.coreFunctions;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import io.interfiber.Pizza.coreFunctions.Variable;
import io.interfiber.Pizza.utils.tmp;
import org.apache.commons.io.FileUtils;


public class Math {
		/**
		 *The Math Library for Pizza
		 *Functions such as Math.add Math.subtract and other functions
		 *related to math
		 *@since 0.1 Beta
		 * @author Interfiber
		 * @version 1.0
		**/

	public static void get(String num1, String key, String num2, String output) throws IOException {
		String tmpDir = tmp.getTmpDir();
		File tmp = new File(tmpDir + "/pizza");
		FileUtils.forceMkdir(tmp);
		// Addition
			if(!num1.contains(".:") && !num2.contains(".:") && key.contains("+")){
				int plusOut = Integer.parseInt(num1) + Integer.parseInt(num2);
				Variable.create(output, String.valueOf(plusOut));
			}
			if(num1.contains(".:") && num2.contains(".:") && key.contains("+")) {
				String num1Data = Variable.read(num1.replace(".:", "").trim());
				String num2Data = Variable.read(num2.replace(".:", "").trim());
				Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) + Integer.parseInt(num2Data.trim())));
				
			}
			if(!num1.contains(".:") && num2.contains(".:") && key.contains("+")){
				String num2Data = Variable.read(num2.replace(".:", "").trim());
				Variable.create(output, String.valueOf(Integer.parseInt(num1.trim()) + Integer.parseInt(num2Data.trim())));
			}
		if(num1.contains(".:") && !num2.contains(".:") && key.contains("+")){
			String num1Data = Variable.read(num1.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) + Integer.parseInt(num2.trim())));
		}
		// Subtraction
		if(!num1.contains(".:") && !num2.contains(".:") && key.contains("-")){
			int plusOut = Integer.parseInt(num1) + Integer.parseInt(num2);
			Variable.create(output, String.valueOf(plusOut));
		}
		if(num1.contains(".:") && num2.contains(".:") && key.contains("-")) {
			String num1Data = Variable.read(num1.replace(".:", "").trim());
			String num2Data = Variable.read(num2.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) - Integer.parseInt(num2Data.trim())));

		}
		if(!num1.contains(".:") && num2.contains(".:") && key.contains("-")){
			String num2Data = Variable.read(num2.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1.trim()) - Integer.parseInt(num2Data.trim())));
		}
		if(num1.contains(".:") && !num2.contains(".:") && key.contains("-")){
			String num1Data = Variable.read(num1.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) - Integer.parseInt(num2.trim())));
		}
		// Multiplication
		if(!num1.contains(".:") && !num2.contains(".:") && key.contains("*")){
			int plusOut = Integer.parseInt(num1) + Integer.parseInt(num2);
			Variable.create(output, String.valueOf(plusOut));
		}
		if(num1.contains(".:") && num2.contains(".:") && key.contains("*")) {
			String num1Data = Variable.read(num1.replace(".:", "").trim());
			String num2Data = Variable.read(num2.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) * Integer.parseInt(num2Data.trim())));

		}
		if(!num1.contains(".:") && num2.contains(".:") && key.contains("*")){
			String num2Data = Variable.read(num2.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1.trim()) * Integer.parseInt(num2Data.trim())));
		}
		if(num1.contains(".:") && !num2.contains(".:") && key.contains("*")){
			String num1Data = Variable.read(num1.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) * Integer.parseInt(num2.trim())));
		}
		// Division
		if(!num1.contains(".:") && !num2.contains(".:") && key.contains("/")){
			int plusOut = Integer.parseInt(num1) / Integer.parseInt(num2);
			Variable.create(output, String.valueOf(plusOut));
		}
		if(num1.contains(".:") && num2.contains(".:") && key.contains("/")) {
			String num1Data = Variable.read(num1.replace(".:", "").trim());
			String num2Data = Variable.read(num2.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) / Integer.parseInt(num2Data.trim())));

		}
		if(!num1.contains(".:") && num2.contains(".:") && key.contains("/")){
			String num2Data = Variable.read(num2.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1.trim()) / Integer.parseInt(num2Data.trim())));
		}
		if(num1.contains(".:") && !num2.contains(".:") && key.contains("/")){
			String num1Data = Variable.read(num1.replace(".:", "").trim());
			Variable.create(output, String.valueOf(Integer.parseInt(num1Data.trim()) / Integer.parseInt(num2.trim())));
		}




	}
}
