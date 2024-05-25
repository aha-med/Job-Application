package programAskedInZoho;

public class FindSubstringBetweenIndices {
    public static void main(String[] args) {
        String str1 = "this is a test string";
        String str2 = "tist";
        System.out.println(findSubstring(str1, str2));
    }

    public static String findSubstring(String str1, String str2) {
        int minLength = str1.length();
        int maxLength = -1;

        for (char ch : str2.toCharArray()) {
            int index = str1.indexOf(ch);
            if (index != -1) {
                if (index < minLength) {
                    minLength = index;
                }
                if (index > maxLength) {
                    maxLength = index;
                }
            }
        }

        if (minLength <= maxLength) {
            return str1.substring(minLength, maxLength + 1);
        } else {
            return "Characters not found in the correct order.";
        }
    }
}
