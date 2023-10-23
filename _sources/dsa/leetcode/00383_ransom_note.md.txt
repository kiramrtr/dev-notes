# 383. Ransom Note

```{code-block} java
:linenos:
:dedent: 2

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] count = new int[26];

    for (char c : magazine.toCharArray()) {
      count[c - 'a']++;
    }

    for (char c : ransomNote.toCharArray()) {
      if (count[c - 'a'] == 0) {
        return false;
      }
      count[c - 'a']--;
    }

    for (int i : count) {
      if (i < 0) return false;
    }

    return true;
  }
```
