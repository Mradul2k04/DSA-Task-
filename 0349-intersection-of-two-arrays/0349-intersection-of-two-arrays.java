class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer>set=new HashSet<>();
        ArrayList<Integer>list=new ArrayList<>();
        for(int val:nums1){
            set.add(val);
        }
        for(int val:nums2){
            if(set.contains(val)){
                set.remove(val);
                list.add(val);
            }
        }
        int arr[]=new int[list.size()];
        int i=0;
        for(int val:list){
            arr[i++]=val;
        }
        return arr;
    }
}