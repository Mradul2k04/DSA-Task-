class Solution {
    public int minimumIndex(List<Integer> nums) {
        int num = nums.get(0), count = 0, numCount = 0, n = nums.size();
        for (int x : nums) {
            if (num == x) count++;
            else count--;
            if (count == 0) {
                num = x;
                count = 1;
            }
        }
        for (int x : nums) {
            if (num == x) numCount++;
        }
        count = 0;
        for(int i = 0;i<n;i++){
            if(nums.get(i)==num) count++;
            int remaining = numCount-count;
            boolean left = count*2 > i+1;
            boolean right = remaining *2 > n-i-1;
            if(left && right) return i;
        }
        return -1;
    }
}