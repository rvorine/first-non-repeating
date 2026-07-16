[![Instagram](https://img.shields.io/badge/Instagram-%40Lacopydepastel-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/Lacopydepastel)
[![YouTube](https://img.shields.io/badge/YouTube-%40rvorine-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/@rvorine)

# First Non-Repeating Character

Find the **first character** in a string that does not repeat anywhere else in the string.

## Problem Statement

Given a string, find and return the first character that appears exactly once.  
If no such character exists, return `null` / `None`.

**Examples:**

| Input       | Output | Explanation                                      |
|-------------|--------|--------------------------------------------------|
| `"swiss"`   | `'w'`  | `s` repeats, `w` appears only once               |
| `"aabbcc"`  | `null` | Every character repeats                          |
| `"abcabc"`  | `null` | Every character repeats                          |
| `"leetcode"` | `'l'` | `l` is the first character that appears only once |

## Algorithm

1. Iterate through the string and build a frequency map (character → count).
2. Iterate through the string a second time and return the first character whose count equals 1.
3. If no such character is found, return `null` / `None`.

**Time Complexity:** O(n)  
**Space Complexity:** O(k) — where k is the number of unique characters in the input

---

## Implementations

### Java — [`java/src/FirstNonRepeating.java`](java/src/FirstNonRepeating.java)

Uses `LinkedHashMap` to preserve insertion order, ensuring the first unique character is found correctly.

```java
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
}
```

**Run:**
```bash
cd java/src
javac FirstNonRepeating.java
java FirstNonRepeating
```

---

### Kotlin — [`kotlin/src/FirstNonRepeating.kt`](kotlin/src/FirstNonRepeating.kt)

```kotlin
fun firstNonRepeating(s: String): Char? {
    val countMap = LinkedHashMap<Char, Int>()

    for (c in s) {
        countMap[c] = (countMap[c] ?: 0) + 1
    }

    for ((char, count) in countMap) {
        if (count == 1) return char
    }

    return null
}
```

**Run:**
```bash
cd kotlin/src
kotlinc FirstNonRepeating.kt -include-runtime -d FirstNonRepeating.jar
java -jar FirstNonRepeating.jar
```

---

### C# — [`csharp/src/FirstNonRepeating.cs`](csharp/src/FirstNonRepeating.cs)

```csharp
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
```

**Run:**
```bash
cd csharp/src
dotnet-script FirstNonRepeating.cs
# or compile with csc / dotnet
```

---

### Python — [`python/first_non_repeating.py`](python/first_non_repeating.py)

```python
def first_non_repeating(s: str) -> str | None:
    count_map = {}

    for c in s:
        count_map[c] = count_map.get(c, 0) + 1

    for c in s:
        if count_map[c] == 1:
            return c

    return None
```

**Run:**
```bash
cd python
python first_non_repeating.py
```

---

## Repository Structure

```
first-non-repeating/
├── java/
│   └── src/
│       └── FirstNonRepeating.java
├── kotlin/
│   └── src/
│       └── FirstNonRepeating.kt
├── csharp/
│   └── src/
│       └── FirstNonRepeating.cs
├── python/
│   └── first_non_repeating.py
└── README.md
```
