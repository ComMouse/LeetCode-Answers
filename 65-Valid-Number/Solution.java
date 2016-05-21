public class Solution {
    public static final int CHAR_DIGIT = 0;
    public static final int CHAR_DOT = 1;
    public static final int CHAR_E = 2;
    public static final int CHAR_SIGN = 3;
    public static final int CHAR_OTHER = 4;
    
    public boolean isNumber(String s) {
        s = s.trim();
        int index = -1;
        int length = s.length();
        
        char c;
        
        boolean hasSign = false;
        boolean hasPrefix = false;
        boolean hasDot = false;
        boolean hasSuffix = false;
        
        boolean hasE = false;
        boolean hasExponentSign = false;
        boolean hasExponent = false;
        
        while (++index < length) {
            c = s.charAt(index);
            
            switch (getCharType(c)) {
                case CHAR_E:
                    if (hasE) return false;
                    if (!hasPrefix && !hasSuffix) return false;
                    hasE = true;
                    break;
                case CHAR_DOT:
                    // Dot should appear only once after prefix
                    if (hasDot || hasSuffix || hasE) return false;
                    hasDot = true;
                    break;
                case CHAR_SIGN:
                    if (hasE) {
                        if (hasExponent || hasExponentSign) return false;
                        hasExponentSign = true;
                    } else {
                        // Sign should appear only before prefix & dot
                        if (hasSign || hasPrefix || hasDot) return false;
                        hasSign = true;
                    }
                    break;
                case CHAR_DIGIT:
                    if (!hasPrefix) hasPrefix = true;
                    if (hasDot && !hasSuffix) hasSuffix = true;
                    if (hasE && !hasExponent) hasExponent = true;
                    break;
                default:
                    return false;
            }
        }
        
        // A complete number (hasPrefix or hasSuffix) and with correct exponent (e + (sign) + digit)
        return (hasPrefix || hasSuffix) && (!hasE || (hasE && hasExponent));
    }
    
    private int getCharType(char c) {
        if (c >= '0' && c <= '9')
            return CHAR_DIGIT;
            
        if (c == '.')
            return CHAR_DOT;
            
        if (c == '+' || c == '-')
            return CHAR_SIGN;
        
        if (c == 'e' || c == 'E')
            return CHAR_E;
            
        return CHAR_OTHER;
    }
}