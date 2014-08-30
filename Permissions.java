package hw2.java.library.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author giuseppe
 */
public class Permissions {

    protected Map<Integer, Value> perms; // level - mask

    public static class Value {

        public final int own;
        public final int other;

        public Value(int own, int other) {
            this.own = own;
            this.other = other;
        }

        public Value(PList[] own, PList[] other) {
            this(createPerms(own), createPerms(other));
        }

        /**
         * 
         * @param own permissions on own data
         * @param other extends own permissions to other
         */
        public Value(PList[] own, boolean other) {
            this(own, other ? own : new PList[]{});
        }
        
        public Value(PList[] own) {
            this(own, false);
        }

    }

    public enum PList {

        DENIED, // 0
        READ, // 1
        ADD, // 2
        UPDATE, // 4
        DELETE, // 8
        ALL; // 16

        private final int val;

        private PList() {
            this.val = (int) Math.pow(2, this.ordinal());
        }

        public int getVal() {
            return val;
        }
    }

    public Permissions(Map<Integer,Value> perms) {
        this.perms=perms;
    }

    public Permissions() {
        this.perms=new HashMap<>();
    }

    protected void setPerms(Map<Integer, Value> perms) {
        this.perms = perms;
    }

    public Map<Integer, Value> getPerms() {
        return perms;
    }

    public static int createPerms(PList... perms) {
        int res = 0;
        for (PList p : perms) {
            res += p.getVal();
        }

        return res;
    }

    public boolean can(int userLvl, boolean other, PList... perms) {
        // acquire permissions of the user level
        Value v = this.perms.get(userLvl);
        // if no permission specified for user level, then deny everything
        if (v==null)
            return false;
        
        ArrayList<Integer> pList = DigitTools.bitMask(other ? v.other : v.own);
        // if there are no permissions or is explicity DENIED, then return false
        if (pList.isEmpty() || pList.contains(PList.DENIED))
            return false;
        
        // if contains ALL, then we can do everything
        if (pList.contains(PList.ALL)) {
            return true;
        }
        
        // convert passed list to integer list 
        ArrayList<Integer> passedList = new ArrayList<>();
        for (PList val : Arrays.asList(perms)) {
            passedList.add(val.getVal());
        }
        // check if user lvl has all passed permissions
        for (Integer p : passedList) {
            if (!pList.contains(p)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check in both own and other permissions
     *
     * @param userLvl
     * @param perms
     * @return
     */
    public boolean can(int userLvl, PList... perms) {
        return this.can(userLvl, true, perms) && this.can(userLvl, false, perms);
    }
}
