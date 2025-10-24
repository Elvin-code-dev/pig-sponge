public class Pig {

    /*
     * Create a method "pigLatin" that takes a string consisting of one or more
     * all-lowercase words separated by spaces. It should return a new string
     * converted to "pig Latin," where each word has its first letter moved to
     * the back and the letters "ay" are added to the end of the word. However,
     * words starting with a vowel (a, e, i, o, or u) should not be altered.
     *
     * Examples:
     *
     * pigLatin("something") should return "omethingsay"
     * pigLatin("awesome") should return "awesome" (words starting with a vowel
     * should not be altered)
     * pigLatin("latin is a hard language") should return
     * "atinlay is a ardhay anguagelay"
     * pigLatin("y") should return "yay"
     * pigLatin("e") should return "e"
     */
    public static void main(String[] args) {
        // Test cases
        assertEqual(1, pigLatin("something"), "omethingsay");
        assertEqual(2, pigLatin("awesome"), "awesome");
        assertEqual(3, pigLatin("latin is a hard language"), "atinlay is a ardhay anguagelay");
        assertEqual(4, pigLatin("y"), "yay");
        assertEqual(5, pigLatin("e"), "e");
    }

    // Implement your solution here!
    public static String pigLatin(String sentence) {
        // we need to split the sentence into individual words
        String[] words = sentence.split(" ");
        String result = "";

        // now here we want to go through each word and convert it
        for (String word : words) {
            result += toPigLatin(word);
            result += " "; // forgot a dumb space here was so confused for so long
        }

        // now we want to remove the last extra space
        result = result.substring(0, result.length() - 1);

        return result;
    }

    // here we gonna use a helper method that converts one word into Pig Latin
    private static String toPigLatin(String word) {
        // gonna check if the first letter is a vowel
        char first = word.charAt(0);
        if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
            return word;
        }

        String changed = word.substring(1) + first + "ay";
        return changed;
    }

    // Method to help with testing, you do not need to read this.
    public static void assertEqual(int testNumber, String actual, String expected) {
        if (!expected.equals(actual)) {
            System.out
                    .println("Test " + testNumber + " failed! Expected: '" + expected + "', but got: '" + actual + "'");
        } else {
            System.out.println("Test " + testNumber + " passed!");
        }
    }
}
