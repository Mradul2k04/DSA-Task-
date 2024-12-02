class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

        Arrays.sort(nums);
        int previousElement;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            previousElement = nums[i - 1];
            if (nums[i] == previousElement) {
                count++;
            } else {
                map.putIfAbsent(count, new ArrayList<>());
                map.get(count).add(previousElement);
                count = 1;
            }

            if (i == nums.length - 1) {
                map.putIfAbsent(count, new ArrayList<>());
                map.get(count).add(nums[i]);
            }
        }

        int[] result = new int[k];
        List<Integer> mergedValues = new ArrayList<>();

        for (List<Integer> list : map.values()) {
            mergedValues.addAll(list);
        }

        for (int i = 0; i < k; i++) {
            result[i] = mergedValues.get(i);
        }

        return result;
    }
}