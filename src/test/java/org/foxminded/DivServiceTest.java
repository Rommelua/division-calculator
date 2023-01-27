package org.foxminded;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DivServiceTest {
    private DivService divService;

    @Test
    void getDivisionResult_ZeroDividend_Ok() {
        String expected =
            "_0|4"  + System.lineSeparator() +
            " 0|-"  + System.lineSeparator() +
            " -|0"  + System.lineSeparator() +
            " 0";
        divService = new DivService(0, 4);
        String actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDivisionResult_DividendMoreThenDivisor_ZeroReminder() {
        String expected =
            "_100000|25"    + System.lineSeparator() +
            " 100   |----"  + System.lineSeparator() +
            " ---   |4000"  + System.lineSeparator() +
            "   _0"         + System.lineSeparator() +
            "    0"         + System.lineSeparator() +
            "    -"         + System.lineSeparator() +
            "    _0"        + System.lineSeparator() +
            "     0"        + System.lineSeparator() +
            "     -"        + System.lineSeparator() +
            "     _0"       + System.lineSeparator() +
            "      0"       + System.lineSeparator() +
            "      -"       + System.lineSeparator() +
            "      0";
        divService = new DivService(100000, 25);
        String actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);

        expected =
            "_7042035|7"        + System.lineSeparator() +
            " 7      |-------"  + System.lineSeparator() +
            " -      |1006005"  + System.lineSeparator() +
            " _0"               + System.lineSeparator() +
            "  0"               + System.lineSeparator() +
            "  -"               + System.lineSeparator() +
            "  _4"              + System.lineSeparator() +
            "   0"              + System.lineSeparator() +
            "   -"              + System.lineSeparator() +
            "  _42"             + System.lineSeparator() +
            "   42"             + System.lineSeparator() +
            "   --"             + System.lineSeparator() +
            "    _0"            + System.lineSeparator() +
            "     0"            + System.lineSeparator() +
            "     -"            + System.lineSeparator() +
            "     _3"           + System.lineSeparator() +
            "      0"           + System.lineSeparator() +
            "      -"           + System.lineSeparator() +
            "     _35"          + System.lineSeparator() +
            "      35"          + System.lineSeparator() +
            "      --"          + System.lineSeparator() +
                "       0";
        divService = new DivService(7042035, 7);
        actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDivisionResult_DividendMoreThenDivisor_PositiveRemainder() {
        String expected =
            "_78945|4"      + System.lineSeparator() +
            " 4    |-----"  + System.lineSeparator() +
            " -    |19736"  + System.lineSeparator() +
            "_38"           + System.lineSeparator() +
            " 36"           + System.lineSeparator() +
            " --"           + System.lineSeparator() +
            " _29"          + System.lineSeparator() +
            "  28"          + System.lineSeparator() +
            "  --"          + System.lineSeparator() +
            "  _14"         + System.lineSeparator() +
            "   12"         + System.lineSeparator() +
            "   --"         + System.lineSeparator() +
            "   _25"        + System.lineSeparator() +
            "    24"        + System.lineSeparator() +
            "    --"        + System.lineSeparator() +
            "     1";
        divService = new DivService(78945, 4);
        String actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);

        expected =
            "_1001|33"   + System.lineSeparator() +
            "  99 |--"   + System.lineSeparator() +
            "  -- |30"   + System.lineSeparator() +
            "  _11"      + System.lineSeparator() +
            "    0"      + System.lineSeparator() +
            "    -"      + System.lineSeparator() +
            "   11";
        divService = new DivService(1001, 33);
        actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDivisionResult_AbsDividendLessThenAbsDivisor_Ok() {
        String expected =
            "_1|100"  + System.lineSeparator() +
            " 0|---"  + System.lineSeparator() +
            " -|0"    + System.lineSeparator() +
            " 1";
        divService = new DivService(1, 100);
        String actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getDivisionResult_AbsDividendEqualsAbsDivisor_Ok() {
        String expected =
            "_1|1"  + System.lineSeparator() +
            " 1|-"  + System.lineSeparator() +
            " -|1"  + System.lineSeparator() +
            " 0";
        divService = new DivService(1, 1);
        String actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);

        expected =
            "_10|10"   + System.lineSeparator() +
            " 10|--"   + System.lineSeparator() +
            " --|1"    + System.lineSeparator() +
            "  0";
        divService = new DivService(10, 10);
        actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);

        expected =
            "_333|310"   + System.lineSeparator() +
            " 310|---"   + System.lineSeparator() +
            " ---|1"     + System.lineSeparator() +
            "  23";
        divService = new DivService(333, 310);
        actual = divService.getDivisionResult();
        Assertions.assertEquals(expected, actual);
    }
}