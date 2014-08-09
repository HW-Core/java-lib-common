/*
 * Copyright (C) 2007 - 2014 Hyperweb2 All rights reserved.
 * GNU General Public License version 3; see www.hyperweb2.com/terms/
 */
package hw2.java.library.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class DigitTools {
    private static NumberFormat currencyFormat;
    private static NumberFormat integerFormat;

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
    
    
    /**
     * Round decimal pos.
     *
     * @param val the val
     * @param pos the pos
     * @return the double
     */
    public static double RoundDecimalPos(double val, int pos) {
        return new BigDecimal(val).setScale(pos, RoundingMode.HALF_UP).doubleValue();
    }
}
