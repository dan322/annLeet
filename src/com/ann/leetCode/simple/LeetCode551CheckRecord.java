package com.ann.leetCode.simple;

public class LeetCode551CheckRecord {

    /**
     * PPALLP   true
     * PPALLL   false
     *
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int continueLate = 0, absentNum = 0, continueLateNum = 0;
        for (char ch: s.toCharArray()) {
            if (ch == 'A')
                absentNum++;
            if (ch == 'L') {
                continueLate++;
            } else {
                continueLateNum = Math.max(continueLateNum, continueLate);
                continueLate = 0;
            }
        }
        continueLateNum = Math.max(continueLateNum, continueLate);
        return absentNum < 2 && continueLateNum < 3;
    }

    public boolean checkRecord1(String s) {
        int continueLate = 0, absentNum = 0;
        for (char ch: s.toCharArray()) {
            if (ch == 'A') {
                absentNum++;
                if (absentNum > 1)
                    return false;
            }
            if (ch == 'L') {
                continueLate++;
                if (continueLate > 2)
                    return false;
            } else {
                continueLate = 0;
            }
        }
        return true;
    }

    public boolean checkRecord2(String s) {
        int countA = 0;
        for (int i = 0; i < s.length() && countA < 2; i++) {
            if (s.charAt(i) == 'A')
                countA++;
            if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
                return false;
        }
        return countA < 2;
    }

    public boolean checkRecord3(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA > 1)
                    return false;
            }
        }
        return s.indexOf("LLL") < 0;
    }
}
