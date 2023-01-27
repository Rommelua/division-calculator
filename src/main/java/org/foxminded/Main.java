package org.foxminded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String GREETING = "<======== HELLO! This is division program ========>";
    private static final String HELP_MESSAGE = "I can divide two integer numbers. "
                                             + System.lineSeparator()
                                             + "Give me dividend and divisor";
    private static final String BAY_MESSAGE = "<======== Good Bay! ========>";
    private static final String POST_DIVISION_MESSAGE =
            "You can print 'exit' to leave the program or press ENTER to continue.";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            ConsoleService consoleService = new ConsoleService(reader);
            consoleService.print(GREETING);
            boolean isExit = false;
            while (!isExit) {
                consoleService.print(HELP_MESSAGE);
                int dividend = consoleService.getInt();
                int divisor = consoleService.getNonZeroInt();
                DivService divService = new DivService(dividend, divisor);
                String divisionResult = divService.getDivisionResult();
                consoleService.print(divisionResult);
                consoleService.print(POST_DIVISION_MESSAGE);
                String exitInput = consoleService.getString();
                if ("exit".equalsIgnoreCase(exitInput)) {
                    isExit = true;
                }
            }
            consoleService.print(BAY_MESSAGE);
        }
    }
}
