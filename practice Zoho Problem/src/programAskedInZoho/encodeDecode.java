package programAskedInZoho;

class encodeDecode {
    static int index = 0; // global index to traverse the string

    static String decodedString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (Character.isDigit(s.charAt(index))) {
                // Get the number of times to repeat
                int repeat = 0;
                while (Character.isDigit(s.charAt(index))) {
                    repeat = repeat * 10 + (s.charAt(index) - '0');
                    index++;
                }

                // Skip the '['
                index++;

                // Recursively get the characters inside the brackets
                String decodedSubstring = decodedString(s);

                // Append the repeated substring to the result
                for (int i = 0; i < repeat; i++) {
                    result.append(decodedSubstring);
                }

                // Move index past the ']'
                index++;
            } else {
                // Append characters to result
                result.append(s.charAt(index));
                index++;
            }
        }
        return result.toString();
    }

    // Wrapper function to reset global index and call recursive decoding
    public static String recursiveDecodedString(String s) {
        index = 0;
        return decodedString(s);
    }
    public static void main(String[] args) {
        String encoded = "3[b2[ca]]";
        System.out.println(encodeDecode.recursiveDecodedString(encoded)); // Output: "aaabcbc"
    }

}

