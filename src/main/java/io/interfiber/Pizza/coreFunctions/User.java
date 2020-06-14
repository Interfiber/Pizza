package io.interfiber.Pizza.coreFunctions;

import java.io.IOException;
import java.util.Scanner;

public class User {

    public static void getInput(String varOut) throws IOException {

        Scanner s = new Scanner(System.in);
        String data = s.nextLine();
        Variable.create(varOut, data);
        // Thats it
    }
}
