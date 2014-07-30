/*
 * Copyright (C) 2007 - 2014 Hyperweb2 All rights reserved.
 * GNU General Public License version 3; see www.hyperweb2.com/terms/
 */

package Hw2.Java.library.common;

public class VarAccessors<T> {

    public static VarAccessors createAccessors(Object obj) {
        return obj instanceof Boolean
            ? new VarAccessors.Bool((Boolean) obj)
            : new VarAccessors</*generic type*/>(obj);
    }

    protected T val;

    public VarAccessors(T val) {
        this.val = val;
    }

    public T getValue() {
        return val;
    }

    public void setValue(T val) {
        this.val = val;
    }

    /**
     * Subtype of RecordValue
     */
    public static class Bool extends VarAccessors<Boolean> {

        public Bool(boolean val) {
            super(val);
        }

        public boolean isTrue() {
            return val == true;
        }
    }
}
