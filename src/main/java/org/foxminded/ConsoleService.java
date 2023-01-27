package org.foxminded;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleService {
    private BufferedReader reader;

    public ConsoleService(BufferedReader reader) {
        this.reader = reader;
    }

    public void print(String text) {
        System.out.println(text);
    }

    public int getInt() {
        while (true) {
            print("Enter integer number:");
            String input = getString();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                print("Entered: '" + input + "' is not an integer number.");
            }
        }
    }

    public int getNonZeroInt() {
        while (true) {
            print("Enter non-zero integer number:");
            String input = getString();
            try {
                int result = Integer.parseInt(input);
                if (result != 0) {
                    return result;
                }
            } catch (NumberFormatException e) {
                print("Entered: '" + input + "' is not an integer number.");
            }
        }
    }

    public String getString() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Can not read string", e);
        }
    }
}
