/*
 * Copyright (C) 2007 - 2014 Hyperweb2 All rights reserved.
 * GNU General Public License version 3; see www.hyperweb2.com/terms/
 */
package hw2.java.library.common;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;

/**
 * Various methods to implement generic features .
 *
 * Ronca
 */
public class StringTools {


    /**
     * Formatted mask.
     *
     * @param strMask the str mask
     * @return the mask formatter
     */
    public static MaskFormatter formattedMask(String strMask) {
        MaskFormatter mask = null;
        try {
            //
            // Create a MaskFormatter for accepting phone number, the # symbol accept
            // only a number. We can also set the empty value with a place holder
            // character.
            //
            mask = new MaskFormatter(strMask);
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return mask;
    }
}
