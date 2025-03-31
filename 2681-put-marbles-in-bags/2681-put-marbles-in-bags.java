class Solution {

    private long getMaxScore(int[] weights, int k) {
        int n = weights.length;
        int[] scores = new int[n - 1];
        for (int i = 0; i < n - 1; i++)
            scores[i] = weights[i + 1] + weights[i];
        Arrays.sort(scores);
        long ans = 0;
        for (int i = n - 2; i >= n - k; i--)
            ans += scores[i];
        return ans;
    }

    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1)
            return 0;
        
        long maxScore = getMaxScore(weights, k);
        for (int i = 0; i < n; i++)
            weights[i] = -weights[i];
        long minScore = -1 * getMaxScore(weights, k);

        return maxScore - minScore;
    }
}