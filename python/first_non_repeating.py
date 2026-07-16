def first_non_repeating(s: str) -> str | None:
    count_map = {}

    for c in s:
        count_map[c] = count_map.get(c, 0) + 1

    for c in s:
        if count_map[c] == 1:
            return c

    return None


if __name__ == "__main__":
    test_cases = ["swiss", "aabbcc", "abcabc", "leetcode"]

    for s in test_cases:
        result = first_non_repeating(s)
        if result:
            print(f'First non-repeating character in "{s}": {result}')
        else:
            print(f'No non-repeating character found in "{s}"')
