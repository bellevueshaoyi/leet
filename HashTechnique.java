// https://leetcode.com/articles/hash-table/.
// ASCII has 128 characters.

private static void printFreq(char[] str) {
  int[] freq = new int[256];
  for (int i=0; i<str.length; ++i) {
    freq[str[i]]++;
  }
  for (int i=0; i<256; ++i) {
    System.out.println(freq[i]);
  }
}
