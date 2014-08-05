/*
 * Copyright (C) 2007 - 2014 Hyperweb2 All rights reserved.
 * GNU General Public License version 3; see www.hyperweb2.com/terms/
 */
package hw2.java.library.common;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedDefines {

    private static final SimpleDateFormat dataFormatter = new SimpleDateFormat("dd/MM/yyyy");

    private static NumberFormat currencyFormat;
    private static NumberFormat integerFormat;

    public static String getDataFormat(Date data) {
        return dataFormatter.format(data);
    }

    static {

    }

    public static NumberFormat getCurrencyFormat() {
        if (currencyFormat == null) {
            currencyFormat = NumberFormat.getNumberInstance();
            currencyFormat.setMaximumFractionDigits(2);
            currencyFormat.setGroupingUsed(false);
            currencyFormat.setRoundingMode(RoundingMode.HALF_UP);
        }

        return currencyFormat;
    }

    public static NumberFormat getIntegerFormat() {
        if (integerFormat == null) {
            integerFormat = NumberFormat.getNumberInstance();
            integerFormat.setMaximumFractionDigits(0);
            integerFormat.setGroupingUsed(false);
            integerFormat.setRoundingMode(RoundingMode.HALF_UP);
        }

        return integerFormat;
    }
}
