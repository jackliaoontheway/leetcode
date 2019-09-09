package leetcode.primary.string;

public class AddBinary {

    public static void main(String[] args) {
        String a = "1", b = "111";
        System.out.print(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {

        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }

        int loops = a.length();
        if (a.length() > b.length()) {
            loops = b.length();
        } else {
            String temp = a;
            a = b;
            b = temp;
        }

        for (int i = 0; i < loops; i++) {

            char bx = b.charAt(b.length() - 1 - i);

            String aLeft = a.substring(0, a.length() - i);
            String aRight = a.substring(a.length() - i);
            aLeft = plusOne(aLeft, bx);
            a = aLeft + aRight;
        }

        return a;
    }

    private static String plusOne(String result, char bx) {
        if (bx == '0') {
            return result;
        }
        for (int i = result.length() - 1; i >= 0; i--) {
            char x = result.charAt(i);
            if (x == '1') {
                if (i == result.length() - 1) {
                    result = (result.substring(0, i) + '0');
                } else {
                    result = (result.substring(0, i) + '0') + result.substring(i + 1);
                }
            } else {
                return result.substring(0, i) + bx + result.substring(i + 1);
            }
        }
        return '1' + result;
    }


}
