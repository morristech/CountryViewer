package com.example.arman.testproject.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {

    public static String getIndentedNumber(long number) {
        return NumberFormat.getNumberInstance(Locale.getDefault()).format(number);
    }
}
