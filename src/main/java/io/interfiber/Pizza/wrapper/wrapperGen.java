package io.interfiber.Pizza.wrapper;

import io.interfiber.Pizza.pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class wrapperGen {
    public static void generateProject() throws IOException {
        InputStream is = wrapperGen.class.getClassLoader()
                .getResourceAsStream("PizzaWrapper.sh");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder resultStringBuilder = new StringBuilder();
        while((line = br.readLine()) != null){
            resultStringBuilder.append(line).append("\n");
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Pizza project Generator");
        System.out.print("Project Name:");
        String name = s.nextLine();
        System.out.print("\nMain File(Do Not include .pizza at end):");
        String mainFile = s.nextLine();
        if (mainFile.contains(".pizza")){
            System.out.println("Aborting! You included .pizza in the Main File!");
            System.exit(1);
        }
        System.out.print("\nGenerate Wrapper(Y/N):");
        String genWrapper = s.nextLine();

        System.out.println(resultStringBuilder.toString());
    }
}
