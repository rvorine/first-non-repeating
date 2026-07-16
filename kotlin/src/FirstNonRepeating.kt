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

fun main() {
    val testCases = listOf("swiss", "aabbcc", "abcabc", "leetcode")

    for (s in testCases) {
        val result = firstNonRepeating(s)
        if (result != null) {
            println("First non-repeating character in \"$s\": $result")
        } else {
            println("No non-repeating character found in \"$s\"")
        }
    }
}
