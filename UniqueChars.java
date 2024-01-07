/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {
        String strUnique = "";
        strUnique = strUnique + s.charAt(0);
        boolean flag = true;
        for (int i = 1; i < s.length(); i++) {
            flag = true;
            if (s.charAt(i) != ' ') {
                for (int j = 0; j < strUnique.length() && flag; j++) {
                    if (s.charAt(i) == strUnique.charAt(j)) {
                        flag = false;
                    }
                }
            }
            if (flag == true) {
                strUnique = strUnique + s.charAt(i);
            }

        }
        return strUnique;
    }
}