using System;
using System.Collections.Generic;

class FirstNonRepeating
{
    static char? FindFirstNonRepeating(string s)
    {
        var countMap = new Dictionary<char, int>();

        foreach (char c in s)
        {
            countMap[c] = countMap.GetValueOrDefault(c, 0) + 1;
        }

        foreach (char c in s)
        {
            if (countMap[c] == 1)
                return c;
        }

        return null;
    }

    static void Main(string[] args)
    {
        string[] testCases = { "swiss", "aabbcc", "abcabc", "leetcode" };

        foreach (string s in testCases)
        {
            char? result = FindFirstNonRepeating(s);
            if (result.HasValue)
                Console.WriteLine($"First non-repeating character in \"{s}\": {result}");
            else
                Console.WriteLine($"No non-repeating character found in \"{s}\"");
        }
    }
}
