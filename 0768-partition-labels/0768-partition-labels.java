class Solution {
  public List<Integer> partitionLabels(String s) {
    List<Integer> ans = new ArrayList<>();
    int[] rightmost = new int[26];

    for (int i = 0; i < s.length(); ++i)
      rightmost[s.charAt(i) - 'a'] = i;

    int l = 0; 
    int r = 0; 

    for (int i = 0; i < s.length(); ++i) {
      r = Math.max(r, rightmost[s.charAt(i) - 'a']);
      if (r == i) {
        ans.add(i - l + 1);
        l = i + 1;
      }
    }

    return ans;
  }
}