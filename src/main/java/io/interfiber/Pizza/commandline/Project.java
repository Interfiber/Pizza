package io.interfiber.Pizza.commandline;
import java.io.*;
import java.util.*;

public class Project {
	/**
	 * Create A Pizza Project Containg Files Based on a user
	 * input
	 * @throws IOException
	 */
	
	public void create() throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Pizza project Creator");
		System.out.print("Enter Project Name:");
		String projectName = scan.nextLine();
		System.out.print("Enter Main Source File:");
		String sourceFile = scan.nextLine();
		if(sourceFile.contains(".pizza")) {
			sourceFile.replace(".pizza", null);
		}
		File project = new File(projectName);
		if(!project.mkdir()) {
			System.out.println("Could Not Create Project Directory");
		}
		File source = new File(project.toString() + "/" + sourceFile.trim() + ".pizza");
		if(!source.createNewFile()) {
			System.err.println("Failed To create source file");
			System.exit(-1);
		}
		System.out.println("Complete!");
		
		
	}
}
	