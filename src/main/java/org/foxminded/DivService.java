package org.foxminded;

public class DivService {
    private static final String SEP = System.lineSeparator();
    private final int dividend;
    private final int divisor;
    private final int[] dividendDigits;
    private int dividendIndex;
    private final int[] resultDigits;
    private int resultIndex;
    private int minuend; // уменьшаемое

    public DivService(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        dividendDigits = getDigitArray(dividend);
        resultDigits = getDigitArray(dividend / divisor);
        initMinuend();
    }

    public String getDivisionResult() {
        StringBuilder sb = new StringBuilder("_" + dividend + "|" + divisor + SEP);
        int result = dividend / divisor;
        sb.append(getSpaces(getLength(minuend) - getLength(getCurrentSubtrahend()) + 1))
                .append(getCurrentSubtrahend())
                .append(getSpaces(dividendDigits.length - getLength(minuend)))
                .append("|")
                .append(getMinuses(Math.max(resultDigits.length, getLength(divisor))))
                .append(SEP);
        sb.append(getSpaces(getLength(minuend) - getLength(getCurrentSubtrahend()) + 1))
                .append(getMinuses(getLength(getCurrentSubtrahend())))
                .append(getSpaces(dividendDigits.length - getLength(minuend)))
                .append("|")
                .append(result)
                .append(SEP);
        while (resultIndex < resultDigits.length - 1) {
            updateMinuend();
            sb.append(getSpaces(dividendIndex - getLength(minuend) + 1))
                    .append("_")
                    .append(minuend)
                    .append(SEP)
                    .append(getSpaces(dividendIndex - getLength(getCurrentSubtrahend()) + 2))
                    .append(getCurrentSubtrahend())
                    .append(SEP)
                    .append(getSpaces(dividendIndex - getLength(getCurrentSubtrahend()) + 2))
                    .append(getMinuses(getLength(getCurrentSubtrahend())))
                    .append(SEP);
        }
        updateMinuend();
        sb.append(getSpaces(dividendDigits.length - getLength(minuend) + 1))
                .append(minuend);
        return sb.toString();
    }

    private void updateMinuend() { // уменьшаемое
        int subtrahend = getCurrentSubtrahend();
        dividendIndex++;
        resultIndex++;
        minuend = minuend - subtrahend;
        if (dividendIndex < dividendDigits.length) {
            minuend = minuend * 10 + dividendDigits[dividendIndex];
        }
    }

    private void initMinuend() {
        minuend = dividendDigits[dividendIndex];
        while (minuend < getCurrentSubtrahend()) {
            minuend = minuend * 10 + dividendDigits[++dividendIndex];
        }
    }

    private int getCurrentSubtrahend() { // вычитаемое
        return divisor * resultDigits[resultIndex];
    }

    private String getSpaces(int quantity) {
        quantity = Math.max(0, quantity);
        return " ".repeat(quantity);
    }

    private String getMinuses(int quantity) {
        return "-".repeat(quantity);
    }

    private int getLength(int number) {
        return String.valueOf(number).length();
    }

    private int[] getDigitArray(int number) {
        int[] array = new int[getLength(number)];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = number % 10;
            number = number / 10;
        }
        return array;
    }
}
