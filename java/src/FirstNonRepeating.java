import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {

    public static Character firstNonRepeating(String s) {
        LinkedHashMap<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String[] testCases = {"swiss", "aabbcc", "abcabc", "leetcode"};

        for (String s : testCases) {
            Character result = firstNonRepeating(s);
            if (result != null) {
                System.out.println("First non-repeating character in \"" + s + "\": " + result);
            } else {
                System.out.println("No non-repeating character found in \"" + s + "\"");
            }
        }
    }
}
