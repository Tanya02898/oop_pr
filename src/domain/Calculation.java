package domain;

import java.io.*;

public class Calculation {
    public String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    public String toOctal(int number) {
        return Integer.toOctalString(number);
    }

    public String toHexadecimal(int number) {
        return Integer.toHexString(number);
    }
}
