package io.interfiber.Pizza.coreFunctions;

import java.io.IOException;

import io.interfiber.Pizza.compiler.compiler;
import io.interfiber.Pizza.lang.MissingFunctionException;
import io.interfiber.Pizza.lang.SyntaxException;
import io.interfiber.Pizza.lang.VarNullException;
import io.interfiber.Pizza.utils.tmp;

public class Loop {

	/**
	 * Loop a pizza function
	 * @param loopTimes
	 * @param function
	 * @throws IOException
	 * @throws SyntaxException
	 * @throws VarNullException
	 * @throws MissingFunctionException
	 * @throws Exception
	 */
	
	public static void forLoop(int loopTimes, String function) throws IOException, SyntaxException, VarNullException, MissingFunctionException, Exception {
		
		for(int i=0;i<loopTimes;i++) {
			Function.runFuncFile(tmp.getTmpDir() + "/pizza/" + function +  ".pizzafunc");
		}
	}
}
